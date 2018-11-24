package com.example.kenni.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table User( fname text,lname,text,email text primary key,password text,cpassword text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("drop if table exists User");

    }
    //inserting into the database
    //public Boolean insert(String fname,String lname,String email,String password,String cpassword) {

    public boolean insert(String fname,String lname,String email,String password,String cpassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fname",fname);
        contentValues.put("lname",lname);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("cpassword",cpassword);

        long ins = db.insert("User",null,contentValues);
        if (ins==-1)return false;
        else return true;
    }


public Boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * User where email=?", new String[]{email});
        if (cursor.getCount()>0)return false;
        else return true;
}


}
