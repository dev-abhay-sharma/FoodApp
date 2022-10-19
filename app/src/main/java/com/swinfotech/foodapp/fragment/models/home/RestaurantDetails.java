package com.swinfotech.foodapp.fragment.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantDetails {


    @SerializedName("GetShops")
    @Expose
    private GetShops getShops;

    public GetShops getGetShops() {
        return getShops;
    }

    public void setGetShops(GetShops getShops) {
        this.getShops = getShops;
    }


    public class GetShops {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cat_type_id")
        @Expose
        private Integer catTypeId;
        @SerializedName("gen_shop_id")
        @Expose
        private String genShopId;
        @SerializedName("shop_name_en")
        @Expose
        private String shopNameEn;
        @SerializedName("shop_name_bn")
        @Expose
        private String shopNameBn;
        @SerializedName("shop_name_hin")
        @Expose
        private String shopNameHin;
        @SerializedName("shop_logo")
        @Expose
        private String shopLogo;
        @SerializedName("address")
        @Expose
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCatTypeId() {
            return catTypeId;
        }

        public void setCatTypeId(Integer catTypeId) {
            this.catTypeId = catTypeId;
        }

        public String getGenShopId() {
            return genShopId;
        }

        public void setGenShopId(String genShopId) {
            this.genShopId = genShopId;
        }

        public String getShopNameEn() {
            return shopNameEn;
        }

        public void setShopNameEn(String shopNameEn) {
            this.shopNameEn = shopNameEn;
        }

        public String getShopNameBn() {
            return shopNameBn;
        }

        public void setShopNameBn(String shopNameBn) {
            this.shopNameBn = shopNameBn;
        }

        public String getShopNameHin() {
            return shopNameHin;
        }

        public void setShopNameHin(String shopNameHin) {
            this.shopNameHin = shopNameHin;
        }

        public String getShopLogo() {
            return shopLogo;
        }

        public void setShopLogo(String shopLogo) {
            this.shopLogo = shopLogo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }

}
