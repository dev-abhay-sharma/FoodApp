package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.activities.NewOnStackFoodItem;
import com.swinfotech.foodapp.model.NewOnStackFoodModel;

import java.util.List;

public class NewOnStackFoodAdapter extends RecyclerView.Adapter<NewOnStackFoodAdapter.ViewHolder> {

    Context context;
    List<NewOnStackFoodModel> modelList;

    public NewOnStackFoodAdapter(Context context, List<NewOnStackFoodModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public NewOnStackFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_on_stack_food_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewOnStackFoodAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NewOnStackFoodItem.class);
            intent.putExtra("img", modelList.get(position).getImageUrl());
            intent.putExtra("name", modelList.get(position).getName());
            context.startActivity(intent);
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
            img = itemView.findViewById(R.id.newOnStackFoodImg);
            name = itemView.findViewById(R.id.newOnStackFoodName);
        }
    }
}
