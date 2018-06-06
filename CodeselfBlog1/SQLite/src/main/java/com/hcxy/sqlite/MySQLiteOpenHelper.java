package com.hcxy.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.ContextCompat;

/**
 * context:上下文
 * name:数据库名称
 * factory:一个可选的游标工程（通常是null）
 * version:当前数据库的版本，值必须是整数并且是递增的状态
 * Created by cxy on 2018/5/27.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    // 数据库版本号
    private static Integer Version = 1;

    /**
     * 构造函数
     * 在SQLiteOpenHelper的子类中，必须有该构造函数
     * @param context 上下文对象
     * @param name 数据库名称
     * @param factory 一个可选的游标工程（通常是null）
     * @param version 当前数据库的版本，值必须是整数并且是递增的状态
     */
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // 必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context,String name,int version){
        this(context,name,null,version);
    }

    public MySQLiteOpenHelper(Context context,String name){
        this(context,name,Version);
    }

    // 创建数据库的时候被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("创建数据库和表");
        // 创建了数据库并常见一个叫 user 的表
        // SQLite数据创建支持的数据类型： 整型数据，字符串类型，日期类型，二进制的数据类型
        String sql = "create table user(id int primary key,name varchar(200))";
        // execSQL用于执行SQL语句
        // 完成数据库的创建
        db.execSQL(sql);
        // 数据库实际上是没有被创建或者打开的，直到getWritableDatabase() 或者 getReadableDatabase() 方法中的一个被调用时才会进行创建或者打开
    }

    /**
     * 数据库升级时调用
     * 注：创建SQLiteOpenHelper子类对象时，必须传入一个version参数，该参数=当前数据库版本，若该版本高于之前版本，就调用onUpgrade()
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("更新数据库版本为："+newVersion);
    }
}
