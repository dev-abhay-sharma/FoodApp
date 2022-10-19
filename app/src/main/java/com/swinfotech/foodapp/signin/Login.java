package com.swinfotech.foodapp.signin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.swinfotech.foodapp.MainActivity;
import com.swinfotech.foodapp.activities.TermsConditions;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.ActivityLoginBinding;
import com.swinfotech.foodapp.signin.models.LoginModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    Login activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        checkUser();

        onClick();

    }

    private void checkUser() {

        String token = Constants.getString(Constants.TOKEN,activity);
        if (!token.isEmpty())
        {
            startActivity(
                    new Intent(activity, MainActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
            );
        }
    }

    private void onClick() {
        binding.termsConditions.setOnClickListener(v -> {
            startActivity(new Intent(activity, TermsConditions.class));
        });

        binding.continueAsGuestLogin.setOnClickListener(v -> {
            startActivity(new Intent(activity, SignInAsGuest.class));
        });

        binding.signUp.setOnClickListener(v -> {
            startActivity(new Intent(activity, SignUp.class));
        });

        binding.forgotPassword.setOnClickListener(v -> {
            startActivity(new Intent(activity, ForgotPassword.class));
        });

        binding.signIn.setOnClickListener(v -> {
            login();


        });
    }

    private void login() {
        String mobile = binding.etMobile.getText().toString();
        String password = binding.etPassword.getText().toString();

        if (mobile.isEmpty()) {
            binding.etMobile.setError("enter Mobile");
            return;
        }
        if (password.isEmpty()) {
            binding.etPassword.setError("enter password");
            return;
        }
        HashMap<String, String> loginBody = new HashMap<>();
        loginBody.put("Mobile", mobile);
        loginBody.put("Password", password);
        RetrofitBuilder.getService().login(loginBody).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                try {
                    if (response.body().getStatus() == 200) {
                        Constants.setString(Constants.TOKEN, response.body().getLoginToken(), activity);
                        startActivity(
                                new Intent(activity, MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        );
                    }

                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.e("TAG", "onFailure: ");
            }
        });
    }
}