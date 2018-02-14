package com.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.habittracker.data.HabitContract.HabitEntry;

import java.util.ArrayList;

public class HabitSqlOperation {

    private HabitDbHelper mDbHelper;

    public HabitSqlOperation(Context context){
        mDbHelper = new HabitDbHelper(context);
    }

    public long insertHabit(String habitName,String habitDescription,int habitPriority){

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME , habitName);
        values.put(HabitEntry.COLUMN_HABIT_DESCRIPTION ,habitDescription);
        values.put(HabitEntry.COLUMN_HABIT_PRIORITY,habitPriority);

        long newRowId = db.insert(HabitEntry.TABLE_NAME,null,values);
        return newRowId;
    }

    public ArrayList<Habit> selectHabits(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection={
             HabitEntry._ID,
             HabitEntry.COLUMN_HABIT_NAME,
             HabitEntry.COLUMN_HABIT_DESCRIPTION,
             HabitEntry.COLUMN_HABIT_PRIORITY,
        };
        Cursor cursor = db.query(HabitEntry.TABLE_NAME,projection,null,null,null,null,null);
        try{
            ArrayList<Habit> habits=new ArrayList<>();
            int idColumnIndex=cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex=cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int descColumnIndex=cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DESCRIPTION);
            int priorityColumnIndex=cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_PRIORITY);
            while (cursor.moveToNext()){
                int currentId=cursor.getInt(idColumnIndex);
                String currentName=cursor.getString(nameColumnIndex);
                String currentDesc=cursor.getString(descColumnIndex);
                int currentPriority=cursor.getInt(priorityColumnIndex);
                habits.add(new Habit(currentId,currentName,currentDesc,currentPriority));
            }
            return habits;
        }finally {
            cursor.close();
        }
    }


}
