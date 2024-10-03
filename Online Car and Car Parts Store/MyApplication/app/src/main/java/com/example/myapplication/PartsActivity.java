package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class PartsActivity extends AppCompatActivity implements RecyclerViewInterface {

    int sidelight = R.mipmap.audi_a6_sidelight_foreground;
    int grille = R.mipmap.audi_grille_foreground;
    int bmw_seats = R.mipmap.bmw_sports_seats_foreground;

    int diesel_injector = R.mipmap.diesel_injector_nissan_foreground;

    int gearbox = R.mipmap.hyundai_gearbox_foreground;

    int chain_replacement = R.mipmap.landrover_chain_replacement_foreground;
    int exhaust_system = R.mipmap.range_rover_exhaust_system_foreground;

    ArrayList<PartModel> partModels = new ArrayList<>();
    int[] partImages = {sidelight, grille, bmw_seats, diesel_injector, gearbox, chain_replacement, exhaust_system};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        RecyclerView recyclerView = findViewById(R.id.myRecycleView);

        setUpPartModels();

        PM_RecyclerViewAdapter adapter = new PM_RecyclerViewAdapter(this, partModels, this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton homeBtnParts = findViewById(R.id.homeBtnParts);

        homeBtnParts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PartsActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }

    private void setUpPartModels() {
        String[] partNames = getResources().getStringArray(R.array.parts_models_full_txt);
        String[] partPrices = getResources().getStringArray(R.array.parts_prices_full_txt);

        for (int i = 0; i < partNames.length; i++) {
            partModels.add(new PartModel(
                    partNames[i],
                    partPrices[i],
                    partImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( PartsActivity.this, PartsDetails.class);

        intent.putExtra( "NAME", partModels.get(position).getPartName());
        intent.putExtra( "PRICE", partModels.get(position).getPartPrice());
        intent.putExtra( "IMAGE", partModels.get(position).getImage());

        startActivity(intent);
    }
}
