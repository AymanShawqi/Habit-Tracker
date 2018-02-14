package com.android.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.habittracker.data.Habit;
import com.android.habittracker.data.HabitSqlOperation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  test();
    }

    private void test() {
        HabitSqlOperation opr = new HabitSqlOperation(this);
        long id = opr.insertHabit("runninng", "run every day", 1);
        if (id == -1)
            Toast.makeText(this, "Error in insert habit", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "successfully insert habit with id = " + id, Toast.LENGTH_SHORT).show();

        TextView displayText = (TextView) findViewById(R.id.display);
        ArrayList<Habit> habits = opr.selectHabits();
        for (int i = 0; i < habits.size(); i++) {
            Habit currentHabit = habits.get(i);
            displayText.append(currentHabit.getHabitName() + "\n\n");
        }
    }

}
