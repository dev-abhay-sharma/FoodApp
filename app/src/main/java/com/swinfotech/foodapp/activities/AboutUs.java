package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityAboutUsBinding;

public class AboutUs extends AppCompatActivity {

    ActivityAboutUsBinding binding;
    AboutUs activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.aboutBack.setOnClickListener(v -> onBackPressed());

    }
}