package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.swinfotech.foodapp.adapter.CategorieTabAdapter;
import com.swinfotech.foodapp.databinding.ActivityCategoriesFoodBinding;
import com.google.android.material.tabs.TabLayout;

public class CategoriesFood extends AppCompatActivity {

    ActivityCategoriesFoodBinding binding;
    CategoriesFood activity;

    CategorieTabAdapter categorieTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.categoriesBack.setOnClickListener(v -> onBackPressed());

        getIntentData();

        getTabs();

    }

    private void getIntentData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        binding.cateName.setText(name);
    }

    private void getTabs() {
        categorieTabAdapter = new CategorieTabAdapter(activity, getSupportFragmentManager(), binding.tabLayoutCategories.getTabCount());
        binding.categoriesViewPager.setAdapter(categorieTabAdapter);

        binding.categoriesViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutCategories));

        binding.tabLayoutCategories.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.categoriesViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}