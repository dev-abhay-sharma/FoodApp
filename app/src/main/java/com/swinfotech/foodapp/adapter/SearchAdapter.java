package com.swinfotech.foodapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swinfotech.foodapp.fragment.SearchFoodFragment;
import com.swinfotech.foodapp.fragment.SearchRestaurantFragment;

public class SearchAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public SearchAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SearchFoodFragment searchFoodFragment = new SearchFoodFragment();
                return searchFoodFragment;

            case 1:
                SearchRestaurantFragment searchRestaurantFragment = new SearchRestaurantFragment();
                return searchRestaurantFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
