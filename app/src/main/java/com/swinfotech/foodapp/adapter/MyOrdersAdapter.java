package com.swinfotech.foodapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swinfotech.foodapp.fragment.MyOrdersHistoryFragment;
import com.swinfotech.foodapp.fragment.MyOrdersRunningFragment;

public class MyOrdersAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyOrdersAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MyOrdersRunningFragment myOrdersRunningFragment = new MyOrdersRunningFragment();
                return myOrdersRunningFragment;

            case 1:
                MyOrdersHistoryFragment myOrdersHistoryFragment = new MyOrdersHistoryFragment();
                return myOrdersHistoryFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
