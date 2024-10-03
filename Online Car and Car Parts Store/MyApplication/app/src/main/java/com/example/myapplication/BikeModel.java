package com.example.myapplication;

public class BikeModel {
    String bikeName;
    String bikePrice;
    int image;

    public BikeModel(String bikeName, String bikePrice, int image) {
        this.bikeName = bikeName;
        this.bikePrice = bikePrice;
        this.image = image;
    }

    public String getBikeName() {
        return bikeName;
    }

    public int getImage() {
        return image;
    }

    public String getBikePrice() {
        return bikePrice;
    }
}
