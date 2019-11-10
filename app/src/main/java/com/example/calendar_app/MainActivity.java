package com.example.calendar_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView theDate;
    private Button btn_GoTheCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        theDate = (TextView) findViewById(R.id.date);
        btn_GoTheCalendar = (Button) findViewById(R.id.btngocalendar);

        //when you choose the date in calnedar , it comes to the main screen
//        Intent incoming = getIntent();
//        String date = incoming.getStringExtra("date");
//        theDate.setText(date);


        // setting new screen with calendar
        btn_GoTheCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
    }
}
