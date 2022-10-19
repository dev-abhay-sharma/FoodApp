package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.fragment.MyPopularFoodNearByBottomSheetDialog;
import com.swinfotech.foodapp.model.PopularFoodsNearByModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.List;

public class PopularFoodsNearByAdapter extends RecyclerView.Adapter<PopularFoodsNearByAdapter.ViewHolder> {

    Context context;
    List<PopularFoodsNearByModel> popularFoodsNearByModels;

    MyPopularFoodNearByBottomSheetDialog bottomSheetDialog = MyPopularFoodNearByBottomSheetDialog.newInstance("Bottom Sheet Dialog");

    public PopularFoodsNearByAdapter(Context context, List<PopularFoodsNearByModel> popularFoodsNearByModels) {
        this.context = context;
        this.popularFoodsNearByModels = popularFoodsNearByModels;
    }

    @NonNull
    @Override
    public PopularFoodsNearByAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_foods_near_by_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularFoodsNearByAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(Constants.IMAGE_BASE_URL + popularFoodsNearByModels.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(popularFoodsNearByModels.get(position).getName());
        holder.productPrice.setText(popularFoodsNearByModels.get(position).getMrp());
        holder.productRest.setText(popularFoodsNearByModels.get(position).getProductRest());

        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString("img", popularFoodsNearByModels.get(position).getImageUrl());
            args.putString("name", popularFoodsNearByModels.get(position).getName());
            args.putString("id", popularFoodsNearByModels.get(position).getId());
            bottomSheetDialog.setArguments(args);
            bottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(), bottomSheetDialog.getTag());
        });
    }

    @Override
    public int getItemCount() {
        return popularFoodsNearByModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView img;
        TextView name,productPrice,productRest;
        LinearLayout size;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.popularFoodNearByImg);
            name = itemView.findViewById(R.id.popularFoodNearbyName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productRest = itemView.findViewById(R.id.productRest);
        }
    }
}