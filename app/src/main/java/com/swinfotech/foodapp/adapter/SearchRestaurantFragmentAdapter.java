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
import com.swinfotech.foodapp.model.FavouriteAddRestaurantModel;

import java.util.List;

public class SearchRestaurantFragmentAdapter extends RecyclerView.Adapter<SearchRestaurantFragmentAdapter.ViewHolder> {

    Context context;
    // we use favAddRestaurantModel we can change later if we want'
    List<FavouriteAddRestaurantModel> modelList;

    public SearchRestaurantFragmentAdapter(Context context, List<FavouriteAddRestaurantModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public SearchRestaurantFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourite_add_restaurants_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRestaurantFragmentAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(modelList.get(position).getImgUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());
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

            img = itemView.findViewById(R.id.favoriteRestaurantImg);
            name = itemView.findViewById(R.id.favoriteRestaurantName);
        }
    }
}
