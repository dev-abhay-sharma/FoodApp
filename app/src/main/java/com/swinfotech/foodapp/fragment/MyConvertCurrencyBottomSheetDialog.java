package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.adapter.MenuAdapter;
import com.swinfotech.foodapp.databinding.ConvertCurrencyBinding;
import com.swinfotech.foodapp.databinding.MenuLayoutBinding;
import com.swinfotech.foodapp.model.MenuModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyConvertCurrencyBottomSheetDialog extends BottomSheetDialogFragment {
    String string;

    Context context;
    private ConvertCurrencyBinding binding;

    private MenuAdapter menuAdapter;
    List<MenuModel> menuModel = new ArrayList<>();

    public static MyConvertCurrencyBottomSheetDialog newInstance(String string) {
        MyConvertCurrencyBottomSheetDialog f = new MyConvertCurrencyBottomSheetDialog();
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

        binding = ConvertCurrencyBinding.inflate(inflater, container, false);

        convertPoints();

        //dialog cancel when touches outside (Optional)
        getDialog().setCanceledOnTouchOutside(true);
        return binding.getRoot();
    }

    private void convertPoints() {
        binding.convertPoints.setOnClickListener(v -> {
            if (getStringFromEditText(binding.convertAmount) == null) {
                binding.convertAmount.setError("Please Enter Points");
                binding.convertAmount.requestFocus();
            } else {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        Float f = Float.parseFloat(binding.convertAmount.getText().toString());
        Float f1 = (f / 5);
        String amount = String.valueOf(f1);
        binding.convertDone.setVisibility(View.VISIBLE);
        binding.convertDone.setText("$ " + amount);
    }

    private String getStringFromEditText(EditText editText) {
        // check if edittext is null or not
        if (editText == null) {
            // then return null
            return null;
        }
        // check if edittext is empty
        if (editText.getText().toString().trim().equalsIgnoreCase("")) {
            // then also return null for better optimization
            return null;
        }
        // else return the value
        return editText.getText().toString().trim();

    }


}