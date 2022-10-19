package com.swinfotech.foodapp.signin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.swinfotech.foodapp.MainActivity;
import com.swinfotech.foodapp.activities.TermsConditions;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.ActivitySignUpBinding;
import com.swinfotech.foodapp.signin.models.SignUpModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;
    SignUp activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;
        onClick();

    }

    private void onClick() {
        binding.termsConditionsSignUp.setOnClickListener(v -> {
            startActivity(new Intent(activity, TermsConditions.class));
        });

        binding.continueAsGuestSignUp.setOnClickListener(v -> {
            startActivity(new Intent(activity, SignInAsGuest.class));
        });

        binding.login.setOnClickListener(v -> {
            startActivity(new Intent(activity, Login.class));
        });
        binding.signUp1.setOnClickListener(v -> {
            signUp();
        });

    }

    void signUp() {
        String firstName = binding.etFirstName.getText().toString();
        String lastName = binding.etLastName.getText().toString();
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        String confirmPassword = binding.etConfirmPassword.getText().toString();
        String phone = binding.etPhone.getText().toString();

        if (firstName.isEmpty()) {
            binding.etFirstName.setError("enter you first name ");
            return;
        }
        if (lastName.isEmpty()) {
            binding.etLastName.setError("enter you last name ");
            return;
        }
        if (phone.isEmpty()) {
            binding.etPhone.setError("enter you mobile number ");
            return;
        }

        if (email.isEmpty()) {
            binding.etEmail.setError("enter you email ");
            return;
        }

        if (password.isEmpty()) {
            binding.etPassword.setError("enter you Password ");
            return;
        }
        if (!confirmPassword.equals(password)) {
            binding.etConfirmPassword.setError("Re-Type your password");
            return;
        }
        HashMap<String, String> signUpBody = new HashMap<>();
        signUpBody.put("Mobile", phone);
        signUpBody.put("FName", firstName);
        signUpBody.put("LName", lastName);
        signUpBody.put("is_whatsapp", "false");
        signUpBody.put("Email", email);

        RetrofitBuilder.getService().signup(signUpBody)
                .enqueue(new Callback<SignUpModel>() {
                    @Override
                    public void onResponse(Call<SignUpModel> call, Response<SignUpModel> response) {
                        if (response.body().getStatus() == 200) {
                            Constants.setString(Constants.TOKEN, response.body().getLoginToken(), activity);
                            startActivity(
                                    new Intent(activity, MainActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            );
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUpModel> call, Throwable t) {

                    }
                });


    }

}