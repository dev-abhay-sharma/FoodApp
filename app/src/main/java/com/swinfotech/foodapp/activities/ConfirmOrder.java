package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityConfirmOrderBinding;

public class ConfirmOrder extends AppCompatActivity {

    ActivityConfirmOrderBinding binding;
    ConfirmOrder activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.backToHome.setOnClickListener(v -> onBackPressed());
    }
}