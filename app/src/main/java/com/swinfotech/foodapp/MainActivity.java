package com.swinfotech.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import com.swinfotech.foodapp.adapter.MenuAdapter;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.ActivityMainBinding;
import com.swinfotech.foodapp.fragment.FavouriteFragment;
import com.swinfotech.foodapp.fragment.HomeFragment;
import com.swinfotech.foodapp.fragment.MyBottomSheetDialog;
import com.swinfotech.foodapp.fragment.MyCartFragment;
import com.swinfotech.foodapp.fragment.MyOrdersFragment;
import com.swinfotech.foodapp.fragment.models.home.DashboardInfoModel;
import com.swinfotech.foodapp.model.MenuModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.navigation.NavigationBarView;
import com.swinfotech.foodapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivity activity;

    HomeFragment homeFragment = new HomeFragment();
    FavouriteFragment favouriteFragment = new FavouriteFragment();
    MyCartFragment myCartFragment = new MyCartFragment();
    MyOrdersFragment myOrdersFragment = new MyOrdersFragment();

    private int cartItem = 0;
    private MenuAdapter menuAdapter;
    List<MenuModel> menuModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        MyBottomSheetDialog bottomSheetDialogFragment = MyBottomSheetDialog.newInstance("Bottom Sheet Dialog");

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, homeFragment).commit();

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, homeFragment).commit();
                        return true;

                    case R.id.favorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, favouriteFragment).commit();
                        return true;

//                    case R.id.cart:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, myCartFragment).commit();
//                        return true;

                    case R.id.shoppingBag:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, myOrdersFragment).commit();
                        return true;

                    case R.id.menu:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, myOrdersFragment).commit();
//                        getMenuBottom();
                        bottomSheetDialogFragment.show(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());
                        return true;
                }

                return false;
            }
        });

        binding.fab.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLyt, myCartFragment).commit();

//            binding.fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primary_color)));
        });

        setCartData();
        getDashboardInfo();

    }

    private void setCartData() {

        binding.fab.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("UnsafeOptInUsageError")
            @Override
            public void onGlobalLayout() {
                BadgeDrawable badgeDrawable = BadgeDrawable.create(MainActivity.this);
                badgeDrawable.setNumber(cartItem);
                badgeDrawable.setBackgroundColor(getResources().getColor(R.color.primary_color));
                //Important to change the position of the Badge
                badgeDrawable.setHorizontalOffset(40);
                badgeDrawable.setVerticalOffset(40);

                BadgeUtils.attachBadgeDrawable(badgeDrawable, binding.fab, null);

                binding.fab.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }


    private void getDashboardInfo(){
        RetrofitBuilder.getService().getDashboardInfo(Constants.getString(Constants.TOKEN,activity))
                .enqueue(new Callback<DashboardInfoModel>() {
                    @Override
                    public void onResponse(Call<DashboardInfoModel> call, Response<DashboardInfoModel> response) {
                        if (response.body()!=null){
                            cartItem = Integer.parseInt(response.body().getGetCartItems().getCartItems());
                            setCartData();
                        }
                    }

                    @Override
                    public void onFailure(Call<DashboardInfoModel> call, Throwable t) {

                    }
                });


    }



//    private void getMenuBottom() {
//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
//        bottomSheetDialog.setContentView(R.layout.menu_layout);
//
//
//
//        RecyclerView menuRecView = bottomSheetDialog.findViewById(R.id.menuRecView);
//        ImageView back = bottomSheetDialog.findViewById(R.id.menuBack);
//
//        back.setOnClickListener(v -> bottomSheetDialog.dismiss());
//
//        menuRecView.setLayoutManager(new GridLayoutManager(activity, 4));
//        menuRecView.setHasFixedSize(true);
//        menuAdapter = new MenuAdapter(activity, menuModel);
//        menuRecView.setAdapter(menuAdapter);
//
//        menuModel.clear();
//        menuModel.add(new MenuModel(R.drawable.placeholder, "Profile"));
//        menuModel.add(new MenuModel(R.drawable.location, "My Address"));
//        menuModel.add(new MenuModel(R.drawable.language, "Language"));
//        menuModel.add(new MenuModel(R.drawable.coupon, "Coupon"));
//        menuModel.add(new MenuModel(R.drawable.support, "Help &\n Support"));
//        menuModel.add(new MenuModel(R.drawable.policy, "Privacy Policy"));
//        menuModel.add(new MenuModel(R.drawable.about_us, "About Us"));
//        menuModel.add(new MenuModel(R.drawable.terms, "Terms & Conditions"));
//        menuModel.add(new MenuModel(R.drawable.language, "Refer & Earn"));
//        menuModel.add(new MenuModel(R.drawable.language, "Wallet"));
//        menuModel.add(new MenuModel(R.drawable.loyal, "Loyalty Points"));
//        menuModel.add(new MenuModel(R.drawable.delivery_man_join, "Join as a Delivery Man"));
//        menuModel.add(new MenuModel(R.drawable.restaurant_join, "Join as a Restaurant"));
//        menuModel.add(new MenuModel(R.drawable.language, "Rewards"));
//        menuModel.add(new MenuModel(R.drawable.language, "Sign In"));
//
//        bottomSheetDialog.show();
//    }
}