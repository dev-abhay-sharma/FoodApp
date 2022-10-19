package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.BestReviewedFoodBottomSheetBinding;
import com.swinfotech.foodapp.databinding.MyPopularFoodsNearByBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BestReviewedFoodBottomSheetDialog extends BottomSheetDialogFragment {
    String string;

    Context context;
    private BestReviewedFoodBottomSheetBinding binding;
    int count = 1;
    String strCounter;

    public static BestReviewedFoodBottomSheetDialog newInstance(String string) {
        BestReviewedFoodBottomSheetDialog f = new BestReviewedFoodBottomSheetDialog();
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

        binding = BestReviewedFoodBottomSheetBinding.inflate(inflater, container, false);

        binding.bestReviewedFoodBottomSheetBack.setOnClickListener(v -> getDialog().onBackPressed());

        getIntentData();
        addMinusMoney();

        //dialog cancel when touches outside (Optional)
        getDialog().setCanceledOnTouchOutside(true);
        return binding.getRoot();
    }

    private void addMinusMoney() {
        binding.bestReviewedFoodAddMoney.setOnClickListener(v -> {
            if (v == binding.bestReviewedFoodAddMoney) {
                count++;
                strCounter = Integer.toString(count);
                binding.bestReviewedFoodChangeMoney.setText(strCounter);

            }
        });

        binding.bestReviewedFoodMinusMoney.setOnClickListener(v -> {
            if (v == binding.bestReviewedFoodMinusMoney) {
                if (count == 1) {
                    System.out.println("that's Enough ");
                } else {
                    count--;
                    strCounter = Integer.toString(count);
                    binding.bestReviewedFoodChangeMoney.setText(strCounter);
                }
            }
        });
    }

    private void getIntentData() {
        Bundle mArgs = getArguments();
        String img = mArgs.getString("img");
        String name = mArgs.getString("name");

        Glide.with(context).load(img).into(binding.bestReviewedFoodBottomSheetImg);
        binding.bestReviewedFoodBottomSheetName.setText(name);

        if (binding.bestReviewedFoodBottomSheetName.getText().toString().equalsIgnoreCase("Burger Combo")) {
            binding.sizeBestReviewedFood.setVisibility(View.VISIBLE);
        } else if (binding.bestReviewedFoodBottomSheetName.getText().toString().equalsIgnoreCase("Meat Pizza")){
            binding.sizeBestReviewedFood.setVisibility(View.VISIBLE);
            binding.addOnsBestReviewedFood.setVisibility(View.VISIBLE);
        } else if (binding.bestReviewedFoodBottomSheetName.getText().toString().equalsIgnoreCase("Veg Momos")){
            binding.notAvailableBestReviewedFood.setVisibility(View.VISIBLE);
            binding.bestReviewedFoodBottomSheetButtons.setVisibility(View.GONE);
        } else if (binding.bestReviewedFoodBottomSheetName.getText().toString().equalsIgnoreCase("Grilled Kebab")){
            binding.addOnsBestReviewedFood.setVisibility(View.VISIBLE);
        }
    }


}