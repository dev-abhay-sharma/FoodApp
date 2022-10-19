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
import com.swinfotech.foodapp.activities.PopularRestaurantFood;
import com.swinfotech.foodapp.model.PopularRestaurantsModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.List;

public class PopularRestaurantsAdapter extends RecyclerView.Adapter<PopularRestaurantsAdapter.ViewHolder> {

    Context context;
    List<PopularRestaurantsModel> modelList;

    public PopularRestaurantsAdapter(Context context, List<PopularRestaurantsModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public PopularRestaurantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_restaurants_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularRestaurantsAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(Constants.IMAGE_BASE_URL + modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PopularRestaurantFood.class);
            intent.putExtra("img", modelList.get(position).getImageUrl());
            intent.putExtra("id", modelList.get(position).getId());
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
            img = itemView.findViewById(R.id.restaurantsImg);
            name = itemView.findViewById(R.id.restaurantsName);
        }
    }
}
