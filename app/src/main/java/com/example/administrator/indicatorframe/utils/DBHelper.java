package com.example.administrator.indicatorframe.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016-07-30.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "persons.db";
    private static final int DB_VERSON = 2;

    //建库
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSON);
    }
    //建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        String recommendurl = "CREATE TABLE person  (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,phone CHAR(20),code CHAR(20))";
        db.execSQL(recommendurl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
