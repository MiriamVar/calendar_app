package com.example.calendar_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CalendarActivity extends AppCompatActivity implements AddEventActivity.AddEventActivityListener {
    private CalendarView myClanedar;
    private static final String TAG = "CalendarActivity";
    private List<Event> events = new ArrayList();
    private ListView myEvents;
    private MyAdapter myAdapter;
    private String selected_date;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        myClanedar = (CalendarView) findViewById(R.id.calendarView);
        myEvents  = findViewById(R.id.listView_events);

        myClanedar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                selected_date = year + "/" + month + "/"+ dayOfMonth ;
                showEditDialog();
            }
        });


        myAdapter = new MyAdapter();
        myEvents.setAdapter(myAdapter);
     }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        AddEventActivity editNameDialogFragment = AddEventActivity.newInstance("Some Title", "Some title");
        editNameDialogFragment.show(fm, "fragment_edit_name");

    }


    @Override
    public void onFinisheditDialog(String inputText, String inputText2) {
        Event event1 = new Event(inputText,selected_date,inputText2);
        this.events.add(event1);
        System.out.println(event1.name);
        myAdapter.notifyDataSetChanged();
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return events.size();
        }

        @Override
        public Object getItem(int position) {
            return events.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.event_lay,parent,false);

                TextView name = convertView.findViewById(R.id.edit_name2);
                TextView date = convertView.findViewById(R.id.edit_date2);
                TextView color = convertView.findViewById(R.id.edit_color2);
                System.out.println(name);
                System.out.println(date);
                System.out.println(color);

                System.out.println(events.get(position).name);
                name.setText(events.get(position).name);
                date.setText(events.get(position).date.toString());
                color.setText(events.get(position).color);
            }

            return convertView;
        }
    }

}

