package com.swinfotech.foodapp.model;

public class BestReviewedFoodModel {
    private String imageUrl;
    private String name;

    public BestReviewedFoodModel() {
    }

    public BestReviewedFoodModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BestReviewedFoodModel(String imageUrl, String name) {
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
