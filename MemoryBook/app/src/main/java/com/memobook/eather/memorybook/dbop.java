package com.memobook.eather.memorybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eather on 2017/11/22.
 */

public class dbop extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "memo.db";
    public static final int DATABASE_VERSION = 5;
    public dbop(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        createtable(sqLiteDatabase);
        Log.d("dbop","in dbop onCreate method");
        //db=sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists memobook");
        this.createtable(sqLiteDatabase);
    }
    public void createtable(SQLiteDatabase db)
    {
        final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + "memobook" + " (" +
                        "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "title" + " TEXT," +
                        "text" + " TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.d("dbop","successful created");
    }

    public void insertinfo(String title,String text)
    {
        ContentValues values = new ContentValues();
        Log.d("dbop", "title: " + title);
        Log.d("dbop", "text: " + text);
        values.put("title", title);
        values.put("text",text);
        SQLiteDatabase db = this.getWritableDatabase();
    // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert("memobook", null, values);
    }
    public void updateinfo(String title,String text,String id)
    {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("text",text);
        String whereClause = "id=?";
        String[] whereArgs = {id};
        SQLiteDatabase db = this.getWritableDatabase();
        db.update("memobook",values,whereClause,whereArgs);
    }

    public Map queryinfo(SQLiteDatabase db,String id)
    {

        String whereClause = "id=?";
        String[] whereArgs = {id};
        Cursor cursor = db.query("memobook",null,whereClause,whereArgs,null,null,null);
        if(cursor.moveToFirst())
        {
            for (int i =0;i<cursor.getCount();i++)
            {
                cursor.move(i);
                String title = cursor.getString(1);
                String text = cursor.getString(2);
                Map<String,String> map = new HashMap<String, String>();
                map.put("title",title);
                map.put("text",text);
                return map;
            }
        }
        return null;
    }
    public ArrayList<Map<String, Object>> queryall()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        Cursor cursor = db.query("memobook",null,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            String id = cursor.getString(0);
            String title = cursor.getString(1);
            String text = cursor.getString(2);
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("id",id);
            map.put("text",title);
            map.put("subtext",text);
            list.add(map);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }


}
