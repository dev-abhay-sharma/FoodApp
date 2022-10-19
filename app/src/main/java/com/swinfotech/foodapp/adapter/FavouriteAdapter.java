package com.swinfotech.foodapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swinfotech.foodapp.fragment.FavouriteFoodFragment;
import com.swinfotech.foodapp.fragment.FavouriteRestaurantFragment;

public class FavouriteAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public FavouriteAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FavouriteFoodFragment favouriteFoodFragment = new FavouriteFoodFragment();
                return favouriteFoodFragment;

            case 1:
                FavouriteRestaurantFragment favouriteRestaurantFragment = new FavouriteRestaurantFragment();
                return favouriteRestaurantFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
