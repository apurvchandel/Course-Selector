package com.example.homeassignmentfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Login.db";
    private static final String TABLE_NAME = "IdTable";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "PASSWORD";


    LoginDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID TEXT,PASSWORD TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    boolean insertData(String id, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        return result != -1;

    }
    Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);

    }
    Cursor SearchData(String Id)
    {
        SQLiteDatabase db = this .getWritableDatabase();
        return db.rawQuery(" SELECT ID,PASSWORD FROM "+ TABLE_NAME+ " WHERE ID = Id OR PASSWORD = Id",null );
    }
    Integer deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, null,null);
    }

}
