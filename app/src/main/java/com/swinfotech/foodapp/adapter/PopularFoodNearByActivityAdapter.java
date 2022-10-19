package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.fragment.MyPopularFoodNearByBottomSheetDialog;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.List;

public class PopularFoodNearByActivityAdapter extends RecyclerView.Adapter<PopularFoodNearByActivityAdapter.ViewHolder> {

    Context context;
    // we use best reviewed model because data is same we can change late if we want
    List<BestReviewedFoodModel> modelList;

    // we use otherBottomSheet example for showing we can change later
    MyPopularFoodNearByBottomSheetDialog bottomSheetDialog = MyPopularFoodNearByBottomSheetDialog.newInstance("Bottom Sheet Dialog");

    public PopularFoodNearByActivityAdapter(Context context, List<BestReviewedFoodModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public PopularFoodNearByActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_food_near_by_activity_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularFoodNearByActivityAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(Constants.IMAGE_BASE_URL + modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString("img", modelList.get(position).getImageUrl());
            args.putString("name", modelList.get(position).getName());
            bottomSheetDialog.setArguments(args);
            bottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(), bottomSheetDialog.getTag());
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.popularFoodNearByActivityImg);
            name = itemView.findViewById(R.id.popularFoodNearByActivityName);
        }
    }
}
