package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.databinding.MenuLayoutBinding;
import com.swinfotech.foodapp.databinding.MyCampaignsBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyCampaignsBottomSheetDialog extends BottomSheetDialogFragment {
    String string;

    Context context;
    private MyCampaignsBottomSheetBinding binding;

    public static MyCampaignsBottomSheetDialog newInstance(String string) {
        MyCampaignsBottomSheetDialog f = new MyCampaignsBottomSheetDialog();
        Bundle args = new Bundle();
        args.putString("string", string);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        string = getArguments().getString("string");
        //bottom sheet round corners can be obtained but the while background appears to remove that we need to add this.
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = MyCampaignsBottomSheetBinding.inflate(inflater, container, false);

        binding.campaignsBottomSheetBack.setOnClickListener(v -> getDialog().onBackPressed());

        getIntentData();

        //dialog cancel when touches outside (Optional)
        getDialog().setCanceledOnTouchOutside(true);
        return binding.getRoot();
    }

    private void getIntentData() {
        Bundle mArgs = getArguments();
        String img = mArgs.getString("img");
        String name = mArgs.getString("name");

        Glide.with(context).load(img).into(binding.campaignsBottomSheetImg);
        binding.campaignsBottomSheetName.setText(name);
    }


}