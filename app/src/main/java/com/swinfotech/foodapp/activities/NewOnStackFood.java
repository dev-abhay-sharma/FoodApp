package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.NewOnStackFoodActivityAdapter;
import com.swinfotech.foodapp.databinding.ActivityNewOnStackFoodBinding;
import com.swinfotech.foodapp.model.AllRestaurantsModel;

import java.util.ArrayList;
import java.util.List;

public class NewOnStackFood extends AppCompatActivity {

    ActivityNewOnStackFoodBinding binding;
    NewOnStackFood activity;

    private NewOnStackFoodActivityAdapter newOnStackFoodActivityAdapter;
    List<AllRestaurantsModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOnStackFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

        getNewOnStackFood();

    }

    private void getNewOnStackFood() {
        binding.newOnStackFoodActivityRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.newOnStackFoodActivityRecView.setHasFixedSize(true);
       // newOnStackFoodActivityAdapter = new NewOnStackFoodActivityAdapter(activity, modelList);
       // binding.newOnStackFoodActivityRecView.setAdapter(newOnStackFoodActivityAdapter);

        modelList.clear();
        modelList.add(new AllRestaurantsModel("https://w7.pngwing.com/pngs/524/137/png-transparent-restaurant-logo-illustration-gluten-free-diet-logo-celiac-disease-wheat-restaurant-logo-emblem-food-free-logo-design-template.png", "Italian Fast Food"));
        modelList.add(new AllRestaurantsModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "Pizza Restaurant"));
        modelList.add(new AllRestaurantsModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyw81enKDCmQjBoiEvuFZGUjGqB-s4RmDqgjUVaSQOes2LUA977c2fTAdEfcBPGMgq4RU&usqp=CAU", "Mini kebab"));
        modelList.add(new AllRestaurantsModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "Redcliff Cafe"));
        modelList.add(new AllRestaurantsModel("https://w7.pngwing.com/pngs/524/137/png-transparent-restaurant-logo-illustration-gluten-free-diet-logo-celiac-disease-wheat-restaurant-logo-emblem-food-free-logo-design-template.png", "Tasty Lunch"));
    }

    private void onClick() {
        // for activity back
        binding.newOnStackFoodBack.setOnClickListener(v -> onBackPressed());


        binding.newOnStackFoodAll.setOnClickListener(v -> {
            binding.newOnStackFoodAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.newOnStackFoodAll.setTextColor(getResources().getColor(R.color.white));

            binding.newOnStackFoodVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodVeg.setTextColor(getResources().getColor(R.color.black));

            binding.newOnStackFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.newOnStackFoodVeg.setOnClickListener(v -> {
            binding.newOnStackFoodVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.newOnStackFoodVeg.setTextColor(getResources().getColor(R.color.white));

            binding.newOnStackFoodAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodAll.setTextColor(getResources().getColor(R.color.black));

            binding.newOnStackFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.newOnStackFoodNonVeg.setOnClickListener(v -> {
            binding.newOnStackFoodNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.newOnStackFoodNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.newOnStackFoodAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodAll.setTextColor(getResources().getColor(R.color.black));

            binding.newOnStackFoodVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodVeg.setTextColor(getResources().getColor(R.color.black));
        });
    }
}