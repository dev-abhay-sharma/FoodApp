package com.swinfotech.foodapp.fragment.models.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularProducts {

    @SerializedName("GetProd")
    @Expose
    private List<GetProd> getProd = null;

    public List<GetProd> getGetProd() {
        return getProd;
    }

    public void setGetProd(List<GetProd> getProd) {
        this.getProd = getProd;
    }


    public class GetProd {

        @SerializedName("p_id")
        @Expose
        private Integer pId;
        @SerializedName("prod_id")
        @Expose
        private String prodId;
        @SerializedName("prod_mark_id")
        @Expose
        private Integer prodMarkId;
        @SerializedName("prod_name_en")
        @Expose
        private String prodNameEn;
        @SerializedName("prod_name_bn")
        @Expose
        private String prodNameBn;
        @SerializedName("prod_name_hin")
        @Expose
        private String prodNameHin;
        @SerializedName("prod_img1")
        @Expose
        private String prodImg1;
        @SerializedName("price_id")
        @Expose
        private Integer priceId;
        @SerializedName("quantity")
        @Expose
        private String quantity;
        @SerializedName("q_unit")
        @Expose
        private String qUnit;
        @SerializedName("mrp")
        @Expose
        private String mrp;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("product_tax")
        @Expose
        private String productTax;
        @SerializedName("shop_name_en")
        @Expose
        private String shopNameEn;
        @SerializedName("shop_name_bn")
        @Expose
        private String shopNameBn;
        @SerializedName("shop_name_hin")
        @Expose
        private String shopNameHin;

        public Integer getpId() {
            return pId;
        }

        public void setpId(Integer pId) {
            this.pId = pId;
        }

        public String getProdId() {
            return prodId;
        }

        public void setProdId(String prodId) {
            this.prodId = prodId;
        }

        public Integer getProdMarkId() {
            return prodMarkId;
        }

        public void setProdMarkId(Integer prodMarkId) {
            this.prodMarkId = prodMarkId;
        }

        public String getProdNameEn() {
            return prodNameEn;
        }

        public void setProdNameEn(String prodNameEn) {
            this.prodNameEn = prodNameEn;
        }

        public String getProdNameBn() {
            return prodNameBn;
        }

        public void setProdNameBn(String prodNameBn) {
            this.prodNameBn = prodNameBn;
        }

        public String getProdNameHin() {
            return prodNameHin;
        }

        public void setProdNameHin(String prodNameHin) {
            this.prodNameHin = prodNameHin;
        }

        public String getProdImg1() {
            return prodImg1;
        }

        public void setProdImg1(String prodImg1) {
            this.prodImg1 = prodImg1;
        }

        public Integer getPriceId() {
            return priceId;
        }

        public void setPriceId(Integer priceId) {
            this.priceId = priceId;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getqUnit() {
            return qUnit;
        }

        public void setqUnit(String qUnit) {
            this.qUnit = qUnit;
        }

        public String getMrp() {
            return mrp;
        }

        public void setMrp(String mrp) {
            this.mrp = mrp;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getProductTax() {
            return productTax;
        }

        public void setProductTax(String productTax) {
            this.productTax = productTax;
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

    }

}


