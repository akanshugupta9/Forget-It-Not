package com.example.akanshugupta9.forgetitnot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ForgetItNot.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE events ( sr_no INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, title VARCHAR(25) NOT NULL , UNIQUE (title))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public Event[] getEvents() {
        ArrayList<Event> array_list = new ArrayList<Event>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from events", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            Event tmp = new Event(res.getInt(res.getColumnIndex("sr_no")), res.getString(res.getColumnIndex("title")));
            array_list.add(tmp);
            res.moveToNext();
        }
        return array_list.toArray(new Event[0]);
    }

    public boolean insertEvent (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", name);
        db.insert("events", null, contentValues);
        return true;
    }

}
