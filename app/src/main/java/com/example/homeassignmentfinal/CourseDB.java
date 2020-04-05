package com.example.homeassignmentfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CourseDB extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "CoureseDB.db";
    private static String TABLE_NAME = "Courses";
    private static String COL_1 = "NAME";
    private static String COL_2 = "ROLL_NUMBER";
    private static String COL_3 = "REGULAR_COURSE";
    private static String COL_4 = "OPTIONAL_COURSE";

    public CourseDB(Context context) {

        super(context, TABLE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + " (NAME TEXT, ROLL_NUMBER TEXT, REGULAR_COURSE TEXT , OPTIONAL_COURSE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    boolean insertdata(String name , String roll , String rc , String oc)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,rc);
        contentValues.put(COL_4,oc);
        long result = db.insert(TABLE_NAME,null,contentValues);
        return result!=-1;
    }
    Cursor getalldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" select * from " + TABLE_NAME , null );
    }
    Integer deleteall()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,null,null );
    }
}

