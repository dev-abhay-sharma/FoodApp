package com.swinfotech.foodapp.fragment.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantProducts {
    @SerializedName("GetProd")
    @Expose
    private GetProd getProd;

    public GetProd getGetProd() {
        return getProd;
    }

    public void setGetProd(GetProd getProd) {
        this.getProd = getProd;
    }


    public class Offset {

        @SerializedName("first")
        @Expose
        private Integer first;
        @SerializedName("prev")
        @Expose
        private Integer prev;
        @SerializedName("next")
        @Expose
        private Integer next;
        @SerializedName("last")
        @Expose
        private Integer last;

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getPrev() {
            return prev;
        }

        public void setPrev(Integer prev) {
            this.prev = prev;
        }

        public Integer getNext() {
            return next;
        }

        public void setNext(Integer next) {
            this.next = next;
        }

        public Integer getLast() {
            return last;
        }

        public void setLast(Integer last) {
            this.last = last;
        }

    }

    public class Page {

        @SerializedName("offset")
        @Expose
        private Offset offset;
        @SerializedName("current")
        @Expose
        private Integer current;
        @SerializedName("total")
        @Expose
        private Integer total;

        public Offset getOffset() {
            return offset;
        }

        public void setOffset(Offset offset) {
            this.offset = offset;
        }

        public Integer getCurrent() {
            return current;
        }

        public void setCurrent(Integer current) {
            this.current = current;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

    }


    public class GetProd {

        @SerializedName("offset")
        @Expose
        private Integer offset;
        @SerializedName("limit")
        @Expose
        private Integer limit;
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("page")
        @Expose
        private Page page;
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Page getPage() {
            return page;
        }

        public void setPage(Page page) {
            this.page = page;
        }

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }

        public class Datum {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("prod_id")
            @Expose
            private String prodId;
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
            @SerializedName("video")
            @Expose
            private Object video;
            @SerializedName("prod_img1")
            @Expose
            private String prodImg1;
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

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
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

            public Object getVideo() {
                return video;
            }

            public void setVideo(Object video) {
                this.video = video;
            }

            public String getProdImg1() {
                return prodImg1;
            }

            public void setProdImg1(String prodImg1) {
                this.prodImg1 = prodImg1;
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

        }

    }

}
