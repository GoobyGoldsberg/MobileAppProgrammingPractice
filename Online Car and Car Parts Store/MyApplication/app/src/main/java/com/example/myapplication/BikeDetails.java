package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BikeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_details);

        String name = getIntent().getStringExtra("NAME");
        String price = getIntent().getStringExtra( "PRICE");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView nameTextView = findViewById(R.id.partNameDetail);
        TextView priceTextView = findViewById(R.id.partPriceDetails);
        ImageView imageView = findViewById(R.id.partImageDetail);

        nameTextView.setText(name);
        priceTextView.setText(price);
        Glide.with(this).load(image).into(imageView);

        ImageButton backButton = findViewById(R.id.backButton);
        ImageButton homeButton = findViewById(R.id.homeButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BikeDetails.this, BikesActivity.class);

                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BikeDetails.this, MainActivity.class);

                startActivity(intent);
            }
        });


    }

}
