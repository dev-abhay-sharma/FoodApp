package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.NewOnStackFoodActivityAdapter;
import com.swinfotech.foodapp.databinding.FragmentCategoriesRestaurantBinding;
import com.swinfotech.foodapp.model.AllRestaurantsModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRestaurantFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    private FragmentCategoriesRestaurantBinding binding;

    private NewOnStackFoodActivityAdapter newOnStackFoodActivityAdapter;
    List<AllRestaurantsModel> modelList = new ArrayList<>();

    public CategoriesRestaurantFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CategoriesRestaurantFragment newInstance(String param1, String param2) {
        CategoriesRestaurantFragment fragment = new CategoriesRestaurantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesRestaurantBinding.inflate(inflater, container, false);

        onClick();
        getCategoriesRestaurants();

        return binding.getRoot();
    }

    private void getCategoriesRestaurants() {
        binding.categorieRestaurantFragmentRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.categorieRestaurantFragmentRecView.setHasFixedSize(true);
       // newOnStackFoodActivityAdapter = new NewOnStackFoodActivityAdapter(context, modelList);
      //  binding.categorieRestaurantFragmentRecView.setAdapter(newOnStackFoodActivityAdapter);

        modelList.clear();
        modelList.add(new AllRestaurantsModel("https://w7.pngwing.com/pngs/524/137/png-transparent-restaurant-logo-illustration-gluten-free-diet-logo-celiac-disease-wheat-restaurant-logo-emblem-food-free-logo-design-template.png", "Italian Fast Food"));
        modelList.add(new AllRestaurantsModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "Pizza Restaurant"));
        modelList.add(new AllRestaurantsModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyw81enKDCmQjBoiEvuFZGUjGqB-s4RmDqgjUVaSQOes2LUA977c2fTAdEfcBPGMgq4RU&usqp=CAU", "Mini kebab"));
        modelList.add(new AllRestaurantsModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "Redcliff Cafe"));
        modelList.add(new AllRestaurantsModel("https://w7.pngwing.com/pngs/524/137/png-transparent-restaurant-logo-illustration-gluten-free-diet-logo-celiac-disease-wheat-restaurant-logo-emblem-food-free-logo-design-template.png", "Tasty Lunch"));

    }

    private void onClick() {
        binding.categorieRestaurantAll.setOnClickListener(v -> {
            binding.categorieRestaurantAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.categorieRestaurantAll.setTextColor(getResources().getColor(R.color.white));

            binding.categorieRestaurantVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.categorieRestaurantVeg.setTextColor(getResources().getColor(R.color.black));

            binding.categorieRestaurantNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.categorieRestaurantNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.categorieRestaurantVeg.setOnClickListener(v -> {
            binding.categorieRestaurantVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.categorieRestaurantVeg.setTextColor(getResources().getColor(R.color.white));

            binding.categorieRestaurantAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.categorieRestaurantAll.setTextColor(getResources().getColor(R.color.black));

            binding.categorieRestaurantNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.categorieRestaurantNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.categorieRestaurantNonVeg.setOnClickListener(v -> {
            binding.categorieRestaurantNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.categorieRestaurantNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.categorieRestaurantAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.categorieRestaurantAll.setTextColor(getResources().getColor(R.color.black));

            binding.categorieRestaurantVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.categorieRestaurantVeg.setTextColor(getResources().getColor(R.color.black));
        });
    }
}