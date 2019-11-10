package com.example.calendar_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;


public class CalendarActivity extends AppCompatActivity {
    private CalendarView myClanedar;
    private static final String TAG = "CalendarActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        myClanedar = (CalendarView) findViewById(R.id.calendarView);

        myClanedar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/"+ dayOfMonth ;
                //console log
                Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);

                // opening again main activity
                Intent intent = new Intent(CalendarActivity.this,MainActivity.class);

                //sendig data to main activity
                intent.putExtra("date",date);
                startActivity(intent);

            }
        });

         FloatingActionButton fab = findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                         .setAction("Action", null).show();
             }
         });
     }


}
