package com.swinfotech.foodapp.model;

public class ChooseInterestsModel {
    private String imageUrl;
    private String name;

    public ChooseInterestsModel() {
    }

    public ChooseInterestsModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ChooseInterestsModel(String imageUrl, String name) {
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
