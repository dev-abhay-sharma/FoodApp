package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.MyOrdersAdapter;
import com.swinfotech.foodapp.databinding.FragmentMyOrdersBinding;
import com.google.android.material.tabs.TabLayout;


public class MyOrdersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    FragmentMyOrdersBinding binding;

    private MyOrdersAdapter myOrdersAdapter;

    public MyOrdersFragment() {
        // Required empty public constructor
    }


    public static MyOrdersFragment newInstance(String param1, String param2) {
        MyOrdersFragment fragment = new MyOrdersFragment();
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
        binding = FragmentMyOrdersBinding.inflate(inflater, container, false);

        getTabs();

        return binding.getRoot();
    }

    private void getTabs() {
        myOrdersAdapter = new MyOrdersAdapter(context, getChildFragmentManager(), binding.tabLayoutMyOrders.getTabCount());
        binding.myOrdersViewPager.setAdapter(myOrdersAdapter);

        binding.myOrdersViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutMyOrders));

        binding.tabLayoutMyOrders.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.myOrdersViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}