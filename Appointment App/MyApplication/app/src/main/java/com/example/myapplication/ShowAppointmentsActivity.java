package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ShowAppointmentsActivity extends AppCompatActivity {

    private ListView appointmentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_books_activity);

        appointmentListView = findViewById(R.id.appointmentsLV);

        loadFromDBToMemory();
        setAppointmentAdapter();

        Button backButton = findViewById(R.id.goBackShow);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowAppointmentsActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }


    private void loadFromDBToMemory() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateAppointmentListArray();
    }

    private void setAppointmentAdapter() {
        AppointmentAdapter appointmentAdapter = new AppointmentAdapter(getApplicationContext(), Appointment.appointmentArrayList);
        appointmentListView.setAdapter(appointmentAdapter); // This returns null, needs fix
    }


}

