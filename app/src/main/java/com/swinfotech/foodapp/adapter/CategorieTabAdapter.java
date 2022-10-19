package com.swinfotech.foodapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swinfotech.foodapp.fragment.CategoriesFoodFragment;
import com.swinfotech.foodapp.fragment.CategoriesRestaurantFragment;

public class CategorieTabAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public CategorieTabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CategoriesFoodFragment categoriesFoodFragment = new CategoriesFoodFragment();
                return categoriesFoodFragment;

            case 1:
                CategoriesRestaurantFragment categoriesRestaurantFragment = new CategoriesRestaurantFragment();
                return categoriesRestaurantFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
