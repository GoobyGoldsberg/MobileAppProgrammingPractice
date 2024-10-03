package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class BikesActivity extends AppCompatActivity implements RecyclerViewInterface {

    int boardman = R.mipmap.boardman_sport_xl_foreground;
    int carrera_axle = R.mipmap.carrera_axle_hybrid_foreground;
    int carrera_crossfire = R.mipmap.carrera_crossfire_hybrid_foreground;
    int claude_butler = R.mipmap.claude_butler_200_foreground;
    int consenza = R.mipmap.consenza_sport_hybrid_foreground;
    int crux_elite = R.mipmap.crux_elite_cx_bike_foreground;
    int orbea = R.mipmap.orbea_laufey_x_foreground;

    ArrayList<BikeModel> bikeModels = new ArrayList<>();
    int[] bikesImages = {boardman, carrera_axle, carrera_crossfire, claude_butler, consenza, crux_elite, orbea};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bikes);

        RecyclerView recyclerView = findViewById(R.id.myRecycleView);

        setUpBikeModels();

        BM_RecyclerViewAdapter adapter = new BM_RecyclerViewAdapter(this, bikeModels, this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton homeBtnBikes = findViewById(R.id.homeBtnBikes);

        homeBtnBikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BikesActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }

    private void setUpBikeModels() {
        String[] bikeNames = getResources().getStringArray(R.array.bikes_models_full_txt);
        String[] bikePrices = getResources().getStringArray(R.array.bikes_models_prices_txt);

        for (int i = 0; i < bikeNames.length; i++) {
            bikeModels.add(new BikeModel(
                    bikeNames[i],
                    bikePrices[i],
                    bikesImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( BikesActivity.this, BikeDetails.class);

        intent.putExtra( "NAME", bikeModels.get(position).getBikeName());
        intent.putExtra( "PRICE", bikeModels.get(position).getBikePrice());
        intent.putExtra( "IMAGE", bikeModels.get(position).getImage());

        startActivity(intent);
    }
}
