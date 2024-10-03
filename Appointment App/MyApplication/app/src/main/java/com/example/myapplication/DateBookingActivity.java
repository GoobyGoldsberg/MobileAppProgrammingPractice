package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DateBookingActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<Date> dateList = new ArrayList<>();




    Date date1 = new Date("Mon", "27/11");
    Date date2 = new Date("Tue", "28/11");
    Date date3 = new Date("Wed", "29/11");
    Date date4 = new Date("Thu", "30/11");
    Date date5 = new Date("Fr", "01/12");
    Date date6 = new Date("Sat", "02/12");
    Date date7 = new Date("Sun", "03/12");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_activity);


        RecyclerView recyclerView = findViewById(R.id.dates_rv);


        {
            dateList.add(date1);
            dateList.add(date2);
            dateList.add(date3);
            dateList.add(date4);
            dateList.add(date5);
            dateList.add(date6);
            dateList.add(date7);

        }

        DateAdapter adapter = new DateAdapter(this, dateList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Button backButton = findViewById(R.id.goBackDate);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DateBookingActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(int position) {


    }
}
