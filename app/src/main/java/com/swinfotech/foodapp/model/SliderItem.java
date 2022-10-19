package com.swinfotech.foodapp.model;

public class SliderItem {
    private String name, image;

    public SliderItem() {
    }

    public SliderItem(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public SliderItem(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
