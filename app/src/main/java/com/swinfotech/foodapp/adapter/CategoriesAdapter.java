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
import com.swinfotech.foodapp.activities.CategoriesFood;
import com.swinfotech.foodapp.model.CategorieActivityModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    Context context;
    // we use categoriesActivityModel here we can change late if we want
    List<CategorieActivityModel> modelList;
    public String[] mColors = {"#3F51B5","#FF9800","#009688","#673AB7", "#00D100", "#964B00"};

    public CategoriesAdapter(Context context, List<CategorieActivityModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));

        Glide.with(holder.itemView)
              .load(modelList.get(position).getImageUrl())
              .into(holder.img);

        holder.name.setText(modelList.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CategoriesFood.class);
            intent.putExtra("name", modelList.get(position).getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.categoriesImg);
            name = itemView.findViewById(R.id.categoriesName);
            cardView = itemView.findViewById(R.id.categoriesCard);
        }
    }
}
