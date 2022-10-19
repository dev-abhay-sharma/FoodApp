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
import com.swinfotech.foodapp.adapter.SearchFoodFragmentAdapter;
import com.swinfotech.foodapp.databinding.FragmentSearchFoodBinding;
import com.swinfotech.foodapp.model.FavouriteAddFoodModel;

import java.util.ArrayList;
import java.util.List;

public class SearchFoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    private FragmentSearchFoodBinding binding;
    private SearchFoodFragmentAdapter searchFoodFragmentAdapter;
    List<FavouriteAddFoodModel> modelList = new ArrayList<>();

    public SearchFoodFragment() {
        // Required empty public constructor
    }

    public static SearchFoodFragment newInstance(String param1, String param2) {
        SearchFoodFragment fragment = new SearchFoodFragment();
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
        binding = FragmentSearchFoodBinding.inflate(inflater, container, false);

        getSearchFood();

        return binding.getRoot();
    }

    private void getSearchFood() {
        binding.searchFoodRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.searchFoodRecView.setHasFixedSize(true);
        searchFoodFragmentAdapter = new SearchFoodFragmentAdapter(context, modelList);
        binding.searchFoodRecView.setAdapter(searchFoodFragmentAdapter);

        modelList.clear();
        modelList.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/1600711/pexels-photo-1600711.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Mutton Biryani"));
        modelList.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/2679501/pexels-photo-2679501.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Hyderabadi Biryani"));
        modelList.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/1566837/pexels-photo-1566837.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken dum Biryani"));
        modelList.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/769969/pexels-photo-769969.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Mutton Biryani"));
        modelList.add(new FavouriteAddFoodModel("https://images.pexels.com/photos/1058714/pexels-photo-1058714.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Biryani"));
    }
}