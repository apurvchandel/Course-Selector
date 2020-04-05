package com.example.homeassignmentfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PaymentDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Payment.db";
    public static final String TABLE_NAME="PaymentInfo";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "ROLL_NUMBER";
    public static final String COL_3 = "PAYMENT_STATUS";



    public PaymentDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( NAME TEXT ,ROLL_NUMBER TEXT , PAYMENT_STATUS TEXT ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    boolean insertdata(String name,String roll, String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,status);
        long lenght = db.insert(TABLE_NAME,null,contentValues);
        return lenght!=-1;
    }
    Cursor getalldata ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME,null);
    }
    Integer deleteData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,null,null);
    }

}

