package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.adapter.NotificationAdapter;
import com.swinfotech.foodapp.databinding.ActivityNotificationBinding;

public class Notification extends AppCompatActivity {

    ActivityNotificationBinding binding;
    Notification activity;
    NotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;
        binding.notificationBack.setOnClickListener(v -> onBackPressed());
        getNotificationList();

    }

    private void getNotificationList() {
        binding.notificationRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.notificationRecView.setHasFixedSize(true);
        notificationAdapter = new NotificationAdapter(activity);
        binding.notificationRecView.setAdapter(notificationAdapter);
    }
}