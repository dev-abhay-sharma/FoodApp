package com.swinfotech.foodapp.api;

import com.swinfotech.foodapp.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        return retrofit;
    }

    public static RetrofitAPIService getService() {
        RetrofitAPIService retrofitAPIService = getClient().create(RetrofitAPIService.class);
        return retrofitAPIService;
    }
}
