package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.adapter.MyCartAdapter;
import com.swinfotech.foodapp.databinding.ActivityOrderDetailsBinding;
import com.swinfotech.foodapp.model.MyCartModel;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails extends AppCompatActivity {

    ActivityOrderDetailsBinding binding;
    OrderDetails activity;
    
    // we use this for example we can change later
    private MyCartAdapter myCartAdapter;
    List<MyCartModel> myCartModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.orderDetailsBack.setOnClickListener(v -> onBackPressed());

        getOrderDetails();

    }

    private void getOrderDetails() {
        binding.orderDetailsRecView.setLayoutManager(new LinearLayoutManager(activity));
        binding.orderDetailsRecView.setHasFixedSize(true);
        myCartAdapter = new MyCartAdapter(activity, myCartModels);
        binding.orderDetailsRecView.setAdapter(myCartAdapter);

        myCartModels.clear();
        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/2097090/pexels-photo-2097090.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));
        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/2641886/pexels-photo-2641886.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));

    }
}