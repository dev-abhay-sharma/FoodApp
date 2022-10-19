package com.swinfotech.foodapp.adapter;

import android.content.Context;
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
import com.swinfotech.foodapp.model.FavouriteAddRestaurantModel;

import java.util.List;

public class FavouriteAddRestaurantAdapter extends RecyclerView.Adapter<FavouriteAddRestaurantAdapter.ViewHolder> {

    Context context;
    List<FavouriteAddRestaurantModel> favouriteAddRestaurantModels;
    public String[] mColors = {"#ffc000","#a61011","#ec9e54","#ffffff","#673AB7","#964B00"};

    public FavouriteAddRestaurantAdapter(Context context, List<FavouriteAddRestaurantModel> favouriteAddRestaurantModels) {
        this.context = context;
        this.favouriteAddRestaurantModels = favouriteAddRestaurantModels;
    }

    @NonNull
    @Override
    public FavouriteAddRestaurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourite_add_restaurants_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteAddRestaurantAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(favouriteAddRestaurantModels.get(position).getImgUrl())
                .into(holder.img);

        holder.name.setText(favouriteAddRestaurantModels.get(position).getName());
        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));
    }

    @Override
    public int getItemCount() {
        return favouriteAddRestaurantModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.favoriteRestaurantImg);
            name = itemView.findViewById(R.id.favoriteRestaurantName);
            cardView = itemView.findViewById(R.id.favoriteRestaurantsCardView);
        }
    }
}
