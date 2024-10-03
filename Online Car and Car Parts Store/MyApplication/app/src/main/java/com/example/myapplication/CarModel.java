package com.example.myapplication;

public class CarModel {
    String carName;
    String carType;
    String carPrice;
    int image;

    public CarModel(String carName, String carType, String carPrice, int image) {
        this.carName = carName;
        this.carType = carType;
        this.carPrice = carPrice;
        this.image = image;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public int getImage() {
        return image;
    }

    public String getCarPrice() {
        return carPrice;
    }
}
