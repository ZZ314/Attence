package com.example.administrator.check;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Check.db";
    private static final String TBL_NAME = "atten";
    private SQLiteDatabase db;//声明SQLiteDatabase对象

    public DBhelper(Context c) {

        super(c, DB_NAME, null, 2);
    }

    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        String sql = "create table atten(_id integer primary key autoincrement,sno varchar,name text,class text)";
        db.execSQL(sql);
    }

    public void insert(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TBL_NAME, null, values);
        db.close();
    }

    public Cursor query() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query(TBL_NAME, null, null, null, null, null, null);
        return c;
    }

    public void del(int id) {
        if (db == null)
            db = getWritableDatabase();
        db.delete(TBL_NAME, "_id=?", new String[]{String.valueOf(id)});
    }

    public void close() {
        if (db != null)
            db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}