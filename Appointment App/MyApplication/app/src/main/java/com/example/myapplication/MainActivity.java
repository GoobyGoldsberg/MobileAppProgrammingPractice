package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button by its ID
        View bookAppointmentButton = findViewById(R.id.bookAppointmentBtn);
        View showAppointmentsButton = findViewById(R.id.showAppointmentsBtn);

        // Set the onClickListener for the button
        bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start BookingActivity
                Intent intent = new Intent(MainActivity.this, DateBookingActivity.class);

                // Start the BookingActivity
                startActivity(intent);
            }
        });

        showAppointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start BookingActivity
                Intent intent = new Intent(MainActivity.this, ShowAppointmentsActivity.class);

                // Start the BookingActivity
                startActivity(intent);
            }
        });


    }
}
