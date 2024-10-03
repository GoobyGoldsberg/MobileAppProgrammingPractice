package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AppointmentAdapter extends ArrayAdapter<Appointment> {

    public AppointmentAdapter(Context context, List<Appointment> appointments) {
        super(context, 0, appointments);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Appointment appointment = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.appointment_block, parent, false);


            TextView day = convertView.findViewById(R.id.appointmentDay);
            TextView date = convertView.findViewById(R.id.appointmentDate);
            TextView time = convertView.findViewById(R.id.appointmentTime);


            day.setText(appointment.getDate().getDay());
            date.setText(appointment.getDate().getDate());
            time.setText(appointment.getTime().getTime());



        }

        return convertView;
    }
}
