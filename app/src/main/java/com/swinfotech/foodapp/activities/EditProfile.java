package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.swinfotech.foodapp.databinding.ActivityEditProfileBinding;

public class EditProfile extends AppCompatActivity {

    ActivityEditProfileBinding binding;
    EditProfile activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        onClick();

    }

    private void onClick() {
        binding.editProfileBack.setOnClickListener(v -> onBackPressed());

        binding.editProfileImage.setOnClickListener(v -> {
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
            binding.editProfileImage.setImageURI(uri);
        }
    }
}