package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.ActivityMyAddressBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyAddress extends AppCompatActivity {

    ActivityMyAddressBinding binding;
    MyAddress activity;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.myAddressBack.setOnClickListener(v -> onBackPressed());

        binding.myAddressFloatingBtn.setOnClickListener(v -> {
            snackbar = Snackbar.make(v, "Your Address Add Successfully", Snackbar.LENGTH_LONG);
            snackbar.setBackgroundTint(getResources().getColor(R.color.green));
            snackbar.setTextColor(getResources().getColor(R.color.black));
            snackbar.show();
        });
    }
}