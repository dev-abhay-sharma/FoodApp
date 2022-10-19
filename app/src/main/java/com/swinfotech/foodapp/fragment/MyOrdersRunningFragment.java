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
import com.swinfotech.foodapp.adapter.MyOrdersRunningAdapter;
import com.swinfotech.foodapp.databinding.FragmentMyOrdersRunningBinding;
import com.swinfotech.foodapp.model.MyOrdersRunningModel;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersRunningFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;

    FragmentMyOrdersRunningBinding binding;

    private MyOrdersRunningAdapter myOrdersRunningAdapter;
    List<MyOrdersRunningModel> myOrdersRunningModels = new ArrayList<>();

    public MyOrdersRunningFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MyOrdersRunningFragment newInstance(String param1, String param2) {
        MyOrdersRunningFragment fragment = new MyOrdersRunningFragment();
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
        binding = FragmentMyOrdersRunningBinding.inflate(inflater, container, false);

        getMyOrdersRunning();

        return binding.getRoot();
    }

    private void getMyOrdersRunning() {
        binding.myOrdersRunningRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.myOrdersRunningRecView.setHasFixedSize(true);
        myOrdersRunningAdapter = new MyOrdersRunningAdapter(context, myOrdersRunningModels);
        binding.myOrdersRunningRecView.setAdapter(myOrdersRunningAdapter);

        myOrdersRunningModels.clear();
        myOrdersRunningModels.add(new MyOrdersRunningModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8HaPgVGOj2XDdzAdwJcfsx1DsDZ3vmx5J8aR4DGeUcDqFwsxdp4uxQQsN8vixma622LQ&usqp=CAU", "#100078"));
        myOrdersRunningModels.add(new MyOrdersRunningModel("https://images.pexels.com/photos/2725744/pexels-photo-2725744.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100079"));
        myOrdersRunningModels.add(new MyOrdersRunningModel("https://images.pexels.com/photos/983297/pexels-photo-983297.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100080"));
        myOrdersRunningModels.add(new MyOrdersRunningModel("https://images.pexels.com/photos/769969/pexels-photo-769969.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100081"));
        myOrdersRunningModels.add(new MyOrdersRunningModel("https://images.pexels.com/photos/1566837/pexels-photo-1566837.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100082"));
    }
}