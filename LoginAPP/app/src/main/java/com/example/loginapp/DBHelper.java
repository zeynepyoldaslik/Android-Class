package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public final static String DATABESE_NAME="USER.DB";
    public final static String TABLE_NAME="USERS";
    public final static String COL_ID="ID";
    public final static String COL_USERNAME="USERNAME";
    public final static String COL_MAIL="EMAIL";
    public final static String COL_PASSWORD="PASSWORD";
    SQLiteDatabase database;

    public DBHelper(Context context){
        super(context,DATABESE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY="CREATE TABE"+TABLE_NAME+"(ID INTEGER PRIMARY KEY,USERNAME TEXT NOT NULL,NAME TEXT NOT NULL,EMAIL TEXT,PASSWORD TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_QUERY);
        this.database=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String UPGRADE_QUERY="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(UPGRADE_QUERY);
        this.onCreate(db);
    }

    public boolean insertUser(String name, String mail, String pass) {
        this.database=getWritableDatabase();
        String QUERY="SELECT * FROM"+TABLE_NAME;
        Cursor cursor=database.rawQuery(QUERY,null);
        int id=cursor.getCount();
        ContentValues value=new ContentValues();
        value.put(COL_ID,id+1);
        value.put(COL_USERNAME,name);
        value.put(COL_MAIL,mail);
        value.put(COL_PASSWORD,pass);
        Long result=database.insert(TABLE_NAME,null,value);
        database.close();
        if(result==-1)
            return false;
        else
            return true;
    }

    public String findUser(String username) {
        this.database=getReadableDatabase();
        String QUERY="SELECT * FROM"+TABLE_NAME+"WHERE USERNAME='"+username+"'";
        Cursor cursor=database.rawQuery(QUERY,null);

        if(cursor.moveToFirst()){
            database.close();
            return cursor.getString(3);
        }else{
            database.close();
            return "not found";
        }
    }
}
