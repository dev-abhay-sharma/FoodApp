package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityLoyaltyPointsBinding;
import com.swinfotech.foodapp.fragment.MyConvertCurrencyBottomSheetDialog;

public class LoyaltyPoints extends AppCompatActivity {

    ActivityLoyaltyPointsBinding binding;
    LoyaltyPoints activity;

    MyConvertCurrencyBottomSheetDialog bottomSheetDialog = MyConvertCurrencyBottomSheetDialog.newInstance("My Bottom Sheet");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoyaltyPointsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();


    }

    private void onClick() {
        binding.loyaltyPointsBack.setOnClickListener(v -> onBackPressed());

        binding.convertCurrency.setOnClickListener(v -> {
            bottomSheetDialog.show(getSupportFragmentManager(),bottomSheetDialog.getTag());
        });
    }
}