package com.swinfotech.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.model.SliderItem;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<SliderItem> mSliderItems = new ArrayList<>();

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<SliderItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapter.SliderAdapterVH viewHolder, int position) {

        SliderItem sliderItem = mSliderItems.get(position);
//        Log.e("URl", "onBindViewHolder: " + sliderItem.getImage());
//        viewHolder.tv_auto_image_slider.setText(sliderItem.getName());


        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImage())
                .fitCenter()
                .into(viewHolder.iv_auto_image_slider);
        // This is for API
//        Glide.with(viewHolder.itemView)
//                .load(COMMISSION_IMAGES_BASE_URL + sliderItem.getImage())
//                .fitCenter()
//                .into(viewHolder.iv_auto_image_slider);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you can click on slides do something your want
            }
        });

    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        ImageView iv_auto_image_slider;
        TextView tv_auto_image_slider;
        public SliderAdapterVH(View itemView) {
            super(itemView);

            iv_auto_image_slider = itemView.findViewById(R.id.image_slider_iv);
//            iv_auto_image_slider = itemView.findViewById(R.id.iv_auto_image_slider);
//            tv_auto_image_slider = itemView.findViewById(R.id.tv_auto_image_slider);

        }
    }

}
