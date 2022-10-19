package com.swinfotech.foodapp.model;

public class AllRestaurantsModel {
    private String imageUrl;
    private String name;
    private String id;

    public AllRestaurantsModel() {
    }

    public AllRestaurantsModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AllRestaurantsModel(String id,String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
    }
    public AllRestaurantsModel(String imageUrl, String name) {
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
