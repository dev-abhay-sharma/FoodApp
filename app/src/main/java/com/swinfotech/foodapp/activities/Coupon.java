package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityCouponBinding;

public class Coupon extends AppCompatActivity {

    ActivityCouponBinding binding;
    Coupon activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCouponBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.couponBack.setOnClickListener(v -> onBackPressed());

    }
}