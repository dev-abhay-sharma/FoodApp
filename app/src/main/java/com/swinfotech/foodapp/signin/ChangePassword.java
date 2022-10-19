package com.swinfotech.foodapp.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.databinding.ActivityChangePasswordBinding;

public class ChangePassword extends AppCompatActivity {

    ActivityChangePasswordBinding binding;
    ChangePassword activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.changePassBack.setOnClickListener(v -> onBackPressed());


    }
}