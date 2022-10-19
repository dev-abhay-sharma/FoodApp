package com.swinfotech.foodapp.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityForgotPasswordBinding;

public class ForgotPassword extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;
    ForgotPassword activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.forgotPassBack.setOnClickListener(v -> onBackPressed());


    }
}