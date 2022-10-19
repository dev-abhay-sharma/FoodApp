package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityPrivacyPolicyBinding;

public class PrivacyPolicy extends AppCompatActivity {

    ActivityPrivacyPolicyBinding binding;
    PrivacyPolicy activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacyPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.privacyBack.setOnClickListener(v -> onBackPressed());
    }
}