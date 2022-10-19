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
import com.swinfotech.foodapp.adapter.MyOrdersHistoryAdapter;
import com.swinfotech.foodapp.databinding.FragmentMyOrdersHistoryBinding;
import com.swinfotech.foodapp.model.MyOrdersHistoryModel;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersHistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    private FragmentMyOrdersHistoryBinding binding;
    private MyOrdersHistoryAdapter myOrdersHistoryAdapter;
    List<MyOrdersHistoryModel> myOrdersHistoryModels = new ArrayList<>();

    public MyOrdersHistoryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MyOrdersHistoryFragment newInstance(String param1, String param2) {
        MyOrdersHistoryFragment fragment = new MyOrdersHistoryFragment();
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
        binding = FragmentMyOrdersHistoryBinding.inflate(inflater, container, false);

        getMyOrdersHistory();

        return binding.getRoot();
    }

    private void getMyOrdersHistory() {
        binding.myOrdersHistoryRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.myOrdersHistoryRecView.setHasFixedSize(true);
        myOrdersHistoryAdapter = new MyOrdersHistoryAdapter(context, myOrdersHistoryModels);
        binding.myOrdersHistoryRecView.setAdapter(myOrdersHistoryAdapter);

        myOrdersHistoryModels.clear();
        myOrdersHistoryModels.add(new MyOrdersHistoryModel("https://images.pexels.com/photos/1566837/pexels-photo-1566837.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100078", "Delivered"));
        myOrdersHistoryModels.add(new MyOrdersHistoryModel("https://images.pexels.com/photos/769969/pexels-photo-769969.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100079", "Cancel"));
        myOrdersHistoryModels.add(new MyOrdersHistoryModel("https://images.pexels.com/photos/4393021/pexels-photo-4393021.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100080", "Delivered"));
        myOrdersHistoryModels.add(new MyOrdersHistoryModel("https://images.pexels.com/photos/12362923/pexels-photo-12362923.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100081", "Cancel"));
        myOrdersHistoryModels.add(new MyOrdersHistoryModel("https://images.pexels.com/photos/2097090/pexels-photo-2097090.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "#100082", "Delivered"));
    }
}