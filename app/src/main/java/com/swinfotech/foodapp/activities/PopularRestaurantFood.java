package com.swinfotech.foodapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.PopularFoodNearByActivityAdapter;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.ActivityPopularRestaurantFoodBinding;
import com.swinfotech.foodapp.fragment.models.home.RestaurantDetails;
import com.swinfotech.foodapp.fragment.models.home.RestaurantProducts;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularRestaurantFood extends AppCompatActivity {

    ActivityPopularRestaurantFoodBinding binding;
    PopularRestaurantFood activity;

    private PopularFoodNearByActivityAdapter popularFoodNearByActivityAdapter;
    List<BestReviewedFoodModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopularRestaurantFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        getIntentData();

        onClick();
        getPopularRestaurantFood();


    }

    private void getRestaurantDetails(String id) {
        RetrofitBuilder.getService().getRestaurantDetails("1", id)
                .enqueue(new Callback<RestaurantDetails>() {
                    @Override
                    public void onResponse(Call<RestaurantDetails> call, Response<RestaurantDetails> response) {
                        if (response.body() != null) {
                            binding.popularRestaurantFoodName.setText(response.body().getGetShops().getShopNameEn());
                            binding.popularRestaurantAddr.setText(response.body().getGetShops().getAddress());
                            Glide.with(activity).load(Constants.IMAGE_BASE_URL + response.body().getGetShops().getShopLogo()).into(binding.popularRestaurantFoodSmallImg);
                            Glide.with(activity).load(Constants.IMAGE_BASE_URL + response.body().getGetShops().getShopLogo()).into(binding.popularRestaurantFoodImg);
                        }
                    }

                    @Override
                    public void onFailure(Call<RestaurantDetails> call, Throwable t) {

                    }
                });
    }

    private void getIntentData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        String id = intent.getStringExtra("id");
        getRestaurantDetails(id);
        getProducts(id);
        Glide.with(activity).load(img).into(binding.popularRestaurantFoodImg);
        Glide.with(activity).load(img).into(binding.popularRestaurantFoodSmallImg);
        binding.popularRestaurantFoodName.setText(name);
    }

    private void getPopularRestaurantFood() {
        binding.popularRestaurantFoodRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.popularRestaurantFoodRecView.setHasFixedSize(true);
        popularFoodNearByActivityAdapter = new PopularFoodNearByActivityAdapter(activity, modelList);
        binding.popularRestaurantFoodRecView.setAdapter(popularFoodNearByActivityAdapter);

    }

    private void getProducts(String id) {

        RetrofitBuilder.getService().getStoreProducts("1", "1000", "3")
                .enqueue(new Callback<RestaurantProducts>() {
                    @Override
                    public void onResponse(Call<RestaurantProducts> call, Response<RestaurantProducts> response) {
                        if (response.body() != null) {
                          //  Log.e("TAG", "onResponse: "+response.body().getGetProd().getData().get(0).getProdNameEn());
                            for (int i = 0; i < response.body().getGetProd().getData().size(); i++) {
                                modelList.add(new BestReviewedFoodModel(response.body().getGetProd().getData().get(i).getProdImg1(),
                                        response.body().getGetProd().getData().get(i).getProdNameEn()));
                            }
                            binding.popularRestaurantFoodRecView.getAdapter().notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<RestaurantProducts> call, Throwable t) {

                    }
                });
    }

    private void onClick() {
        binding.popularRestaurantFoodBack.setOnClickListener(v -> onBackPressed());

        binding.popularRestaurantFoodSearch.setOnClickListener(v -> {
            startActivity(new Intent(activity, SearchPopularRestaurantFood.class));
        });

        binding.popularRestaurantFoodReviews.setOnClickListener(v -> {
            startActivity(new Intent(activity, PopularRestaurantFoodReviews.class));
        });

        binding.popularRestaurantFoodAll.setOnClickListener(v -> {
            binding.popularRestaurantFoodAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularRestaurantFoodAll.setTextColor(getResources().getColor(R.color.white));

            binding.popularRestaurantFoodVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantFoodVeg.setTextColor(getResources().getColor(R.color.black));

            binding.popularRestaurantFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantFoodNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.popularRestaurantFoodVeg.setOnClickListener(v -> {
            binding.popularRestaurantFoodVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularRestaurantFoodVeg.setTextColor(getResources().getColor(R.color.white));

            binding.popularRestaurantFoodAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantFoodAll.setTextColor(getResources().getColor(R.color.black));

            binding.popularRestaurantFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantFoodNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.popularRestaurantFoodNonVeg.setOnClickListener(v -> {
            binding.popularRestaurantFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularRestaurantFoodNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.popularRestaurantFoodAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantFoodAll.setTextColor(getResources().getColor(R.color.black));

            binding.popularRestaurantFoodVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantFoodVeg.setTextColor(getResources().getColor(R.color.black));
        });

    }
}