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
import com.swinfotech.foodapp.adapter.FavouriteAddFoodAdapter;
import com.swinfotech.foodapp.databinding.FragmentFavouriteFoodBinding;
import com.swinfotech.foodapp.model.FavouriteAddFoodModel;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;

    private FragmentFavouriteFoodBinding binding;

    private FavouriteAddFoodAdapter favouriteAddFoodAdapter;
    List<FavouriteAddFoodModel> favouriteAddFoodModels = new ArrayList<>();

    public FavouriteFoodFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FavouriteFoodFragment newInstance(String param1, String param2) {
        FavouriteFoodFragment fragment = new FavouriteFoodFragment();
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
        binding = FragmentFavouriteFoodBinding.inflate(inflater, container, false);

        getFavouriteFood();

        return binding.getRoot();
    }

    private void getFavouriteFood() {
        binding.favoriteFoodRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.favoriteFoodRecView.setHasFixedSize(true);
        favouriteAddFoodAdapter = new FavouriteAddFoodAdapter(context, favouriteAddFoodModels);
        binding.favoriteFoodRecView.setAdapter(favouriteAddFoodAdapter);


        favouriteAddFoodModels.clear();
        favouriteAddFoodModels.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/1600711/pexels-photo-1600711.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Mutton Biryani"));
        favouriteAddFoodModels.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/2679501/pexels-photo-2679501.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Hyderabadi Biryani"));
        favouriteAddFoodModels.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/1566837/pexels-photo-1566837.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken dum Biryani"));
        favouriteAddFoodModels.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/769969/pexels-photo-769969.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Mutton Biryani"));
        favouriteAddFoodModels.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/1058714/pexels-photo-1058714.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Biryani"));
    }
}