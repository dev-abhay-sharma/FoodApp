package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityHelpSupportBinding;

public class HelpSupport extends AppCompatActivity {

    ActivityHelpSupportBinding binding;
    HelpSupport activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelpSupportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.helpSupportBack.setOnClickListener(v -> onBackPressed());

    }
}