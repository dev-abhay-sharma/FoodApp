package com.swinfotech.foodapp.fragment.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class CategoryModel {

    @SerializedName("GetCat")
    @Expose
    private GetCat getCat;
    @SerializedName("GetCatDesc")
    @Expose
    private CategoryModel.GetCatDesc getCatDesc;

    /**
     * No args constructor for use in serialization
     */
    public CategoryModel() {
    }

    /**
     * @param getCat
     * @param getCatDesc
     */
    public CategoryModel(GetCat getCat, CategoryModel.GetCatDesc getCatDesc) {
        super();
        this.getCat = getCat;
        this.getCatDesc = getCatDesc;
    }

    public CategoryModel.GetCat getGetCat() {
        return getCat;
    }

    public void setGetCat(CategoryModel.GetCat getCat) {
        this.getCat = getCat;
    }

    public CategoryModel.GetCatDesc getGetCatDesc() {
        return getCatDesc;
    }

    public void setGetCatDesc(CategoryModel.GetCatDesc getCatDesc) {
        this.getCatDesc = getCatDesc;
    }







    public class GetCat {

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
        private List<Main> data = null;

        /**
         * No args constructor for use in serialization
         */
        public GetCat() {
        }

        /**
         * @param total
         * @param offset
         * @param data
         * @param limit
         * @param page
         */
        public GetCat(Integer offset, Integer limit, Integer total, Page page, List<Main> data) {
            super();
            this.offset = offset;
            this.limit = limit;
            this.total = total;
            this.page = page;
            this.data = data;
        }

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

        public List<Main> getData() {
            return data;
        }

        public void setData(List<Main> data) {
            this.data = data;
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

            /**
             * No args constructor for use in serialization
             */
            public Offset() {
            }

            /**
             * @param next
             * @param last
             * @param prev
             * @param first
             */
            public Offset(Integer first, Integer prev, Integer next, Integer last) {
                super();
                this.first = first;
                this.prev = prev;
                this.next = next;
                this.last = last;
            }

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

            /**
             * No args constructor for use in serialization
             */
            public Page() {
            }

            /**
             * @param current
             * @param total
             * @param offset
             */
            public Page(Offset offset, Integer current, Integer total) {
                super();
                this.offset = offset;
                this.current = current;
                this.total = total;
            }

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

        public class Main {


            @SerializedName("cat_id")
            @Expose
            private Integer catId;
            @SerializedName("en_name")
            @Expose
            private String enName;
            @SerializedName("bn_name")
            @Expose
            private String bnName;
            @SerializedName("hin_name")
            @Expose
            private String hinName;
            @SerializedName("image")
            @Expose
            private Object image;

            /**
             * No args constructor for use in serialization
             */
            public Main() {
            }

            /**
             * @param catId
             * @param image
             * @param enName
             * @param bnName
             * @param hinName
             */
            public Main(Integer catId, String enName, String bnName, String hinName, Object image) {
                super();
                this.catId = catId;
                this.enName = enName;
                this.bnName = bnName;
                this.hinName = hinName;
                this.image = image;
            }

            public Integer getCatId() {
                return catId;
            }

            public void setCatId(Integer catId) {
                this.catId = catId;
            }

            public String getEnName() {
                return enName;
            }

            public void setEnName(String enName) {
                this.enName = enName;
            }

            public String getBnName() {
                return bnName;
            }

            public void setBnName(String bnName) {
                this.bnName = bnName;
            }

            public String getHinName() {
                return hinName;
            }

            public void setHinName(String hinName) {
                this.hinName = hinName;
            }

            public Object getImage() {
                return image;
            }

            public void setImage(Object image) {
                this.image = image;
            }


        }

    }

    public class GetCatDesc {

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
        private Page__1 page;
        @SerializedName("data")
        @Expose
        private List<Datum__1> data = null;

        /**
         * No args constructor for use in serialization
         */
        public GetCatDesc() {
        }

        /**
         * @param total
         * @param offset
         * @param data
         * @param limit
         * @param page
         */
        public GetCatDesc(Integer offset, Integer limit, Integer total, Page__1 page, List<Datum__1> data) {
            super();
            this.offset = offset;
            this.limit = limit;
            this.total = total;
            this.page = page;
            this.data = data;
        }

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

        public Page__1 getPage() {
            return page;
        }

        public void setPage(Page__1 page) {
            this.page = page;
        }

        public List<Datum__1> getData() {
            return data;
        }

        public void setData(List<Datum__1> data) {
            this.data = data;
        }


        public class Page__1 {

            @SerializedName("offset")
            @Expose
            private Offset__1 offset;
            @SerializedName("current")
            @Expose
            private Integer current;
            @SerializedName("total")
            @Expose
            private Integer total;

            /**
             * No args constructor for use in serialization
             */
            public Page__1() {
            }

            /**
             * @param current
             * @param total
             * @param offset
             */
            public Page__1(Offset__1 offset, Integer current, Integer total) {
                super();
                this.offset = offset;
                this.current = current;
                this.total = total;
            }

            public Offset__1 getOffset() {
                return offset;
            }

            public void setOffset(Offset__1 offset) {
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

        public class Datum__1 {

            @SerializedName("cat_id")
            @Expose
            private Integer catId;
            @SerializedName("en_name")
            @Expose
            private String enName;
            @SerializedName("bn_name")
            @Expose
            private String bnName;
            @SerializedName("hin_name")
            @Expose
            private String hinName;
            @SerializedName("image")
            @Expose
            private String image;

            /**
             * No args constructor for use in serialization
             */
            public Datum__1() {
            }

            /**
             * @param catId
             * @param image
             * @param enName
             * @param bnName
             * @param hinName
             */
            public Datum__1(Integer catId, String enName, String bnName, String hinName, String image) {
                super();
                this.catId = catId;
                this.enName = enName;
                this.bnName = bnName;
                this.hinName = hinName;
                this.image = image;
            }

            public Integer getCatId() {
                return catId;
            }

            public void setCatId(Integer catId) {
                this.catId = catId;
            }

            public String getEnName() {
                return enName;
            }

            public void setEnName(String enName) {
                this.enName = enName;
            }

            public String getBnName() {
                return bnName;
            }

            public void setBnName(String bnName) {
                this.bnName = bnName;
            }

            public String getHinName() {
                return hinName;
            }

            public void setHinName(String hinName) {
                this.hinName = hinName;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

        }
        public class Offset__1 {

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

            /**
             * No args constructor for use in serialization
             */
            public Offset__1() {
            }

            /**
             * @param next
             * @param last
             * @param prev
             * @param first
             */
            public Offset__1(Integer first, Integer prev, Integer next, Integer last) {
                super();
                this.first = first;
                this.prev = prev;
                this.next = next;
                this.last = last;
            }

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
    }





}

