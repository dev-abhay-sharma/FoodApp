package com.swinfotech.foodapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Constants {
    public static final String BASE_URL="https://gravitto.com/api/Android/";
    public static final String LOGIN="Users/SignIn";
    public static final String SIGNUP="Users/SignUp";
    public static final String ACTIVE_RESTAURANTS="Restaurants/ActiveRestaurants";
    public static final String ACTIVE_CATEGORIES="Category/ActiveCategory";
    public static final String POPULAR_PRODUCTS="Products/PopularProducts";
    public static final String TOKEN="loginToken";
    public static final String IMAGE_BASE_URL="https://secure.gravitto.com";
    public static final String GET_RESTATURANT_DETAILS = "Restaurants/ShopDetails";
    public static final String GET_PRODUCT_DETAILS = "Products/ProdDetails";
    public static final String GET_STORE_PRODUCTS = "Products/RestProducts";
    public static final String GET_DASHBOARD_INFO = "/Dashboard/DashboardInfo";

    static  String dbName = "food_app";

    public static String getString(String key, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(dbName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");

    }

    public static void setString(String key, String value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(dbName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value); // Storing string
        editor.apply();

    }


}

