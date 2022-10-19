package com.swinfotech.foodapp.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.swinfotech.foodapp.adapter.ViewPagerAdapter;
import com.swinfotech.foodapp.databinding.ActivityOnBoardScreenBinding;

public class OnBoardScreen extends AppCompatActivity {

    ActivityOnBoardScreenBinding binding;
    OnBoardScreen activity;

    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

        getSlides();

    }

    private void getSlides() {
        viewPagerAdapter = new ViewPagerAdapter(activity);
        binding.slideViewPager.setAdapter(viewPagerAdapter);
        binding.slideViewPager.addOnPageChangeListener(viewListener);
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

//            setUpindicator(position);
            binding.indicator.setSelection(position);

            if (position == 2){

//                backbtn.setVisibility(View.VISIBLE);
                binding.getStarted.setVisibility(View.VISIBLE);
                binding.skipLayout.setVisibility(View.GONE);

            }else {

//                backbtn.setVisibility(View.INVISIBLE);
                binding.skipLayout.setVisibility(View.VISIBLE);
                binding.getStarted.setVisibility(View.GONE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i){

        return binding.slideViewPager.getCurrentItem() + i;
    }

    private void onClick() {
        binding.skip.setOnClickListener(v -> {
            startActivity(new Intent(activity, Login.class));
            finish();
        });

        binding.getStarted.setOnClickListener(v -> {
            startActivity(new Intent(activity, Login.class));
            finish();
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) < 2)
                    binding.slideViewPager.setCurrentItem(getitem(1),true);
                else {
                    startActivity(new Intent(activity, Login.class));
                    finish();
                }

            }
        });
    }
}