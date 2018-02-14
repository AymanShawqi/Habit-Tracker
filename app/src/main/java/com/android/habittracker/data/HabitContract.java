package com.android.habittracker.data;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_HABIT_DESCRIPTION = "description";
        public final static String COLUMN_HABIT_PRIORITY = "priority";

        public final static int HIGH_PRIORITY = 1;
        public final static int MID_PRIORITY = 2;
        public final static int LOW_PRIORITY = 1;
    }
}
