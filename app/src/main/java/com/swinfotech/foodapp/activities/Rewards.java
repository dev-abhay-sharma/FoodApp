package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.swinfotech.foodapp.databinding.ActivityRewardsBinding;

public class Rewards extends AppCompatActivity {

    ActivityRewardsBinding binding;
    Rewards activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.rewardsBack.setOnClickListener(v -> onBackPressed());

        getRewards();

    }

    private void getRewards() {
        binding.scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
                scratchView.setVisibility(View.GONE);
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent >= .5f) {
                    scratchView.reveal();
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(percent));
                    System.out.println(percent);
                }
            }
        });

        binding.scratchView1.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
                scratchView.setVisibility(View.GONE);
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent >= .5f) {
                    scratchView.reveal();
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(percent));
                    System.out.println(percent);
                }
            }
        });
    }
}