package com.swinfotech.foodapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.swinfotech.foodapp.adapter.CategorieActivityAdapter;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.ActivityCategoriesBinding;
import com.swinfotech.foodapp.fragment.models.home.CategoryModel;
import com.swinfotech.foodapp.model.CategorieActivityModel;
import com.swinfotech.foodapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Categories extends AppCompatActivity {

    ActivityCategoriesBinding binding;
    Categories activity;

    private CategorieActivityAdapter categorieActivityAdapter;
    List<CategorieActivityModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = this;

        binding.categorieBack.setOnClickListener(v -> onBackPressed());


        getCategories();

    }

    private void getCategories() {
        binding.categoriesActivityRecView.setLayoutManager(new GridLayoutManager(activity, 3));
        binding.categoriesActivityRecView.setHasFixedSize(true);
        categorieActivityAdapter = new CategorieActivityAdapter(activity, modelList);
        binding.categoriesActivityRecView.setAdapter(categorieActivityAdapter);

        getCategoriesFromApi();

    }

    private void getCategoriesFromApi() {
        RetrofitBuilder.getService().getCategories("1")
                .enqueue(new Callback<CategoryModel>() {
                    @Override
                    public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                        modelList.clear();
                        if (response.body().getGetCat().getData().size() > 0) {
                            for (int i = 0; i < response.body().getGetCat().getData().size(); i++) {
                                modelList.add(new CategorieActivityModel(Constants.IMAGE_BASE_URL + response.body().getGetCat().getData().get(i).getImage()
                                        , response.body().getGetCat().getData().get(i).getEnName()));
                            }
                            binding.categoriesActivityRecView.getAdapter().notifyDataSetChanged();
                        }


                    }

                    @Override
                    public void onFailure(Call<CategoryModel> call, Throwable t) {

                    }
                });
    }


}