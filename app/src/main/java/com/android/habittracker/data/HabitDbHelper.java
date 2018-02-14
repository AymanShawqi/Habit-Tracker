package com.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.habittracker.data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "habit_base.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_HABITS_TABLE ="CREATE TABLE "+ HabitEntry.TABLE_NAME + " ( "
                +HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                +HabitEntry.COLUMN_HABIT_DESCRIPTION +" TEXT , "
                +HabitEntry.COLUMN_HABIT_PRIORITY + " INTEGER NOT NULL DEFAULT 1 );";

        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
