package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.adapter.SearchAdapter;
import com.swinfotech.foodapp.databinding.ActivitySearchBinding;
import com.google.android.material.tabs.TabLayout;

public class Search extends AppCompatActivity {

    ActivitySearchBinding binding;
    Search activity;

    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        getTabs();
    }

    private void getTabs() {
        searchAdapter = new SearchAdapter(activity, getSupportFragmentManager(), binding.tabLayoutSearch.getTabCount());
        binding.searchViewPager.setAdapter(searchAdapter);

        binding.searchViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutSearch));

        binding.tabLayoutSearch.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.searchViewPager.setCurrentItem(tab.getPosition());
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