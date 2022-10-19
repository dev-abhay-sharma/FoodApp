package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.adapter.PopularRestaurantFoodReviewsAdapter;
import com.swinfotech.foodapp.databinding.ActivityPopularRestaurantFoodReviewsBinding;
import com.swinfotech.foodapp.model.AllRestaurantsModel;

import java.util.ArrayList;
import java.util.List;

public class PopularRestaurantFoodReviews extends AppCompatActivity {

    ActivityPopularRestaurantFoodReviewsBinding binding;
    PopularRestaurantFoodReviews activity;

    private PopularRestaurantFoodReviewsAdapter popularRestaurantFoodReviewsAdapter;
    List<AllRestaurantsModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopularRestaurantFoodReviewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.pRFReviewsBack.setOnClickListener(v -> onBackPressed());

        getReviews();

    }

    private void getReviews() {
        binding.pRFReviewsRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.pRFReviewsRecView.setHasFixedSize(true);
        popularRestaurantFoodReviewsAdapter = new PopularRestaurantFoodReviewsAdapter(activity, modelList);
        binding.pRFReviewsRecView.setAdapter(popularRestaurantFoodReviewsAdapter);

        modelList.clear();
        modelList.add(new AllRestaurantsModel("https://images.pexels.com/photos/905847/pexels-photo-905847.jpeg?auto=compress&cs=tinysrgb&w=600", "Meet Pizza"));
        modelList.add(new AllRestaurantsModel("https://images.pexels.com/photos/905847/pexels-photo-905847.jpeg?auto=compress&cs=tinysrgb&w=600", "Meet Pizza"));
        modelList.add(new AllRestaurantsModel("https://images.pexels.com/photos/905847/pexels-photo-905847.jpeg?auto=compress&cs=tinysrgb&w=600", "Meet Pizza"));
    }
}