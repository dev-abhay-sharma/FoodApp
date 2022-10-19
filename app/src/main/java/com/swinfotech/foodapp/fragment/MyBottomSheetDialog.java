package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.activities.AboutUs;
import com.swinfotech.foodapp.activities.Coupon;
import com.swinfotech.foodapp.activities.HelpSupport;
import com.swinfotech.foodapp.activities.Language;
import com.swinfotech.foodapp.activities.LoyaltyPoints;
import com.swinfotech.foodapp.activities.MyAddress;
import com.swinfotech.foodapp.activities.PrivacyPolicy;
import com.swinfotech.foodapp.activities.Profile;
import com.swinfotech.foodapp.activities.ReferAndEarn;
import com.swinfotech.foodapp.activities.Rewards;
import com.swinfotech.foodapp.activities.TermsConditions;
import com.swinfotech.foodapp.activities.Wallet;
import com.swinfotech.foodapp.adapter.MenuAdapter;
import com.swinfotech.foodapp.databinding.MenuLayoutBinding;
import com.swinfotech.foodapp.model.MenuModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyBottomSheetDialog extends BottomSheetDialogFragment {
    String string;

    Context context;
    private MenuLayoutBinding binding;

    private MenuAdapter menuAdapter;
    List<MenuModel> menuModel = new ArrayList<>();

    public static MyBottomSheetDialog newInstance(String string) {
        MyBottomSheetDialog f = new MyBottomSheetDialog();
        Bundle args = new Bundle();
        args.putString("string", string);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        string = getArguments().getString("string");
        //bottom sheet round corners can be obtained but the while background appears to remove that we need to add this.
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = MenuLayoutBinding.inflate(inflater, container, false);

        binding.menuBack.setOnClickListener(v -> getDialog().onBackPressed());

        getMenuItems();

        //dialog cancel when touches outside (Optional)
        getDialog().setCanceledOnTouchOutside(true);
        return binding.getRoot();
    }

    private void getMenuItems() {
        binding.menuRecView.setLayoutManager(new GridLayoutManager(context, 4));
        binding.menuRecView.setHasFixedSize(true);
        menuAdapter = new MenuAdapter(context, menuModel);
        binding.menuRecView.setAdapter(menuAdapter);

        menuModel.clear();
        menuModel.add(new MenuModel(R.drawable.placeholder, "Profile", Profile.class));
        menuModel.add(new MenuModel(R.drawable.location_icon, "My Address", MyAddress.class));
        menuModel.add(new MenuModel(R.drawable.language_icon, "Language", Language.class));
        menuModel.add(new MenuModel(R.drawable.coupon, "Coupon", Coupon.class));
        menuModel.add(new MenuModel(R.drawable.help, "Help &\n Support", HelpSupport.class));
        menuModel.add(new MenuModel(R.drawable.policy, "Privacy Policy", PrivacyPolicy.class));
        menuModel.add(new MenuModel(R.drawable.about_us, "About Us", AboutUs.class));
        menuModel.add(new MenuModel(R.drawable.terms, "Terms & Conditions", TermsConditions.class));
        menuModel.add(new MenuModel(R.drawable.language, "Refer & Earn", ReferAndEarn.class));
        menuModel.add(new MenuModel(R.drawable.language, "Wallet", Wallet.class));
        menuModel.add(new MenuModel(R.drawable.loyal, "Loyalty Points", LoyaltyPoints.class));
        menuModel.add(new MenuModel(R.drawable.delivery_man_join, "Join as a Delivery Man"));
        menuModel.add(new MenuModel(R.drawable.restaurant_join, "Join as a Restaurant"));
        menuModel.add(new MenuModel(R.drawable.language, "Rewards", Rewards.class));
        menuModel.add(new MenuModel(R.drawable.language, "Sign In"));
    }
}