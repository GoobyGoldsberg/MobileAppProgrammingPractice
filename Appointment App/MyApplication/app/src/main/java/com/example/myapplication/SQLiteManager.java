package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteManager extends SQLiteOpenHelper {

    private static SQLiteManager sqLiteManager;
    private static final String DATABASE_NAME = "AppDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Appointment";

    private static final String COUNTER = "Counter";
    private static final String ID_FIELD = "id";
    private static final String DATE_FIELD = "date";
    private static final String TIME_FIELD = "time";



    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteManager instanceOfDatabase(Context context) {

        if (sqLiteManager == null ) {
            sqLiteManager = new SQLiteManager(context);
        }
        return sqLiteManager;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql;

        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append( "(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ID_FIELD)
                .append(" INT, ")
                .append(DATE_FIELD)
                .append(" TEXT, ")
                .append(TIME_FIELD)
                .append(" TEXT)");

        db.execSQL(sql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addAppointmentToDb(Appointment appointment) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, appointment.getId());
        contentValues.put(DATE_FIELD, appointment.getDate().toString());
        contentValues.put(TIME_FIELD, appointment.getTime().toString());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void populateAppointmentListArray() {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null)) {

            if (result.getCount() !=  0) {
                while (result.moveToNext()) {
                    int id = result.getInt(1);
                    Date date = parseDate(result.getString(2));

                    Time time = parseTime(result.getString(3));
                    Appointment appointment = new Appointment(id, date, time);
                }
            }
        }
    }

    private Date parseDate(String dateStr) {
        // Split the date string into day and date components
        String[] dateComponents = dateStr.split(" ");
        if (dateComponents.length == 2) {
            return new Date(dateComponents[0], dateComponents[1]);
        } else {

            return null;
        }
    }
    private Time parseTime(String timeStr) {
        return new Time(timeStr);
    }
}
