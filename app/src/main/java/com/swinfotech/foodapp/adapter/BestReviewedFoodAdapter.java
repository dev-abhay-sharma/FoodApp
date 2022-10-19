package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.fragment.BestReviewedFoodBottomSheetDialog;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class BestReviewedFoodAdapter extends RecyclerView.Adapter<BestReviewedFoodAdapter.ViewHolder> {

    Context context;
    List<BestReviewedFoodModel> modelList;

    BestReviewedFoodBottomSheetDialog bottomSheetDialog = BestReviewedFoodBottomSheetDialog.newInstance("My Bottom Sheet");

    public BestReviewedFoodAdapter(Context context, List<BestReviewedFoodModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public BestReviewedFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.best_reviewed_food_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestReviewedFoodAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString("img", modelList.get(position).getImageUrl());
            args.putString("name", modelList.get(position).getName());
            bottomSheetDialog.setArguments(args);
            bottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(),bottomSheetDialog.getTag());
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.bestReviewedFoodImg);
            name = itemView.findViewById(R.id.bestReviewedFoodName);
        }
    }
}
