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
import com.swinfotech.foodapp.adapter.FavouriteAddRestaurantAdapter;
import com.swinfotech.foodapp.databinding.FragmentFavouriteRestaurantBinding;
import com.swinfotech.foodapp.model.FavouriteAddRestaurantModel;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRestaurantFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;

    private FragmentFavouriteRestaurantBinding binding;

    private FavouriteAddRestaurantAdapter favouriteAddRestaurantAdapter;
    List<FavouriteAddRestaurantModel> favouriteAddRestaurantModels = new ArrayList<>();

    public FavouriteRestaurantFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FavouriteRestaurantFragment newInstance(String param1, String param2) {
        FavouriteRestaurantFragment fragment = new FavouriteRestaurantFragment();
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
        binding = FragmentFavouriteRestaurantBinding.inflate(inflater, container, false);

        getFavouriteRestaurant();

        return binding.getRoot();
    }

    private void getFavouriteRestaurant() {
        binding.favoriteRestaurantRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.favoriteRestaurantRecView.setHasFixedSize(true);
        favouriteAddRestaurantAdapter = new FavouriteAddRestaurantAdapter(context, favouriteAddRestaurantModels);
        binding.favoriteRestaurantRecView.setAdapter(favouriteAddRestaurantAdapter);

        favouriteAddRestaurantModels.clear();
        favouriteAddRestaurantModels.add(new FavouriteAddRestaurantModel("https://w7.pngwing.com/pngs/524/137/png-transparent-restaurant-logo-illustration-gluten-free-diet-logo-celiac-disease-wheat-restaurant-logo-emblem-food-free-logo-design-template.png", "Hungry Puppets"));
        favouriteAddRestaurantModels.add(new FavouriteAddRestaurantModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "Cafe Monarch"));
        favouriteAddRestaurantModels.add(new FavouriteAddRestaurantModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyw81enKDCmQjBoiEvuFZGUjGqB-s4RmDqgjUVaSQOes2LUA977c2fTAdEfcBPGMgq4RU&usqp=CAU", "Hungry Puppets"));
        favouriteAddRestaurantModels.add(new FavouriteAddRestaurantModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "Cafe Monarch"));
        favouriteAddRestaurantModels.add(new FavouriteAddRestaurantModel("https://w7.pngwing.com/pngs/524/137/png-transparent-restaurant-logo-illustration-gluten-free-diet-logo-celiac-disease-wheat-restaurant-logo-emblem-food-free-logo-design-template.png", "Hungry Puppets"));

    }
}