package com.swinfotech.foodapp.fragment.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardInfoModel {
        @SerializedName("GetCartItems")
        @Expose
        private GetCartItems getCartItems;
        @SerializedName("GetWishlist")
        @Expose
        private GetWishlist getWishlist;

        public GetCartItems getGetCartItems() {
            return getCartItems;
        }

        public void setGetCartItems(GetCartItems getCartItems) {
            this.getCartItems = getCartItems;
        }

        public GetWishlist getGetWishlist() {
            return getWishlist;
        }

        public void setGetWishlist(GetWishlist getWishlist) {
            this.getWishlist = getWishlist;
        }


    public class GetCartItems {

        @SerializedName("Cart_Items")
        @Expose
        private String cartItems;

        public String getCartItems() {
            return cartItems;
        }

        public void setCartItems(String cartItems) {
            this.cartItems = cartItems;
        }

    }
    public class GetWishlist {

        @SerializedName("WishlistItems")
        @Expose
        private String wishlistItems;

        public String getWishlistItems() {
            return wishlistItems;
        }

        public void setWishlistItems(String wishlistItems) {
            this.wishlistItems = wishlistItems;
        }

    }


}
