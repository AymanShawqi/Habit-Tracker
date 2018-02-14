package com.android.habittracker.data;


public class Habit {

    private int habitID;
    private String habitName;
    private String habitDescription;
    private int habitPriority;

    public Habit(int habitID, String habitName, String habitDescription, int habitPriority) {
        this.habitID = habitID;
        this.habitName = habitName;
        this.habitDescription = habitDescription;
        this.habitPriority = habitPriority;
    }

    public int getHabitID() {
        return habitID;
    }

    public String getHabitName() {
        return habitName;
    }

    public String getHabitDescription() {
        return habitDescription;
    }

    public int getHabitPriority() {
        return habitPriority;
    }
}
