package com.swinfotech.foodapp.fragment.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDetails {
    @SerializedName("GetProdDetails")
    @Expose
    private GetProdDetails getProdDetails;

    public GetProdDetails getGetProdDetails() {
        return getProdDetails;
    }

    public void setGetProdDetails(GetProdDetails getProdDetails) {
        this.getProdDetails = getProdDetails;
    }

    public class GetProdDetails {

        @SerializedName("p_id")
        @Expose
        private Integer pId;
        @SerializedName("prod_id")
        @Expose
        private String prodId;
        @SerializedName("rest_id")
        @Expose
        private Integer restId;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("prod_mark_id")
        @Expose
        private Integer prodMarkId;
        @SerializedName("prod_occurance_id")
        @Expose
        private Integer prodOccuranceId;
        @SerializedName("prod_name_en")
        @Expose
        private String prodNameEn;
        @SerializedName("prod_name_bn")
        @Expose
        private String prodNameBn;
        @SerializedName("prod_name_hin")
        @Expose
        private String prodNameHin;
        @SerializedName("prod_desc_en")
        @Expose
        private String prodDescEn;
        @SerializedName("prod_desc_bn")
        @Expose
        private String prodDescBn;
        @SerializedName("prod_desc_hin")
        @Expose
        private String prodDescHin;
        @SerializedName("prod_img1")
        @Expose
        private String prodImg1;
        @SerializedName("prod_img2")
        @Expose
        private String prodImg2;
        @SerializedName("prod_img3")
        @Expose
        private String prodImg3;
        @SerializedName("prod_img4")
        @Expose
        private String prodImg4;
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
        @SerializedName("price_id")
        @Expose
        private Integer priceId;
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

        public Integer getRestId() {
            return restId;
        }

        public void setRestId(Integer restId) {
            this.restId = restId;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getProdMarkId() {
            return prodMarkId;
        }

        public void setProdMarkId(Integer prodMarkId) {
            this.prodMarkId = prodMarkId;
        }

        public Integer getProdOccuranceId() {
            return prodOccuranceId;
        }

        public void setProdOccuranceId(Integer prodOccuranceId) {
            this.prodOccuranceId = prodOccuranceId;
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

        public String getProdDescEn() {
            return prodDescEn;
        }

        public void setProdDescEn(String prodDescEn) {
            this.prodDescEn = prodDescEn;
        }

        public String getProdDescBn() {
            return prodDescBn;
        }

        public void setProdDescBn(String prodDescBn) {
            this.prodDescBn = prodDescBn;
        }

        public String getProdDescHin() {
            return prodDescHin;
        }

        public void setProdDescHin(String prodDescHin) {
            this.prodDescHin = prodDescHin;
        }

        public String getProdImg1() {
            return prodImg1;
        }

        public void setProdImg1(String prodImg1) {
            this.prodImg1 = prodImg1;
        }

        public String getProdImg2() {
            return prodImg2;
        }

        public void setProdImg2(String prodImg2) {
            this.prodImg2 = prodImg2;
        }

        public String getProdImg3() {
            return prodImg3;
        }

        public void setProdImg3(String prodImg3) {
            this.prodImg3 = prodImg3;
        }

        public String getProdImg4() {
            return prodImg4;
        }

        public void setProdImg4(String prodImg4) {
            this.prodImg4 = prodImg4;
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

        public Integer getPriceId() {
            return priceId;
        }

        public void setPriceId(Integer priceId) {
            this.priceId = priceId;
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
