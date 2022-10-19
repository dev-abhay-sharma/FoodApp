package com.swinfotech.foodapp.api;

import com.swinfotech.foodapp.fragment.models.home.ActiveRestaurantModel;
import com.swinfotech.foodapp.fragment.models.home.CategoryModel;
import com.swinfotech.foodapp.fragment.models.home.DashboardInfoModel;
import com.swinfotech.foodapp.fragment.models.home.PopularProducts;
import com.swinfotech.foodapp.fragment.models.home.ProductDetails;
import com.swinfotech.foodapp.fragment.models.home.RestaurantDetails;
import com.swinfotech.foodapp.fragment.models.home.RestaurantProducts;
import com.swinfotech.foodapp.signin.models.LoginModel;
import com.swinfotech.foodapp.signin.models.SignUpModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPIService {

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST(Constants.LOGIN)
    Call<LoginModel> login(@Body HashMap<String, String> body);

    @POST(Constants.SIGNUP)
    Call<SignUpModel> signup(@Body HashMap<String, String> body);

    @POST(Constants.ACTIVE_CATEGORIES)
    Call<CategoryModel> getCategories(@Query("market") String market);

    @POST(Constants.POPULAR_PRODUCTS)
    Call<PopularProducts> getPopularProducts(@Query("market") String market,
                                             @Query("limit") String limit);

    @POST(Constants.ACTIVE_RESTAURANTS)
    Call<ActiveRestaurantModel> getActiveRestaurant(@Query("market") String market,
                                                    @Query("limit") String limit);

    @POST(Constants.GET_RESTATURANT_DETAILS)
    Call<RestaurantDetails> getRestaurantDetails(@Query("market") String market,
                                                 @Query("rest_id") String rest_id);


    @POST(Constants.GET_PRODUCT_DETAILS)
    Call<ProductDetails> getProductDetails(@Query("market") String market,
                                           @Query("p_id") String p_id);
    @POST(Constants.GET_STORE_PRODUCTS)
    Call<RestaurantProducts> getStoreProducts(@Query("market") String market,
                                              @Query("limit") String rest_id,
                                              @Query("rest_id") String p_id);


    @POST(Constants.GET_DASHBOARD_INFO)
    Call<DashboardInfoModel> getDashboardInfo(@Query("logintoken") String market);



    /*@POST(Constants.ACTIVE_CATEGORIES)
     */
    // Call<CategoryModel> getCategories(@Query("market") String market);
}
