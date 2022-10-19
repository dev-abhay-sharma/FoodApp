package com.swinfotech.foodapp.model;

import java.io.Serializable;

public class PopularRestaurantsModel implements Serializable {
    private String imageUrl;
    private String name;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PopularRestaurantsModel() {
    }

    public PopularRestaurantsModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PopularRestaurantsModel(String id, String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
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
