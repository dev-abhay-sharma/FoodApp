package com.swinfotech.foodapp.model;

public class MenuModel {
    private int imageUrl;
    private String name;
    private Class aClass;

    public MenuModel() {
    }

    public MenuModel(int imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public MenuModel(int imageUrl, String name, Class aClass) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.aClass = aClass;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
