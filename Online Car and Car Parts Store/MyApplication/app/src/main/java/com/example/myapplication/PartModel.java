package com.example.myapplication;

public class PartModel {
    String partName;
    String partPrice;
    int image;

    public PartModel(String partName, String partPrice, int image) {
        this.partName = partName;
        this.partPrice = partPrice;
        this.image = image;
    }

    public String getPartName() {
        return partName;
    }

    public int getImage() {
        return image;
    }

    public String getPartPrice() {
        return partPrice;
    }
}
