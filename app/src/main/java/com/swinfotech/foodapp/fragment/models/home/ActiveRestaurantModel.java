package com.swinfotech.foodapp.fragment.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActiveRestaurantModel {


    @SerializedName("FetchRest")
    @Expose
    private List<FetchRest> fetchRest = null;

    public List<FetchRest> getFetchRest() {
        return fetchRest;
    }

    public void setFetchRest(List<FetchRest> fetchRest) {
        this.fetchRest = fetchRest;
    }


    public class FetchRest {

        @SerializedName("id")
        @Expose
        private Integer id;
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

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

    }
}
