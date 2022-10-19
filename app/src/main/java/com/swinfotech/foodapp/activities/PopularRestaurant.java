package com.swinfotech.foodapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.NewOnStackFoodActivityAdapter;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.ActivityPopularRestaurantBinding;
import com.swinfotech.foodapp.fragment.models.home.ActiveRestaurantModel;
import com.swinfotech.foodapp.model.PopularRestaurantsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularRestaurant extends AppCompatActivity {

    ActivityPopularRestaurantBinding binding;
    PopularRestaurant activity;

    // we get newOnStackFood adapter here because that adapter have same list ----- we can change later if we want other list

    private NewOnStackFoodActivityAdapter newOnStackFoodActivityAdapter;
    List<PopularRestaurantsModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopularRestaurantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

        getPopularRestaurant();

    }

    private void getPopularRestaurant() {
        binding.popularRestaurantActivityRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.popularRestaurantActivityRecView.setHasFixedSize(true);
        newOnStackFoodActivityAdapter = new NewOnStackFoodActivityAdapter(activity, modelList);
        binding.popularRestaurantActivityRecView.setAdapter(newOnStackFoodActivityAdapter);
        getActiveRestaurants();

    }


    private void getActiveRestaurants() {

        RetrofitBuilder.getService().getActiveRestaurant("1", "100")
                .enqueue(new Callback<ActiveRestaurantModel>() {
                    @Override
                    public void onResponse(Call<ActiveRestaurantModel> call, Response<ActiveRestaurantModel> response) {
                        modelList.clear();
                        if (response.body().getFetchRest().size() > 0) {
                            for (int i = 0; i < response.body().getFetchRest().size(); i++) {
                                modelList.add(new PopularRestaurantsModel(
                                        response.body().getFetchRest().get(i).getId() + "",
                                        response.body().getFetchRest().get(i).getShopLogo(),
                                        response.body().getFetchRest().get(i).getShopNameEn()
                                ));

                            }
                        }
                        binding.popularRestaurantActivityRecView.getAdapter().notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<ActiveRestaurantModel> call, Throwable t) {

                    }
                });


    }


    private void onClick() {

        binding.popularRestaurantBack.setOnClickListener(v -> onBackPressed());

        binding.popularRestaurantAll.setOnClickListener(v -> {
            binding.popularRestaurantAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularRestaurantAll.setTextColor(getResources().getColor(R.color.white));

            binding.popularRestaurantVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantVeg.setTextColor(getResources().getColor(R.color.black));

            binding.popularRestaurantNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.popularRestaurantVeg.setOnClickListener(v -> {
            binding.popularRestaurantVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularRestaurantVeg.setTextColor(getResources().getColor(R.color.white));

            binding.popularRestaurantAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantAll.setTextColor(getResources().getColor(R.color.black));

            binding.popularRestaurantNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.popularRestaurantNonVeg.setOnClickListener(v -> {
            binding.popularRestaurantNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularRestaurantNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.popularRestaurantAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantAll.setTextColor(getResources().getColor(R.color.black));

            binding.popularRestaurantVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularRestaurantVeg.setTextColor(getResources().getColor(R.color.black));
        });
    }
}