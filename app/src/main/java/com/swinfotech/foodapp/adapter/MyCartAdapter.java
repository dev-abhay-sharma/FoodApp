package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.activities.OrderDetails;
import com.swinfotech.foodapp.model.MyCartModel;

import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {

    Context context;
    List<MyCartModel> myCartModels;

    public MyCartAdapter(Context context, List<MyCartModel> myCartModels) {
        this.context = context;
        this.myCartModels = myCartModels;
    }

    @NonNull
    @Override
    public MyCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_cart_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(myCartModels.get(position).getImgUrl())
                .into(holder.img);

        holder.name.setText(myCartModels.get(position).getName());
        holder.price.setText(myCartModels.get(position).getPrice());

        holder.itemView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, OrderDetails.class));
        });
    }

    @Override
    public int getItemCount() {
        return myCartModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.myCartImg);
            name = itemView.findViewById(R.id.myCartName);
            price = itemView.findViewById(R.id.myCartPrice);
        }
    }
}