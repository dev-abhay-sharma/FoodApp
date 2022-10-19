package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivitySearchPopularRestaurantFoodBinding;

public class SearchPopularRestaurantFood extends AppCompatActivity {

    ActivitySearchPopularRestaurantFoodBinding binding;
    SearchPopularRestaurantFood activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchPopularRestaurantFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.searchPopularRestaurantBack.setOnClickListener(v -> onBackPressed());

    }
}