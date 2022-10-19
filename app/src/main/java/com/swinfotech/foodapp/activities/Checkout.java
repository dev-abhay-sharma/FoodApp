package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.ActivityCheckoutBinding;

public class Checkout extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    Checkout activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

    }

    private void onClick() {
        binding.checkoutBack.setOnClickListener(v -> onBackPressed());

        binding.addNewAddress.setOnClickListener(v -> {
            startActivity(new Intent(activity, AddNewAddress.class));
        });

        binding.confirmBtn.setOnClickListener(v -> {
            startActivity(new Intent(activity, ConfirmOrder.class));
        });

        binding.homeDeliveryRadio.setOnClickListener(v -> {

            binding.homeDeliveryRadio.setChecked(true);
            binding.homeDeliveryRadio.setSelected(true);

            binding.takeAwayRadio.setChecked(false);
            binding.takeAwayRadio.setSelected(false);

            binding.homeDeliveryAddress.setVisibility(View.VISIBLE);
            binding.deliveryManTips.setVisibility(View.VISIBLE);

        });

        binding.takeAwayRadio.setOnClickListener(v -> {
            binding.takeAwayRadio.setChecked(true);
            binding.takeAwayRadio.setSelected(true);

            binding.homeDeliveryRadio.setChecked(false);
            binding.homeDeliveryRadio.setSelected(false);

            binding.homeDeliveryAddress.setVisibility(View.GONE);
            binding.deliveryManTips.setVisibility(View.GONE);


        });


        binding.cashOnDeliveryCard.setOnClickListener(v -> {
            binding.cashDeliveryImg.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color));
            binding.cashOnDeliveryCheck.setVisibility(View.VISIBLE);

            binding.digitalPayImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.digitalPayCheck.setVisibility(View.GONE);

            binding.walletPayImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.walletPayCheck.setVisibility(View.GONE);
        });

        binding.digitalPayCard.setOnClickListener(v -> {
            binding.digitalPayImg.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color));
            binding.digitalPayCheck.setVisibility(View.VISIBLE);

            binding.cashDeliveryImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.cashOnDeliveryCheck.setVisibility(View.GONE);

            binding.walletPayImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.walletPayCheck.setVisibility(View.GONE);
        });

        binding.walletCard.setOnClickListener(v -> {
            binding.walletPayImg.setColorFilter(ContextCompat.getColor(activity, R.color.primary_color));
            binding.walletPayCheck.setVisibility(View.VISIBLE);

            binding.cashDeliveryImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.cashOnDeliveryCheck.setVisibility(View.GONE);

            binding.digitalPayImg.setColorFilter(ContextCompat.getColor(activity, R.color.grey));
            binding.digitalPayCheck.setVisibility(View.GONE);
        });

    }
}