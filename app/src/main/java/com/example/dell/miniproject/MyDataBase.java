package com.example.dell.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 05-01-2017.
 */
public class MyDataBase {
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;
    public MyDataBase(Context c)
    {
        myHelper = new MyHelper(c,"kundu.db",null,1);
    }
    public  void open()
    {
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    public void insertDeatils(String no,String name,String mobile,String mail,String subject,String date)
    {
        ContentValues cv = new ContentValues();
        cv.put("no",no);
        cv.put("name",name);
        cv.put("mobile",mobile);
        cv.put("mail",mail);
        cv.put("subject",subject);
       cv.put("date",date);

        sqLiteDatabase.insert("Details",null,cv);
    }
    public Cursor queryDetails()
    {
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("Details",null,null,null,null,null,null);
        return cursor;
    }
    public  Cursor queryDetailsname(String name)
    {
        Cursor cursor1 = null;
        cursor1 = sqLiteDatabase.query("Details",null,"name=?",new String[]{name},null,null,null );
        return cursor1;
    }
    public Cursor queryDetailsMobile(String mobile)
    {
         Cursor cursor2 = null;
        cursor2 = sqLiteDatabase.query("Details",null,"mobile=?",new String[]{mobile},null,null,null);
        return cursor2;
    }
    public void close()
    {
        sqLiteDatabase.close();
    }


    public  class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table Details(_id integer,no text,name text,mobile text,mail text, subject text,date text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
