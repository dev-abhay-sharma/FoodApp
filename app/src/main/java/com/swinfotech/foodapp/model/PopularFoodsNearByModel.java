package com.swinfotech.foodapp.model;

public class PopularFoodsNearByModel {
    private String imageUrl;
    private String name;
    private String id;
    private String mrp;
    private String productRest;

    public String getMrp() {
        return mrp;
    }

    public String getProductRest() {
        return productRest;
    }

    public void setProductRest(String productRest) {
        this.productRest = productRest;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public PopularFoodsNearByModel() {
    }

    public PopularFoodsNearByModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PopularFoodsNearByModel(String id,String imageUrl,String mrp, String name,String productRest) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
        this.mrp = mrp;
        this.productRest = productRest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
