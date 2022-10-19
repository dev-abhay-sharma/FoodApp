package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.ActivityLanguageBinding;

public class Language extends AppCompatActivity {

    ActivityLanguageBinding binding;
    Language activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();
    }

    private void onClick() {
        // for back
        binding.languageBack.setOnClickListener(v -> onBackPressed());

        // for English check

        binding.englishCard.setOnClickListener(v -> {
            binding.englishCheck.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.hindiCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.banglaCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.assameseCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
        });

        // for Hindi check

        binding.hindiCard.setOnClickListener(v -> {
            binding.hindiCheck.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.englishCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.banglaCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.assameseCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
        });

        // for Bangla check

        binding.banglaCard.setOnClickListener(v -> {
            binding.banglaCheck.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.englishCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.hindiCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.assameseCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
        });

        // for Assamese check

        binding.assameseCard.setOnClickListener(v -> {
            binding.assameseCheck.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.englishCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.hindiCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.banglaCheck.setColorFilter(ContextCompat.getColor(activity, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
        });


    }
}