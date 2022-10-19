package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.PopularFoodNearByActivityAdapter;
import com.swinfotech.foodapp.databinding.ActivityPopularFoodNearByBinding;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;

import java.util.ArrayList;
import java.util.List;

public class PopularFoodNearBy extends AppCompatActivity {

    ActivityPopularFoodNearByBinding binding;
    PopularFoodNearBy activity;

    private PopularFoodNearByActivityAdapter popularFoodNearByActivityAdapter;
    List<BestReviewedFoodModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopularFoodNearByBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

        getPopularFoodNearBy();

    }

    private void getPopularFoodNearBy() {
        binding.popularFoodNearByActivityRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.popularFoodNearByActivityRecView.setHasFixedSize(true);
        popularFoodNearByActivityAdapter = new PopularFoodNearByActivityAdapter(activity, modelList);
        binding.popularFoodNearByActivityRecView.setAdapter(popularFoodNearByActivityAdapter);

        modelList.clear();
        modelList.add(new BestReviewedFoodModel("https://media.istockphoto.com/photos/medu-vada-a-popular-south-indian-food-medu-vadai-with-sambar-picture-id1345534187?b=1&k=20&m=1345534187&s=612x612&w=0&h=y47kYpHZLd_YTJSOuQXrOoCZ-4uIjdKaCJUe9jo70M0=", "Medu Vada"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/2591594/pexels-photo-2591594.jpeg?auto=compress&cs=tinysrgb&w=600", "Ramen"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/8983410/pexels-photo-8983410.jpeg?auto=compress&cs=tinysrgb&w=600", "Thai Stir Fried Noodles"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/3616956/pexels-photo-3616956.jpeg?auto=compress&cs=tinysrgb&w=600", "Burger Combo"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/1146760/pexels-photo-1146760.jpeg?auto=compress&cs=tinysrgb&w=600", "Meat Pizza"));
    }

    private void onClick() {
        // for activity back
        binding.popularFoodNearByBack.setOnClickListener(v -> onBackPressed());

        // for choose

        binding.popularFoodNearByAll.setOnClickListener(v -> {
            binding.popularFoodNearByAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularFoodNearByAll.setTextColor(getResources().getColor(R.color.white));

            binding.popularFoodNearByVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularFoodNearByVeg.setTextColor(getResources().getColor(R.color.black));

            binding.popularFoodNearByNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularFoodNearByNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.popularFoodNearByVeg.setOnClickListener(v -> {
            binding.popularFoodNearByVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularFoodNearByVeg.setTextColor(getResources().getColor(R.color.white));

            binding.popularFoodNearByAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularFoodNearByAll.setTextColor(getResources().getColor(R.color.black));

            binding.popularFoodNearByNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularFoodNearByNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.popularFoodNearByNonVeg.setOnClickListener(v -> {
            binding.popularFoodNearByNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.popularFoodNearByNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.popularFoodNearByAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularFoodNearByAll.setTextColor(getResources().getColor(R.color.black));

            binding.popularFoodNearByVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.popularFoodNearByVeg.setTextColor(getResources().getColor(R.color.black));
        });


    }
}