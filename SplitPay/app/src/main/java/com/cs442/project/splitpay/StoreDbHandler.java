package com.cs442.project.splitpay;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;


public class StoreDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SplitPay.db";
    private static final String TABLE_REGISTER = "UserReg";
    private static final String COULUMN_FNAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_USERNAME = "uname";
    private static final String COLUMN_PASSWORD = "passwd";
    private static final String COLUMN_CONPASS = "conpass";
    private static final String COLUMN_CARD = "card";
    private static final String COLUMN_CARDTYPE = "ctype";
    private static final String COLUMN_CARDNAME = "cname";
    private static final String COLUMN_CARDNUM = "cnum";
    private static final String COLUMN_CARDEXP = "exp";
    private static final String COLUMN_CARDCVV = "cvv";

    private static StoreDbHandler dbHandler = null;

    public static StoreDbHandler getDbHandlerInstance(Context context, SQLiteDatabase.CursorFactory factory) {
        if (dbHandler == null) {
            dbHandler = new StoreDbHandler(context, factory);
        }
        return dbHandler;
    }

    private StoreDbHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_REGISTER + "(" +
                COULUMN_FNAME + "TEXT not null," +
                COLUMN_EMAIL + "TEXT not null unique," +
                COLUMN_PHONE + "INTEGER not null unique," +
                COLUMN_USERNAME + "TEXT PRIMARY KEY," +
                COLUMN_PASSWORD + "TEXT not null unique," +
                COLUMN_CONPASS + "TEXT not null unique," +
                COLUMN_CARD + "TEXT not null unique," +
                COLUMN_CARDTYPE + "TEXT not null unique," +
                COLUMN_CARDNAME + "TEXT not null unique," +
                COLUMN_CARDNUM + "INTEGER not null unique," +
                COLUMN_CARDEXP + "INTEGER not null," +
                COLUMN_CARDCVV + "INTEGER not null unique," + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean isUserAuthenticated(String userName, String password){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> users = new ArrayList<String>();
        boolean result = false;

        if (db != null) {
            String query = "SELECT " + COLUMN_USERNAME + " FROM " + TABLE_REGISTER + " WHERE " + COLUMN_USERNAME +
                    " = " + userName + " and " + COLUMN_PASSWORD + " = " + password;
            //cursor to point the current position of result
            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                users.add(c.getString(c.getColumnIndex(COLUMN_USERNAME)));
                c.moveToNext();
            }
            db.close();
        }

        if(users.size() == 1){
            result = true;
        }

        return result;
    }
/*
    public String getUserName(){
        SQLiteDatabase db = getReadableDatabase();
        String userName = null;

        if (db != null) {
            // String query = "SELECT COLUMN_USERNAME,COLUMN_PASSWORD FROM " + TABLE_REGISTER + "WHERE COLUMN_USERNAME = " + uName;
            String query = "SELECT COLUMN_USERNAME FROM " + TABLE_REGISTER;
            //cursor to point the current position of result
            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex(COLUMN_USERNAME)) != null) {
                    userName = c.getString(c.getColumnIndex(COLUMN_USERNAME));
                }
                c.moveToNext();
            }
            db.close();
        }
        return userName;
    }

    public String getPassword(String uName) {
        SQLiteDatabase db = getReadableDatabase();
        String password = null;

        if (db != null) {
            String query = "SELECT COLUMN_PASSWORD FROM " + TABLE_REGISTER + "WHERE COLUMN_USERNAME = " + uName;
            //cursor to point the current position of result
            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex(COLUMN_USERNAME)) != null) {
                    password = c.getString(c.getColumnIndex(COLUMN_PASSWORD));
                }
                c.moveToNext();
            }
            db.close();
        }
        return password;
    }
    */
}
