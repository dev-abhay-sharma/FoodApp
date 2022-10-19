package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityWalletBinding;

public class Wallet extends AppCompatActivity {

    ActivityWalletBinding binding;
    Wallet activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWalletBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.walletBack.setOnClickListener(v -> onBackPressed());

    }
}