package com.hcxy.socket_learning;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    /**
     * 主线程 变量
     */
    // 主线程Handler
    // 用于将服务器获取的消息显示出来
    private Handler mMainHandler;
    // Socket变量
    private Socket socket;

    // 线程池
    // 为了方便展示，此处直接采用线程池进行线程管理，而没有一个个开线程
    private ExecutorService mThreadPool;

    /**
     * 接收服务器消息 变量
     */
    // 输入流对象
    InputStream is;

    // 输入流读取器对象
    InputStreamReader isr;
    BufferedReader br;

    PrintWriter pw;
    // 接收服务器发送过来的消息
    String response;

    /**
     * 发送消息到服务器 变量
     */
    // 输出流对象
    OutputStream os;

    // 输出流输入器对象
    OutputStreamWriter osw;
    BufferedWriter bw;
    // 发送到服务器的请求
    String request;

    /**
     * 按钮 变量
     */
    // 连接 断开连接 发送数据到服务器 的按钮变量
    private Button btnConnect,btnDisconnect,btnSend;
    // 显示接收服务器消息 按钮
    private TextView Receive,receive_message;
    // 输入需要发送的消息 输入框
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 初始化操作
         */
        // 初始化所有按钮
        btnConnect = findViewById(R.id.connect);
        btnDisconnect = findViewById(R.id.disconnect);
        btnSend = findViewById(R.id.send);
        mEdit = findViewById(R.id.edit);
        receive_message = findViewById(R.id.receive_message);
        Receive = findViewById(R.id.Receive);

        // 初始化线程池
        mThreadPool = Executors.newCachedThreadPool();

        // 实例化主线程，用于更新接收过来的消息
        mMainHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        receive_message.setText(response);
                        break;
                }
            }
        };

        /**
         * 创建客户端 & 服务器的链接
         */
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 利用线程池直接开启一个线程 & 执行该线程
                mThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 创建Socket对象 & 指定服务器的IP及端口号
                            socket = new Socket("192.168.1.172",8989);
                            // 判断客户端和服务器是否连接成功
                            System.out.println(socket.isConnected());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        /**
         * 接收服务器信息
         */
        Receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 利用线程池直接开启一个线程 & 执行该线程
                mThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 步骤1：创建输入流对象InputStream
                            is = socket.getInputStream();

                            // 步骤2：创建输入流读取器对象 并传入输入流对象
                            // 该对象作用：获取服务器返回的数据
                            isr = new InputStreamReader(is);
                            br = new BufferedReader(isr);

                            // 步骤3：通过输入流读取器对象 接收服务器发送过来的数据
                            response = br.readLine();

                            // 步骤4:通知主线程,将接收的消息显示到界面
                            Message msg = Message.obtain();
                            msg.what = 0;
                            mMainHandler.sendMessage(msg);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

        /**
         * 发送消息给服务器
         */
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 利用线程池直接开启一个线程 & 执行该线程
                mThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 步骤1：从Socket 获得输出流对象OutputStream
                            // 该对象作用：发送数据
                            os = socket.getOutputStream();

                            // 输入流读取器对象
                            osw = new OutputStreamWriter(os);
                            bw = new BufferedWriter(osw);

                            pw = new PrintWriter(bw);

                            request = mEdit.getText().toString();
                            pw.print(request);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        /**
         * 断开客户端 & 服务器的链接
         */
        btnDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // 断开 客户端发送到服务器 的连接，即关闭输出流对象OutputStream
                    pw.close();

                    // 断开 服务器发送到客户端 的连接，即关闭输入流读取器对象BufferedReader
                    br.close();

                    // 最终关闭整个Socket连接
                    socket.close();

                    // 判断客户端和服务器是否已经断开连接
                    System.out.println(socket.isConnected());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
