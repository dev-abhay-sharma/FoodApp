package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.MyCampaignsBottomSheetBinding;
import com.swinfotech.foodapp.databinding.MyPopularFoodsNearByBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.swinfotech.foodapp.fragment.models.home.ProductDetails;
import com.swinfotech.foodapp.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPopularFoodNearByBottomSheetDialog extends BottomSheetDialogFragment {
    String string;

    Context context;
    private MyPopularFoodsNearByBottomSheetBinding binding;
    int count = 1;
    String strCounter;

    public static MyPopularFoodNearByBottomSheetDialog newInstance(String string) {
        MyPopularFoodNearByBottomSheetDialog f = new MyPopularFoodNearByBottomSheetDialog();
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

        binding = MyPopularFoodsNearByBottomSheetBinding.inflate(inflater, container, false);

        binding.popularFoodNearByBottomSheetBack.setOnClickListener(v -> getDialog().onBackPressed());

        getIntentData();
        addMinusMoney();

        //dialog cancel when touches outside (Optional)
        getDialog().setCanceledOnTouchOutside(true);
        return binding.getRoot();
    }

    private void addMinusMoney() {
        binding.popularFoodNearByBSAddMoney.setOnClickListener(v -> {
            if (v == binding.popularFoodNearByBSAddMoney) {
                count++;
                strCounter = Integer.toString(count);
                binding.popularFoodNearByBSChangeMoney.setText(strCounter);

            }
        });

        binding.popularFoodNearByBSMinusMoney.setOnClickListener(v -> {
            if (v == binding.popularFoodNearByBSMinusMoney) {
                if (count == 1) {
                    System.out.println("that's Enough ");
                } else {
                    count--;
                    strCounter = Integer.toString(count);
                    binding.popularFoodNearByBSChangeMoney.setText(strCounter);
                }
            }
        });
    }

    private void getIntentData() {
        Bundle mArgs = getArguments();
        String img = mArgs.getString("img");
        String name = mArgs.getString("name");
        String id = mArgs.getString("id");


        getProductDetails(id);

        Glide.with(context).load(img).into(binding.popularFoodNearByBottomSheetImg);
        binding.popularFoodNearByBottomSheetName.setText(name);

        if (binding.popularFoodNearByBottomSheetName.getText().toString().equalsIgnoreCase("Pizza Meat")) {
            binding.sizePFNB.setVisibility(View.VISIBLE);
        } else if (binding.popularFoodNearByBottomSheetName.getText().toString().equalsIgnoreCase("Kadai Paneer")){
            binding.addOnsPFNB.setVisibility(View.VISIBLE);
            binding.notAvailablePFNB.setVisibility(View.VISIBLE);
        }
    }

    private void getProductDetails(String id) {

        RetrofitBuilder.getService().getProductDetails("1",id)
                .enqueue(new Callback<ProductDetails>() {
                    @Override
                    public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                       if (response.body().getGetProdDetails()!=null){
                            binding.popularFoodNearByBottomSheetName.setText(response.body().getGetProdDetails().getProdNameEn());
                            binding.productDetailsShopName.setText(response.body().getGetProdDetails().getShopNameEn());
                            binding.productDetailsProductPrice.setText(response.body().getGetProdDetails().getPrice());
                            Glide.with(getActivity()).load(Constants.IMAGE_BASE_URL+response.body().getGetProdDetails().getProdImg1())
                                    .into(binding.popularFoodNearByBottomSheetImg);
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductDetails> call, Throwable t) {

                    }
                });

    }


}