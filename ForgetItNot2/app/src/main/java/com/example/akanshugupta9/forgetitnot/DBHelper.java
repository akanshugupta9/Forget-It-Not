package com.example.akanshugupta9.forgetitnot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.name;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ForgetItNot.db";
    private static final String TAG = "DBHelper";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE events ( sr_no INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, title VARCHAR(25) NOT NULL , UNIQUE (title))");
        db.execSQL("CREATE TABLE triggers ( sr_no INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , belongs_to INT NOT NULL , type INT NOT NULL , latitude DOUBLE , longitude DOUBLE  , radius INT  , hour1 int , min1 int, hour2 int , min2 int , days varchar(7) , FOREIGN KEY (belongs_to) REFERENCES events(sr_no) ON DELETE CASCADE ON UPDATE CASCADE)");
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

    public Trigger[] getTriggers(String srNo) {
        ArrayList<Trigger> array_list = new ArrayList<Trigger>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from triggers where belongs_to="+srNo, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            Trigger tmp = new Trigger(res.getInt(res.getColumnIndex("sr_no")), res.getInt(res.getColumnIndex("type")), res.getInt(res.getColumnIndex("hour1")), res.getInt(res.getColumnIndex("min1")), res.getInt(res.getColumnIndex("hour2")), res.getInt(res.getColumnIndex("min2")), res.getString(res.getColumnIndex("days")), res.getDouble(res.getColumnIndex("longitude")), res.getDouble(res.getColumnIndex("latitude")), res.getInt(res.getColumnIndex("radius")));
            array_list.add(tmp);
            res.moveToNext();
        }
        return array_list.toArray(new Trigger[0]);
    }

    public boolean insertEvent (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", name);
        db.insert("events", null, contentValues);
        return true;
    }

    public boolean insertTimeTrigger (String srNo, String hour, String min) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("belongs_to", srNo);
        contentValues.put("hour1", hour);
        contentValues.put("min1", min);
        contentValues.put("type", 1);
        db.insert("triggers", null, contentValues);
        return true;
    }

    public boolean insertTimeRangeTrigger (String srNo, String hour1, String min1, String hour2, String min2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("belongs_to", srNo);
        contentValues.put("hour1", hour1);
        contentValues.put("min1", min1);
        contentValues.put("hour2", hour2);
        contentValues.put("min2", min2);
        contentValues.put("type", 2);
        db.insert("triggers", null, contentValues);
        return true;
    }

    public boolean insertLocationTrigger (String srNo, String longi, String lat, String rad) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("belongs_to", srNo);
        contentValues.put("longitude", longi);
        contentValues.put("latitude", lat);
        contentValues.put("radius", rad);
        contentValues.put("type", 0);
        db.insert("triggers", null, contentValues);
        return true;
    }

}
