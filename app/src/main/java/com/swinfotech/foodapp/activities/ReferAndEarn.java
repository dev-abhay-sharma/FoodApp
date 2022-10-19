package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityReferAndEarnBinding;

public class ReferAndEarn extends AppCompatActivity {

    ActivityReferAndEarnBinding binding;
    ReferAndEarn activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReferAndEarnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.referBack.setOnClickListener(v -> onBackPressed());

    }
}