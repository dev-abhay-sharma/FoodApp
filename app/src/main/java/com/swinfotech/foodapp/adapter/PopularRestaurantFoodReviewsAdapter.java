package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.model.AllRestaurantsModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class PopularRestaurantFoodReviewsAdapter extends RecyclerView.Adapter<PopularRestaurantFoodReviewsAdapter.ViewHolder> {

    Context context;
    // now we just give random model class we can change later
    List<AllRestaurantsModel> modelList;

    public PopularRestaurantFoodReviewsAdapter(Context context, List<AllRestaurantsModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public PopularRestaurantFoodReviewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_restaurant_food_reviews_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularRestaurantFoodReviewsAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());
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

            img = itemView.findViewById(R.id.pRFReviewsImg);
            name = itemView.findViewById(R.id.pRFReviewsName);
        }
    }
}
