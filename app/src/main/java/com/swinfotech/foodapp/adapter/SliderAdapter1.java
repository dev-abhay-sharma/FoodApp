package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.model.SliderItem1;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter1 extends RecyclerView.Adapter<SliderAdapter1.SliderViewHolder>{

    Context context;
    private List<SliderItem1> sliderItems;
    private ViewPager2 viewPager2;

    public SliderAdapter1(Context context, List<SliderItem1> sliderItems, ViewPager2 viewPager2) {
        this.context = context;
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    public void setItems(List<SliderItem1> sliderItems) {
        this.sliderItems = sliderItems;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.slide_item_container, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImageView(sliderItems.get(position));
        if (position == sliderItems.size() - 2) {
            viewPager2.post(runnable);
        }
//        SliderItem sliderItem = sliderItems.get(position);
//        Glide.with(holder.itemView)
//                .load(sliderItem.getImage())
//                .fitCenter()
//                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView imageView;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageSlide);
        }

        void setImageView(SliderItem1 slider1Item) {

            imageView.setImageResource(slider1Item.getImage());
            //custom settings for fast loading image
//            RequestOptions options = new RequestOptions()
//                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//                    .centerCrop()
//                    .priority(Priority.HIGH)
//                    .format(DecodeFormat.PREFER_RGB_565);
//
//            Glide.with(context)
//                    .applyDefaultRequestOptions(options)
//                    .load(slider1Item.getImage())
//                    .thumbnail(0.4f)
//                    .into(imageView);
        }

//        void setImage(SliderItem sliderItem) {
//            Glide.with(itemView)
//                    .load(sliderItem.getImage())
//                    .fitCenter()
//                    .into(imageView);
////            imageView.setImageResource(sliderItem.getImage());
//        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };
}
