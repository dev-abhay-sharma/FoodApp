package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.model.MenuModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    List<MenuModel> menuModel;

    public MenuAdapter(Context context, List<MenuModel> menuModel) {
        this.context = context;
        this.menuModel = menuModel;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(menuModel.get(position).getImageUrl())
                .into(holder.img);

        holder.name.setText(menuModel.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            if (menuModel.get(position).getaClass() != null) {
                context.startActivity(new Intent(context, menuModel.get(position).getaClass()));
            } else {
                Toast.makeText(context, "Please Add a class for this click !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuModel.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.menuImage);
            name = itemView.findViewById(R.id.menuName);
        }
    }
}
