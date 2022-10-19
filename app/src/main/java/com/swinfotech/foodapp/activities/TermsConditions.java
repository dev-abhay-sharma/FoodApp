package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityTermsConditionsBinding;

public class TermsConditions extends AppCompatActivity {

    ActivityTermsConditionsBinding binding;
    TermsConditions activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsConditionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.termsBack.setOnClickListener(v -> onBackPressed());
    }
}