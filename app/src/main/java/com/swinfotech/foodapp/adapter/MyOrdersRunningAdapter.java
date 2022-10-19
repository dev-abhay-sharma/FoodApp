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
import com.swinfotech.foodapp.model.MyOrdersRunningModel;

import java.util.List;

public class MyOrdersRunningAdapter extends RecyclerView.Adapter<MyOrdersRunningAdapter.ViewHolder> {

    Context context;
    List<MyOrdersRunningModel> myOrdersRunningModels;
    public String[] mColors = {"#ffc000","#a61011","#ec9e54","#ffffff","#673AB7","#964B00"};

    public MyOrdersRunningAdapter(Context context, List<MyOrdersRunningModel> myOrdersRunningModels) {
        this.context = context;
        this.myOrdersRunningModels = myOrdersRunningModels;
    }

    @NonNull
    @Override
    public MyOrdersRunningAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_orders_running_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersRunningAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(myOrdersRunningModels.get(position).getImgUrl())
                .into(holder.img);

        holder.name.setText(myOrdersRunningModels.get(position).getName());
        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.length]));
    }

    @Override
    public int getItemCount() {
        return myOrdersRunningModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.myOrdersRunningImg);
            name = itemView.findViewById(R.id.myOrdersRunningName);
            cardView = itemView.findViewById(R.id.myOrdersRunningCardView);
        }
    }
}