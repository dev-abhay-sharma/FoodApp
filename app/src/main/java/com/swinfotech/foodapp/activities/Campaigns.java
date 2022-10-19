package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.adapter.CampaignsActivityAdapter;
import com.swinfotech.foodapp.databinding.ActivityCampaignsBinding;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;

import java.util.ArrayList;
import java.util.List;

public class Campaigns extends AppCompatActivity {

    ActivityCampaignsBinding binding;
    Campaigns activity;

    private CampaignsActivityAdapter campaignsActivityAdapter;
    List<BestReviewedFoodModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCampaignsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.campaignsBack.setOnClickListener(v -> onBackPressed());

        getCampaigns();

    }

    private void getCampaigns() {
        binding.campaignsActivityRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.campaignsActivityRecView.setHasFixedSize(true);
        campaignsActivityAdapter = new CampaignsActivityAdapter(activity, modelList);
        binding.campaignsActivityRecView.setAdapter(campaignsActivityAdapter);

        modelList.clear();
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/775863/pexels-photo-775863.jpeg?auto=compress&cs=tinysrgb&w=600", "Spicy Crab Early Food"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/3738730/pexels-photo-3738730.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Cheese Burger"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/437716/pexels-photo-437716.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Cappuccino Coffee"));
    }
}