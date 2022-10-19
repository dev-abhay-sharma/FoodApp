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
import com.swinfotech.foodapp.model.ChooseInterestsModel;

import java.util.List;

public class ChooseInterestsAdapter extends RecyclerView.Adapter<ChooseInterestsAdapter.ViewHolder> {

    Context context;
    List<ChooseInterestsModel> modelList;
    public String[] mColors = {"#ff7701","#009a5e","#b3d376","#d1af58", "#582b01", "#f99023", "#f2f100", "#fb6703", "#d42b00"};

    public ChooseInterestsAdapter(Context context, List<ChooseInterestsModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ChooseInterestsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.choose_interests_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseInterestsAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(modelList.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(modelList.get(position).getName());

        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.chooseInterestsImg);
            name = itemView.findViewById(R.id.chooseInterestsName);
            cardView = itemView.findViewById(R.id.chooseInterestsCard);
        }
    }
}