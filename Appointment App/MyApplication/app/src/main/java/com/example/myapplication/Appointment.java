package com.example.myapplication;

import java.util.ArrayList;

public class Appointment {

    public static ArrayList<Appointment> appointmentArrayList = new ArrayList<>();
    private int id;
    private Date date;
    private Time time;

    public Appointment(int id, Date date, Time time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }
}
