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
import com.swinfotech.foodapp.adapter.PopularFoodNearByActivityAdapter;
import com.swinfotech.foodapp.databinding.FragmentCategoriesFoodBinding;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    private FragmentCategoriesFoodBinding binding;

    private PopularFoodNearByActivityAdapter popularFoodNearByActivityAdapter;
    List<BestReviewedFoodModel> modelList = new ArrayList<>();

    public CategoriesFoodFragment() {
        // Required empty public constructor
    }

    public static CategoriesFoodFragment newInstance(String param1, String param2) {
        CategoriesFoodFragment fragment = new CategoriesFoodFragment();
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
        binding = FragmentCategoriesFoodBinding.inflate(inflater, container, false);

        onClick();
        getCategoriesFood();

        return binding.getRoot();
    }

    private void getCategoriesFood() {
        binding.cateFragmentRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.cateFragmentRecView.setHasFixedSize(true);
        popularFoodNearByActivityAdapter = new PopularFoodNearByActivityAdapter(context, modelList);
        binding.cateFragmentRecView.setAdapter(popularFoodNearByActivityAdapter);

        modelList.clear();
        modelList.add(new BestReviewedFoodModel("https://media.istockphoto.com/photos/medu-vada-a-popular-south-indian-food-medu-vadai-with-sambar-picture-id1345534187?b=1&k=20&m=1345534187&s=612x612&w=0&h=y47kYpHZLd_YTJSOuQXrOoCZ-4uIjdKaCJUe9jo70M0=", "Medu Vada"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/2591594/pexels-photo-2591594.jpeg?auto=compress&cs=tinysrgb&w=600", "Ramen"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/8983410/pexels-photo-8983410.jpeg?auto=compress&cs=tinysrgb&w=600", "Thai Stir Fried Noodles"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/3616956/pexels-photo-3616956.jpeg?auto=compress&cs=tinysrgb&w=600", "Burger Combo"));
        modelList.add(new BestReviewedFoodModel("https://images.pexels.com/photos/1146760/pexels-photo-1146760.jpeg?auto=compress&cs=tinysrgb&w=600", "Meat Pizza"));

    }

    private void onClick() {
        // for choose

        binding.cateFragmentAll.setOnClickListener(v -> {
            binding.cateFragmentAll.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.cateFragmentAll.setTextColor(getResources().getColor(R.color.white));

            binding.cateFragmentVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.cateFragmentVeg.setTextColor(getResources().getColor(R.color.black));

            binding.cateFragmentNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.cateFragmentNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.cateFragmentVeg.setOnClickListener(v -> {
            binding.cateFragmentVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.cateFragmentVeg.setTextColor(getResources().getColor(R.color.white));

            binding.cateFragmentAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.cateFragmentAll.setTextColor(getResources().getColor(R.color.black));

            binding.cateFragmentNonVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.cateFragmentNonVeg.setTextColor(getResources().getColor(R.color.black));
        });

        binding.cateFragmentNonVeg.setOnClickListener(v -> {
            binding.cateFragmentNonVeg.setBackgroundColor(getResources().getColor(R.color.primary_color));
            binding.cateFragmentNonVeg.setTextColor(getResources().getColor(R.color.white));

            binding.cateFragmentAll.setBackgroundColor(getResources().getColor(R.color.white));
            binding.cateFragmentAll.setTextColor(getResources().getColor(R.color.black));

            binding.cateFragmentVeg.setBackgroundColor(getResources().getColor(R.color.white));
            binding.cateFragmentVeg.setTextColor(getResources().getColor(R.color.black));
        });


    }
}