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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.model.MyOrdersHistoryModel;

import java.util.List;

public class MyOrdersHistoryAdapter extends RecyclerView.Adapter<MyOrdersHistoryAdapter.ViewHolder> {

    Context context;
    List<MyOrdersHistoryModel> myOrdersHistoryModels;
    public String[] mColors = {"#ffc000","#a61011","#ec9e54","#ffffff","#673AB7","#964B00"};

    public MyOrdersHistoryAdapter(Context context, List<MyOrdersHistoryModel> myOrdersHistoryModels) {
        this.context = context;
        this.myOrdersHistoryModels = myOrdersHistoryModels;
    }

    @NonNull
    @Override
    public MyOrdersHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_orders_history_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersHistoryAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(myOrdersHistoryModels.get(position).getImgUrl())
                .into(holder.img);

        holder.name.setText(myOrdersHistoryModels.get(position).getName());
        holder.status.setText(myOrdersHistoryModels.get(position).getStatus());
        if (myOrdersHistoryModels.get(position).getStatus().equalsIgnoreCase("Delivered")) {
            holder.status.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_background_green));
        } else {
            holder.status.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_background_red));
        }

        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));
    }

    @Override
    public int getItemCount() {
        return myOrdersHistoryModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, status;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.myOrdersHistoryImg);
            name = itemView.findViewById(R.id.myOrdersHistoryName);
            status = itemView.findViewById(R.id.myOrdersHistoryStatus);
            cardView = itemView.findViewById(R.id.myOrdersHistoryCardView);
        }
    }
}
