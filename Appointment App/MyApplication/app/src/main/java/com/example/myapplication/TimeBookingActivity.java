package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimeBookingActivity extends AppCompatActivity implements RecyclerViewInterface {

    TextView dateInfoDay, dateInfoDate;
    ArrayList<Time> timeList = new ArrayList<>();

    Date selectedDate;

    Time time1 = new Time("9am");
    Time time2 = new Time("11am");
    Time time3 = new Time("1pm");
    Time time4 = new Time("3pm");
    Time time5 = new Time("5pm");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_time_activity);

        dateInfoDate = findViewById(R.id.dateInfoDate);
        dateInfoDay = findViewById(R.id.dateInfoDay);


        Intent i = getIntent();
        String dateInfo = i.getStringExtra("selectedDate");
        String dayInfo = i.getStringExtra("selectedDay");
        dateInfoDate.setText(dateInfo);
        dateInfoDay.setText(dayInfo);

        selectedDate = new Date(dayInfo, dateInfo);

        RecyclerView recyclerView = findViewById(R.id.times_rv);

        {
            timeList.add(time1);
            timeList.add(time2);
            timeList.add(time3);
            timeList.add(time4);
            timeList.add(time5);
        }

        // Create and set the adapter
        TimeAdapter adapter = new TimeAdapter(this, timeList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Button backButton = findViewById(R.id.goBackTime);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeBookingActivity.this, DateBookingActivity.class);

                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Time selectedTime = timeList.get(position);

        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);

        int id = Appointment.appointmentArrayList.size();

        Appointment appointment = new Appointment(id, selectedDate, selectedTime);
        Appointment.appointmentArrayList.add(appointment);
        sqLiteManager.addAppointmentToDb(appointment);
        finish();

        Intent intent = new Intent(TimeBookingActivity.this, MainActivity.class);
        startActivity(intent);


    }


}
