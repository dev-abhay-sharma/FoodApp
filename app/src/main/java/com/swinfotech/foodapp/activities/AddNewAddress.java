package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.ActivityAddNewAddressBinding;

public class  AddNewAddress extends AppCompatActivity {

    ActivityAddNewAddressBinding binding;
    AddNewAddress activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNewAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();
    }

    private void onClick() {
        binding.addNewAddressBack.setOnClickListener(v -> onBackPressed());

        binding.homeLabel.setOnClickListener(v -> {
            binding.homeLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color));
            binding.officeLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.othersLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
        });

        binding.officeLabel.setOnClickListener(v -> {
            binding.officeLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color));
            binding.homeLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.othersLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
        });

        binding.othersLabel.setOnClickListener(v -> {
            binding.othersLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color));
            binding.officeLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.homeLabelImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
        });

    }
}