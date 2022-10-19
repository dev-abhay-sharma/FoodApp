package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.swinfotech.foodapp.databinding.ActivityProfileBinding;
import com.swinfotech.foodapp.signin.ChangePassword;

public class Profile extends AppCompatActivity {

    ActivityProfileBinding binding;
    Profile activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();


    }

    private void onClick() {
        binding.profileBack.setOnClickListener(v -> onBackPressed());
        binding.changePassword.setOnClickListener(v -> {
            startActivity(new Intent(activity, ChangePassword.class));
        });

        binding.editProfile.setOnClickListener(v -> {
            startActivity(new Intent(activity, EditProfile.class));
        });

        binding.profileImage.setOnClickListener(v -> {
            Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent,101);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101 && resultCode==RESULT_OK)
        {
            Uri uri = data.getData();
            binding.profileImage.setImageURI(uri);
        }
    }
}