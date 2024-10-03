package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button carsBtn = findViewById(R.id.carsBTN);
        Button bikesBtn = findViewById(R.id.bikesBTN);
        Button sparePartsBtn = findViewById(id.spare_partsBTN);

        carsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CarsActivity.class);

                startActivity(intent);

            }

        });

        bikesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, BikesActivity.class);

                startActivity(intent);

            }
        });

        sparePartsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( MainActivity.this, PartsActivity.class);

                startActivity(intent);
            }
        });
    }
}
