package com.swinfotech.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.swinfotech.foodapp.adapter.ChooseInterestsAdapter;
import com.swinfotech.foodapp.databinding.ActivityChooseInterestsBinding;
import com.swinfotech.foodapp.model.ChooseInterestsModel;

import java.util.ArrayList;
import java.util.List;

public class ChooseInterests extends AppCompatActivity {

    ActivityChooseInterestsBinding binding;
    ChooseInterests activity;

    private ChooseInterestsAdapter chooseInterestsAdapter;
    List<ChooseInterestsModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseInterestsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        getChooseInterests();

    }

    private void getChooseInterests() {
        binding.chooseInterestsRecView.setLayoutManager(new GridLayoutManager(activity, 2));
        binding.chooseInterestsRecView.setHasFixedSize(true);
        chooseInterestsAdapter = new ChooseInterestsAdapter(activity, modelList);
        binding.chooseInterestsRecView.setAdapter(chooseInterestsAdapter);

        modelList.add(new ChooseInterestsModel("https://www.freepnglogos.com/uploads/burger-png/burger-png-png-images-yellow-images-12.png", "Burger"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Biryani"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Asian"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Cake"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Coffee & Drinks"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Chinese"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Fast Food"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Kabab & More"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Indian"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Noodles"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Maxican Food"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Pasta"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Pizza"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Snacks"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Thai"));
        modelList.add(new ChooseInterestsModel("https://freepngimg.com/thumb/burger/1-2-burger-transparent.png", "Varieties"));

    }
}