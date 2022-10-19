package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.fragment.MyCampaignsBottomSheetDialog;
import com.swinfotech.foodapp.model.CampaignsModel;

import java.util.List;

public class CampaignsAdapter extends RecyclerView.Adapter<CampaignsAdapter.ViewHolder> {

    Context context;
    List<CampaignsModel> campaignsModels;

    MyCampaignsBottomSheetDialog myCampaignsBottomSheetDialog = MyCampaignsBottomSheetDialog.newInstance("Bottom Sheet Dialog");

    public CampaignsAdapter(Context context, List<CampaignsModel> campaignsModels) {
        this.context = context;
        this.campaignsModels = campaignsModels;
    }

    @NonNull
    @Override
    public CampaignsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.campaigns_list, parent, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignsAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(campaignsModels.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(campaignsModels.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString("img", campaignsModels.get(position).getImageUrl());
            args.putString("name", campaignsModels.get(position).getName());
            myCampaignsBottomSheetDialog.setArguments(args);
            myCampaignsBottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(),myCampaignsBottomSheetDialog.getTag());
        });


    }

    @Override
    public int getItemCount() {
        return campaignsModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.campaignsImg);
            name = itemView.findViewById(R.id.campaignsName);

        }
    }
}
