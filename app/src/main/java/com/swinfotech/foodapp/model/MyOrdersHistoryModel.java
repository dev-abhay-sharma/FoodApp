package com.swinfotech.foodapp.model;

public class MyOrdersHistoryModel {
    private String imgUrl;
    private String name;
    private String status;


    public MyOrdersHistoryModel() {
    }

    public MyOrdersHistoryModel(String imgUrl, String name, String status) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
