package com.example.bookfuture.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHeplper extends SQLiteOpenHelper {

    public DBHeplper(@Nullable Context context) {
        super(context, "SQLAppBanSach.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Account(userName text primary key, passWord text," +
                "gmail text,phoneNumber text,sex text)";
        db.execSQL(sql);
        sql = "INSERT INTO Account VALUES('admin','1','1','1','1')";
        db.execSQL(sql);
        sql = "CREATE TABLE Bill(billId int primary key,  userName text REFERENCES Account(userName))";
        db.execSQL(sql);
        sql = "INSERT INTO Bill VALUES('1','admin')";
        db.execSQL(sql);
        sql = "CREATE TABLE Cart(billId int REFERENCES Bill(billId),bookId int,bookName text,numberOfSelect int,price int,primary key (billId,bookId))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
