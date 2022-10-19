package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.PopularFoodNearByActivityAdapter;
import com.swinfotech.foodapp.databinding.ActivityNewOnStackFoodItemBinding;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;

import java.util.ArrayList;
import java.util.List;

public class NewOnStackFoodItem extends AppCompatActivity {

    ActivityNewOnStackFoodItemBinding binding;
    NewOnStackFoodItem activity;

//    now we use this adapter and list for only for example showing we can create new one when we get data
    private PopularFoodNearByActivityAdapter popularFoodNearByActivityAdapter;
    List<BestReviewedFoodModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOnStackFoodItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        getIntentData();
        onClick();
        getNewOnStackItem();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        Glide.with(activity).load(img).into(binding.newOnStackFoodItemImg);
        Glide.with(activity).load(img).into(binding.newOnStackFoodItemSmallImg);
        binding.newOnStackFoodItemName.setText(name);

        if (binding.newOnStackFoodItemName.getText().toString().equalsIgnoreCase("Indian Food")){
            binding.newOnStackFoodItemFreeDelivery.setVisibility(View.GONE);
        } else if (binding.newOnStackFoodItemName.getText().toString().equalsIgnoreCase("Mexican Food")) {
            binding.newOnStackFoodItemFreeDelivery.setVisibility(View.GONE);
        }
    }

    private void getNewOnStackItem() {
        binding.popularRestaurantFoodRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.popularRestaurantFoodRecView.setHasFixedSize(true);
        popularFoodNearByActivityAdapter = new PopularFoodNearByActivityAdapter(activity, modelList);
        binding.popularRestaurantFoodRecView.setAdapter(popularFoodNearByActivityAdapter);

        modelList.clear();
        modelList.add(new BestReviewedFoodModel("https://media.istockphoto.com/photos/medu-vada-a-popular-south-indian-food-medu-vadai-with-sambar-picture-id1345534187?b=1&k=20&m=1345534187&s=612x612&w=0&h=y47kYpHZLd_YTJSOuQXrOoCZ-4uIjdKaCJUe9jo70M0=", "Medu Vada"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/2591594/pexels-photo-2591594.jpeg?auto=compress&cs=tinysrgb&w=600", "Ramen"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/8983410/pexels-photo-8983410.jpeg?auto=compress&cs=tinysrgb&w=600", "Thai Stir Fried Noodles"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/3616956/pexels-photo-3616956.jpeg?auto=compress&cs=tinysrgb&w=600", "Burger Combo"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/1146760/pexels-photo-1146760.jpeg?auto=compress&cs=tinysrgb&w=600", "Meat Pizza"));

    }

    private void onClick() {
        binding.newOnStackFoodItemBack.setOnClickListener(v -> onBackPressed());

        binding.newOnStackFoodItemBackSearch.setOnClickListener(v -> {
            startActivity(new Intent(activity, SearchPopularRestaurantFood.class));
        });

        binding.newOnStackFoodItemReviews.setOnClickListener(v -> {
            startActivity(new Intent(activity, PopularRestaurantFoodReviews.class));
        });

        binding.newOnStackFoodItemAll.setOnClickListener(v -> {
            binding.newOnStackFoodItemAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.newOnStackFoodItemAll.setTextColor(getResources().getColor(R.color.white));

            binding.newOnStackFoodItemVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodItemVeg.setTextColor(getResources().getColor(R.color.black));

            binding.newOnStackFoodItemNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodItemNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.newOnStackFoodItemVeg.setOnClickListener(v -> {
            binding.newOnStackFoodItemVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.newOnStackFoodItemVeg.setTextColor(getResources().getColor(R.color.white));

            binding.newOnStackFoodItemAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodItemAll.setTextColor(getResources().getColor(R.color.black));

            binding.newOnStackFoodItemNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodItemNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.newOnStackFoodItemNonVeg.setOnClickListener(v -> {
            binding.newOnStackFoodItemNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.newOnStackFoodItemNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.newOnStackFoodItemAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodItemAll.setTextColor(getResources().getColor(R.color.black));

            binding.newOnStackFoodItemVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.newOnStackFoodItemVeg.setTextColor(getResources().getColor(R.color.black));
        });
    }
}