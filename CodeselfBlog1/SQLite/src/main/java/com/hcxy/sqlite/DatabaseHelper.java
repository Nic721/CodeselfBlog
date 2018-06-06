package com.hcxy.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建数据库子类，继承自SQLiteOpenHelper类
 * 需复写onCreate()、onUpgrade()
 * Created by cxy on 2018/5/27.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // 数据库版本号
    private static Integer version = 1;

    /**
     * 构造函数
     * 在SQLiteOpenHelper的子类中，必须有该构造函数
     * @param context 上下文对象
     * @param name 数据库名称
     * @param factory 一个可选的游标工程（通常是null）
     * @param version 当前数据库的版本，值必须是整数并且是递增的状态
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // 必须通过super调用父类的构造函数
        super(context, name, factory, version);
    }

    /**
     * 复写onCreate()
     * 调用时刻：当数据库第1次创建时调用
     * 作用：创建数据库表 & 初始化数据
     * SQLite数据库创建支持的数据类型：整型数据、字符串类型、日期类型、二进制
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建数据库1张表
        // 通过execSQL()执行SQL语句（此处创建了1个名为person的表）
        String sql = "create table person(id integer primary key autoincrement,name varchar(64),address varchar(64))";
        db.execSQL(sql);
        // 注：数据库实际上是没有被创建/打开的（因该方法还没调用）
        // 直到 getWritableDatabase()/getReadableDatabase()第一次被调用时才会进行创建/打开

    }

    /**
     * 复写onUpgrade()
     * 调用时刻：当数据库升级时则自动调用（即数据库版本发生变化时）
     * 作用：更新数据表结构
     * 注：创建SQLiteOpenHelper子类对象时，必须传入一个version参数，该参数=当前数据库版本，若该版本高于之前版本，就调用onUpgrade()
     * @param db 数据库
     * @param oldVersion 旧版本数据库
     * @param newVersion 新版本数据库
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 使用SQL的ALTER语句
        String sql = "alter table person add sex varchar(8)";
        db.execSQL(sql);
    }
}
