package com.hcxy.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button instablish;
    private Button insert;
    private Button upgrade;
    private Button modify;
    private Button delete;
    private Button query;
    private Button delete_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定按钮
        instablish = findViewById(R.id.instablish);
        insert = findViewById(R.id.insert);
        upgrade = findViewById(R.id.upgrade);
        modify = findViewById(R.id.modify);
        delete = findViewById(R.id.delete);
        query = findViewById(R.id.query);
        delete_database = findViewById(R.id.delete_database);

        // 设置监听器
        instablish.setOnClickListener(this);
        insert.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        modify.setOnClickListener(this);
        delete.setOnClickListener(this);
        query.setOnClickListener(this);
        delete_database.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // 点击创建数据库
            case R.id.instablish:
                System.out.println(TAG + "创建数据库");
                // 创建SQLiteOpenHelper子类对象
                MySQLiteOpenHelper dbHelper = new MySQLiteOpenHelper(this,"test_carson");
                // 数据库实际上是没有被创建或者打开的，直到getWritableDatabase() 或者 getReadableDatabase() 方法中的一个被调用时才会进行创建或者打开
                SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
                // SQLiteDatabase  sqliteDatabase = dbHelper.getReadbleDatabase();
                break;
            // 点击更新数据
            case R.id.upgrade:
                System.out.println(TAG + "更新数据库");
                // 创建SQLiteOpenHelper子类对象
                MySQLiteOpenHelper dbHelper_upgrade = new MySQLiteOpenHelper(this,"test_carson",2);
                // 调用getWritableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase_upgrade = dbHelper_upgrade.getWritableDatabase();
//                SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
                break;
            // 点击插入数据到数据库
            case R.id.insert:
                System.out.println(TAG + "插入数据");
                // 创建SQLiteOpenHelper子类对象
                MySQLiteOpenHelper dbHelper1 = new MySQLiteOpenHelper(this,"test_carson",2);
                // 调用getWritableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqLiteDatabase1 = dbHelper1.getWritableDatabase();
                // 创建ContentValues对象
                ContentValues values1 = new ContentValues();
                // 向该对象中插入键值对
                values1.put("id",1);
                values1.put("name","carson");
                // 调用insert()方法将数据插入到数据库当中
                sqLiteDatabase1.insert("user",null,values1);
//                sqLiteDatabase1.execSQL("insert into user(id,name) values (1,'carson')");

                // 关闭数据库
                sqLiteDatabase1.close();
                break;
            // 点击查询数据库
            case R.id.query:
                System.out.println(TAG + "查询数据");
                // 创建DatabaseHelper对象
                MySQLiteOpenHelper dbHelper4 = new MySQLiteOpenHelper(MainActivity.this,"test_carson",2);
                // 调用getWritableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase4 = dbHelper4.getReadableDatabase();
                // 调用SQLiteDatabase对象的query方法进行查询
                // 返回一个Cursor对象：由数据库查询返回的结果集对象
                Cursor cursor = sqliteDatabase4.query("user", new String[] { "id",
                        "name" }, "id=?", new String[] { "1" }, null, null, null);


                String id = null;
                String name = null;

                // 将光标移动到下一行，从而判断该结果集是否还有下一条数据
                // 如果有则返回true，没有则返回false
                while (cursor.moveToNext()){
                    id = cursor.getString(cursor.getColumnIndex("id"));
                    name = cursor.getString(cursor.getColumnIndex("name"));
                    // 输出查询结果
                    System.out.println("查询到的数据是："+"id:"+id+"name:"+name);
                }
                break;
            // 点击修改数据
            case R.id.modify:
                System.out.println(TAG + "修改数据");
                // 创建一个DatabaseHelper对象
                // 将数据库的版本升级为2
                // 传入版本号为2，大于旧版本（1），所以会调用onUpgrade()升级数据库
                MySQLiteOpenHelper dbHelper2 = new MySQLiteOpenHelper(MainActivity.this,"test_carson",2);
                // 调用getWritableDatabase()得到一个可写的SQLiteDatabase对象
                SQLiteDatabase sqLiteDatabase2 = dbHelper2.getWritableDatabase();
                // 创建一个ContentValues对象
                ContentValues values2 = new ContentValues();
                values2.put("name","amoshcxy");
                // 调用update方法修改数据库
                sqLiteDatabase2.update("user",values2,"id=?",new String[]{"1"});
                // 关闭数据库
                sqLiteDatabase2.close();
                break;
            // 点击删除数据
            case R.id.delete:
                System.out.println(TAG + "删除数据");
                // 创建DatabaseHelper对象
                MySQLiteOpenHelper dbHelper3 = new MySQLiteOpenHelper(MainActivity.this,"test_carson",2);

                // 调用getWritableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase3 = dbHelper3.getWritableDatabase();
                //删除数据
                sqliteDatabase3.delete("user","id=?",new String[]{"1"});
                // 关闭数据库
                sqliteDatabase3.close();
                break;
            // 点击删除数据库
            case R.id.delete_database:
                System.out.println(TAG + "删除数据库");

                MySQLiteOpenHelper dbHelper5 = new MySQLiteOpenHelper(MainActivity.this,
                        "test_carson",2);

                // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase5 = dbHelper5.getReadableDatabase();

                //删除名为test_carson数据库
                deleteDatabase("test_carson");
                break;
            default:
                break;
        }
    }
}
