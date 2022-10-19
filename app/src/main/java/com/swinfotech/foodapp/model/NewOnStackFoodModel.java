package com.swinfotech.foodapp.model;

public class NewOnStackFoodModel {
    private String imageUrl;
    private String name;

    public NewOnStackFoodModel() {
    }

    public NewOnStackFoodModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public NewOnStackFoodModel(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
