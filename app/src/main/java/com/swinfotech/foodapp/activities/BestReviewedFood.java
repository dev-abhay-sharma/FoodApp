package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.BestReviewedFoodActivityAdapter;
import com.swinfotech.foodapp.databinding.ActivityBestReviewedFoodBinding;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;

import java.util.ArrayList;
import java.util.List;

public class BestReviewedFood extends AppCompatActivity {

    ActivityBestReviewedFoodBinding binding;
    BestReviewedFood activity;

    private BestReviewedFoodActivityAdapter bestReviewedFoodActivityAdapter;
    List<BestReviewedFoodModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBestReviewedFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

        getBestReviewedFood();

    }

    private void getBestReviewedFood() {
        binding.bestReviewedFoodActivityRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.bestReviewedFoodActivityRecView.setHasFixedSize(true);
        bestReviewedFoodActivityAdapter = new BestReviewedFoodActivityAdapter(activity, modelList);
        binding.bestReviewedFoodActivityRecView.setAdapter(bestReviewedFoodActivityAdapter);

        modelList.clear();
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/2725744/pexels-photo-2725744.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Burger Combo"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/3023476/pexels-photo-3023476.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Meat Pizza"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/4393021/pexels-photo-4393021.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Veg Momos"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/983297/pexels-photo-983297.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Peanut Butter Molter Cake"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/12362923/pexels-photo-12362923.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Grilled Kebab"));
    }

    private void onClick() {
        // for activity back
        binding.bestReviewedFoodBack.setOnClickListener(v -> onBackPressed());

        // for choose

        binding.bRFoodAll.setOnClickListener(v -> {
            binding.bRFoodAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.bRFoodAll.setTextColor(getResources().getColor(R.color.white));

            binding.bRFoodVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bRFoodVeg.setTextColor(getResources().getColor(R.color.black));

            binding.bRFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bRFoodNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.bRFoodVeg.setOnClickListener(v -> {
            binding.bRFoodVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.bRFoodVeg.setTextColor(getResources().getColor(R.color.white));

            binding.bRFoodAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bRFoodAll.setTextColor(getResources().getColor(R.color.black));

            binding.bRFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bRFoodNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.bRFoodNonVeg.setOnClickListener(v -> {
            binding.bRFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.bRFoodNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.bRFoodAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bRFoodAll.setTextColor(getResources().getColor(R.color.black));

            binding.bRFoodVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bRFoodVeg.setTextColor(getResources().getColor(R.color.black));
        });


    }
}