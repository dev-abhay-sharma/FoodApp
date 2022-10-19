package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.activities.Checkout;
import com.swinfotech.foodapp.adapter.MyCartAdapter;
import com.swinfotech.foodapp.databinding.FragmentMyCartBinding;
import com.swinfotech.foodapp.model.MyCartModel;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    private FragmentMyCartBinding binding;
    private MyCartAdapter myCartAdapter;
    List<MyCartModel> myCartModels = new ArrayList<>();

    public MyCartFragment() {
        // Required empty public constructor
    }

    public static MyCartFragment newInstance(String param1, String param2) {
        MyCartFragment fragment = new MyCartFragment();
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
        binding = FragmentMyCartBinding.inflate(inflater, container, false);

        getMyCartItems();

        binding.proceedToCheckout.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Checkout.class));
        });

        return binding.getRoot();
    }

    private void getMyCartItems() {
        binding.myCartRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.myCartRecView.setHasFixedSize(true);
        myCartAdapter = new MyCartAdapter(context, myCartModels);
        binding.myCartRecView.setAdapter(myCartAdapter);

        myCartModels.clear();
        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/2097090/pexels-photo-2097090.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));
        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/2641886/pexels-photo-2641886.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));
//        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/3186654/pexels-photo-3186654.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));
//        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/958546/pexels-photo-958546.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));
//        myCartModels.add(new MyCartModel("https://images.pexels.com/photos/2679501/pexels-photo-2679501.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Chicken Sausage Delight Burger", "$ 180.00"));

    }
}