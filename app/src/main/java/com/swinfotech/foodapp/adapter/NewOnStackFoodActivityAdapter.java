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
import com.swinfotech.foodapp.model.AllRestaurantsModel;
import com.swinfotech.foodapp.model.PopularRestaurantsModel;

import java.util.List;

public class NewOnStackFoodActivityAdapter extends RecyclerView.Adapter<NewOnStackFoodActivityAdapter.ViewHolder> {

    Context context;
    List<PopularRestaurantsModel> modelList;
    public String[] mColors = {"#ffc000","#a61011","#ec9e54","#ffffff","#673AB7","#964B00"};

    public NewOnStackFoodActivityAdapter(Context context, List<PopularRestaurantsModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public NewOnStackFoodActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_restaurants_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewOnStackFoodActivityAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));

        holder.name.setText(modelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        CardView cardView;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.allRestaurantsImg);
            cardView = itemView.findViewById(R.id.allRestaurantsCardView);
            name = itemView.findViewById(R.id.allRestaurantsName);

        }
    }
}
