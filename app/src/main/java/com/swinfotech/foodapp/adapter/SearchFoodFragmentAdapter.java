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

public class SearchFoodFragmentAdapter extends RecyclerView.Adapter<SearchFoodFragmentAdapter.ViewHolder> {

    Context context;
    // now i am using favFoodAdd model we can change later
    List<FavouriteAddFoodModel> modelList;

    public SearchFoodFragmentAdapter(Context context, List<FavouriteAddFoodModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public SearchFoodFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourite_add_food_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFoodFragmentAdapter.ViewHolder holder, int position) {
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

            img = itemView.findViewById(R.id.favoriteAddFoodImg);
            name = itemView.findViewById(R.id.favoriteAddFoodName);
        }
    }
}
