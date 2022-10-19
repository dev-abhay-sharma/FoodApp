package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.model.FavouriteAddFoodModel;

import java.util.List;

public class FavouriteAddFoodAdapter extends RecyclerView.Adapter<FavouriteAddFoodAdapter.ViewHolder> {

    Context context;
    List<FavouriteAddFoodModel> favouriteAddFoodModels;

    public FavouriteAddFoodAdapter(Context context, List<FavouriteAddFoodModel> favouriteAddFoodModels) {
        this.context = context;
        this.favouriteAddFoodModels = favouriteAddFoodModels;
    }

    @NonNull
    @Override
    public FavouriteAddFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourite_add_food_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteAddFoodAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(favouriteAddFoodModels.get(position).getImgUrl())
                .into(holder.img);

        holder.name.setText(favouriteAddFoodModels.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return favouriteAddFoodModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.favoriteAddFoodImg);
            name = itemView.findViewById(R.id.favoriteAddFoodName);
        }
    }
}
