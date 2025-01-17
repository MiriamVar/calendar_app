package com.example.calendar_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // private static final String TAG = "MainActivity";
    private TextView theDate;
    private Button btn_GoTheCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_GoTheCalendar = (Button) findViewById(R.id.btngocalendar);

        ImageView simpleImageView=(ImageView)findViewById(R.id.gifView);
        simpleImageView.setScaleType(ImageView.ScaleType.CENTER);

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
