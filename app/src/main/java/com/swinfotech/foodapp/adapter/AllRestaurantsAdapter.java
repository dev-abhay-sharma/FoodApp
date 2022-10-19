package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.activities.PopularRestaurantFood;
import com.swinfotech.foodapp.model.AllRestaurantsModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.List;

public class AllRestaurantsAdapter extends RecyclerView.Adapter<AllRestaurantsAdapter.ViewHolder> {

    Context context;
    List<AllRestaurantsModel> modelList;
    public String[] mColors = {"#ffc000", "#a61011", "#ec9e54", "#ffffff", "#673AB7", "#964B00"};

    public AllRestaurantsAdapter(Context context, List<AllRestaurantsModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public AllRestaurantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_restaurants_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllRestaurantsAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(Constants.IMAGE_BASE_URL + modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.allRestaurantsName.setText(modelList.get(position).getName());

        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PopularRestaurantFood.class);
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
        CardView cardView;
        TextView allRestaurantsName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.allRestaurantsImg);
            cardView = itemView.findViewById(R.id.allRestaurantsCardView);
            allRestaurantsName = itemView.findViewById(R.id.allRestaurantsName);

        }
    }
}