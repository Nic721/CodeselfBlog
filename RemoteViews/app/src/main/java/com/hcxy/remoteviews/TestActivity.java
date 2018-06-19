package com.hcxy.remoteviews;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "TestActivity";

    private Button mButton1;
    private View mButton2;

    private static int sId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        mButton1 = findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                sId++;
                Notification notification = new Notification();
                notification.icon = R.mipmap.ic_launcher;
                notification.tickerText = "hello world";
                notification.when = System.currentTimeMillis();
                notification.flags = Notification.FLAG_AUTO_CANCEL;
                Intent intent = new Intent(this, DemoActivity_2.class);
                break;
            case R.id.button2:

                break;
            default:
                break;
        }
    }
}
