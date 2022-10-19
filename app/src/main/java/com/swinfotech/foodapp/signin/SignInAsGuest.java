package com.swinfotech.foodapp.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.ActivitySignInAsGuestBinding;

public class SignInAsGuest extends AppCompatActivity {

    ActivitySignInAsGuestBinding binding;
    SignInAsGuest activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInAsGuestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.asGuestBack.setOnClickListener(v -> onBackPressed());


    }
}