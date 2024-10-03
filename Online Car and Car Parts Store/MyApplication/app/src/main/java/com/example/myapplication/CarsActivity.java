package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class CarsActivity extends AppCompatActivity implements RecyclerViewInterface {



    int vw_jetta = R.mipmap.vw_jetta_foreground;
    int bmw_2 = R.mipmap.bmw_2_foreground;
    int bmw_3 = R.mipmap.bmw_3_foreground;
    int bmw_4 = R.mipmap.bmw_4_foreground;
    int skoda_karog = R.mipmap.skoda_karog_foreground;
    int toyota_prius = R.mipmap.toyota_prius_foreground;
    int vw_passat = R.mipmap.vw_passat_foreground;
    int vw_polo = R.mipmap.vw_polo_foreground;

    ArrayList<CarModel> carModels = new ArrayList<>();
    int[] carsImages = {vw_jetta, bmw_2, bmw_3, bmw_4, skoda_karog, toyota_prius, vw_passat, vw_polo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_activity);

        RecyclerView recyclerView = findViewById(R.id.myRecycleView);

        setUpCarModels();

        CM_RecyclerViewAdapter adapter = new CM_RecyclerViewAdapter(this, carModels, this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton homeBtnCars = findViewById(R.id.homeBtnCars);

        homeBtnCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CarsActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }

    private void setUpCarModels() {
        String[] carNames = getResources().getStringArray(R.array.car_models_full_txt);
        String[] carTypes = getResources().getStringArray(R.array.car_models_types_txt);
        String[] carPrices = getResources().getStringArray(R.array.car_models_prices_txt);

        for (int i = 0; i < carNames.length; i++) {
            carModels.add(new CarModel(
                    carNames[i],
                    carTypes[i],
                    carPrices[i],
                    carsImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( CarsActivity.this, CarDetails.class);

        intent.putExtra( "NAME", carModels.get(position).getCarName());
        intent.putExtra( "TYPE", carModels.get(position).getCarType());
        intent.putExtra( "PRICE", carModels.get(position).getCarPrice());
        intent.putExtra( "IMAGE", carModels.get(position).getImage());

        startActivity(intent);
    }



}