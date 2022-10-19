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
import com.swinfotech.foodapp.model.BestReviewedFoodModel;

import java.util.List;

public class CampaignsActivityAdapter extends RecyclerView.Adapter<CampaignsActivityAdapter.ViewHolder> {

    Context context;
    // we use best reviewed food model here because the data is same we can change late if we want
    List<BestReviewedFoodModel> modelList;

    public CampaignsActivityAdapter(Context context, List<BestReviewedFoodModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public CampaignsActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.campaigns_activity_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignsActivityAdapter.ViewHolder holder, int position) {
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
        ImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.campaignsActivityImg);
            name = itemView.findViewById(R.id.campaignsActivityName);
        }
    }
}
