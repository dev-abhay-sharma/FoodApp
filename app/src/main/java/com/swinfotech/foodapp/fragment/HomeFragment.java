package com.swinfotech.foodapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.smarteist.autoimageslider.SliderAnimations;
import com.swinfotech.foodapp.R;
import com.swinfotech.foodapp.activities.BestReviewedFood;
import com.swinfotech.foodapp.activities.Campaigns;
import com.swinfotech.foodapp.activities.Categories;
import com.swinfotech.foodapp.activities.NewOnStackFood;
import com.swinfotech.foodapp.activities.Notification;
import com.swinfotech.foodapp.activities.PopularFoodNearBy;
import com.swinfotech.foodapp.activities.PopularRestaurant;
import com.swinfotech.foodapp.activities.Search;
import com.swinfotech.foodapp.adapter.AllRestaurantsAdapter;
import com.swinfotech.foodapp.adapter.BestReviewedFoodAdapter;
import com.swinfotech.foodapp.adapter.CampaignsAdapter;
import com.swinfotech.foodapp.adapter.CategoriesAdapter;
import com.swinfotech.foodapp.adapter.NewOnStackFoodAdapter;
import com.swinfotech.foodapp.adapter.PopularFoodsNearByAdapter;
import com.swinfotech.foodapp.adapter.PopularRestaurantsAdapter;
import com.swinfotech.foodapp.adapter.SliderAdapter;
import com.swinfotech.foodapp.adapter.SliderAdapter1;
import com.swinfotech.foodapp.api.RetrofitBuilder;
import com.swinfotech.foodapp.databinding.FragmentHomeBinding;
import com.swinfotech.foodapp.fragment.models.home.ActiveRestaurantModel;
import com.swinfotech.foodapp.fragment.models.home.CategoryModel;
import com.swinfotech.foodapp.fragment.models.home.PopularProducts;
import com.swinfotech.foodapp.model.AllRestaurantsModel;
import com.swinfotech.foodapp.model.BestReviewedFoodModel;
import com.swinfotech.foodapp.model.CampaignsModel;
import com.swinfotech.foodapp.model.CategorieActivityModel;
import com.swinfotech.foodapp.model.NewOnStackFoodModel;
import com.swinfotech.foodapp.model.PopularFoodsNearByModel;
import com.swinfotech.foodapp.model.PopularRestaurantsModel;
import com.swinfotech.foodapp.model.SliderItem;
import com.swinfotech.foodapp.model.SliderItem1;
import com.swinfotech.foodapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Context context;

    private FragmentHomeBinding binding;
    private SliderAdapter sliderAdapter;

    private CategoriesAdapter categoriesAdapter;
    List<CategorieActivityModel> modelList = new ArrayList<>();

    private PopularRestaurantsAdapter popularRestaurantsAdapter;
    List<PopularRestaurantsModel> popularRestaurantsModels = new ArrayList<>();

    private CampaignsAdapter campaignsAdapter;
    List<CampaignsModel> campaignsModels = new ArrayList<>();

    private PopularFoodsNearByAdapter popularFoodsNearByAdapter;
    List<PopularFoodsNearByModel> popularFoodsNearByModels = new ArrayList<>();

    private NewOnStackFoodAdapter newOnStackFoodAdapter;
    List<NewOnStackFoodModel> newOnStackFoodModels = new ArrayList<>();

    private BestReviewedFoodAdapter bestReviewedFoodAdapter;
    List<BestReviewedFoodModel> bestReviewedFoodModels = new ArrayList<>();

    private AllRestaurantsAdapter allRestaurantsAdapter;
    List<AllRestaurantsModel> allRestaurantsModels = new ArrayList<>();


    private SliderAdapter1 sliderAdapter1;
    //    private List<SliderItem> sliderItems = new ArrayList<>();
    private List<SliderItem1> sliderItems = new ArrayList<>();
    private Handler sliderHandler = new Handler();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // for menu option
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        getNotificationMenu();

//        putDataIntoSlider();
        putDataIntoSlider1();
        getCategories();

        getAllRestaurants();
        getPopularRestaurants();
        getCampaigns();
        getPopularFoodsNearBy();
        getNewOnStackFood();
        getBestReviewedFood();

        onClickInHomeFragment();


        return binding.getRoot();
    }

    private void getNotificationMenu() {
        binding.toolbar.inflateMenu(R.menu.notification);
        binding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.notify:
                        //do sth here
                        context.startActivity(new Intent(context, Notification.class));
                        return true;
                }
                return false;
            }
        });
    }

    private void onClickInHomeFragment() {
        binding.foodSearch.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Search.class));
        });

        binding.categorieActivity.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Categories.class));
        });

        binding.popularRestaurantActivity.setOnClickListener(v -> {
            context.startActivity(new Intent(context, PopularRestaurant.class));
        });

        binding.campaignsActivity.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Campaigns.class));
        });

        binding.popularFoodNearByActivity.setOnClickListener(v -> {
            context.startActivity(new Intent(context, PopularFoodNearBy.class));
        });

        binding.bestReviewedFoodActivity.setOnClickListener(v -> {
            context.startActivity(new Intent(context, BestReviewedFood.class));
        });

        binding.newOnStackFoodActivity.setOnClickListener(v -> {
            context.startActivity(new Intent(context, NewOnStackFood.class));
        });
    }


//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
////        getActivity().getMenuInflater().inflate(R.menu.notification, menu);
//
//        MenuInflater inflater1 = getActivity().getMenuInflater();
//        inflater1.inflate(R.menu.notification, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//
////        return true;
//
////        MenuItem menuItem = menu.findItem(R.id.notify);
//
//    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.notify:
//                //do sth here
//                context.startActivity(new Intent(context, Notification.class));
//                return true;
//        }
//        return false;
//    }

    private void getAllRestaurants() {
        binding.selectRest.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            MenuInflater menuInflater = popupMenu.getMenuInflater();
            menuInflater.inflate(R.menu.select_restaurants, popupMenu.getMenu());

            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()) {
                    case R.id.all:
                        Toast.makeText(context, "All Selected", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.takeAway:
                        Toast.makeText(context, "Take Away Selected", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.delivery:
                        Toast.makeText(context, "Delivery Selected", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            });
        });

        binding.allRestaurantsRecView.setLayoutManager(new LinearLayoutManager(context));
        binding.allRestaurantsRecView.setHasFixedSize(true);
        allRestaurantsAdapter = new AllRestaurantsAdapter(context, allRestaurantsModels);
        binding.allRestaurantsRecView.setAdapter(allRestaurantsAdapter);

    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        getActivity().getMenuInflater().inflate(R.menu.select_restaurants, menu);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.select_restaurants, menu);
    }


    private void getBestReviewedFood() {
        binding.bestReviewedFoodRecView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.bestReviewedFoodRecView.setHasFixedSize(true);
        bestReviewedFoodAdapter = new BestReviewedFoodAdapter(context, bestReviewedFoodModels);
        binding.bestReviewedFoodRecView.setAdapter(bestReviewedFoodAdapter);

        bestReviewedFoodModels.clear();
        bestReviewedFoodModels.add(new BestReviewedFoodModel("https://images.pexels.com/photos/2725744/pexels-photo-2725744.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Burger Combo"));
        bestReviewedFoodModels.add(new BestReviewedFoodModel("https://images.pexels.com/photos/3023476/pexels-photo-3023476.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Meat Pizza"));
        bestReviewedFoodModels.add(new BestReviewedFoodModel("https://images.pexels.com/photos/4393021/pexels-photo-4393021.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Veg Momos"));
        bestReviewedFoodModels.add(new BestReviewedFoodModel("https://images.pexels.com/photos/983297/pexels-photo-983297.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Peanut Butter Molten Cake"));
        bestReviewedFoodModels.add(new BestReviewedFoodModel("https://images.pexels.com/photos/12362923/pexels-photo-12362923.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Grilled Kebab"));

    }

    private void getNewOnStackFood() {
        binding.newOnStackFoodRecView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.newOnStackFoodRecView.setHasFixedSize(true);
        newOnStackFoodAdapter = new NewOnStackFoodAdapter(context, newOnStackFoodModels);
        binding.newOnStackFoodRecView.setAdapter(newOnStackFoodAdapter);

        newOnStackFoodModels.clear();
        newOnStackFoodModels.add(new NewOnStackFoodModel("https://images.pexels.com/photos/769969/pexels-photo-769969.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Italian Fast Food"));
        newOnStackFoodModels.add(new NewOnStackFoodModel("https://images.pexels.com/photos/3762069/pexels-photo-3762069.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Indian Food"));
        newOnStackFoodModels.add(new NewOnStackFoodModel("https://images.pexels.com/photos/1058714/pexels-photo-1058714.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Italian Fast Food"));
        newOnStackFoodModels.add(new NewOnStackFoodModel("https://images.pexels.com/photos/1487511/pexels-photo-1487511.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Mexican Food"));
        newOnStackFoodModels.add(new NewOnStackFoodModel("https://images.pexels.com/photos/1566837/pexels-photo-1566837.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Italian Fast Food"));
    }

    private void getPopularFoodsNearBy() {
        binding.popularFoodNearByRecView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.popularFoodNearByRecView.setHasFixedSize(true);
        popularFoodsNearByAdapter = new PopularFoodsNearByAdapter(context, popularFoodsNearByModels);
        binding.popularFoodNearByRecView.setAdapter(popularFoodsNearByAdapter);

        getPopularProducts();

    }

    private void getCampaigns() {
        binding.campaignsRecView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.campaignsRecView.setHasFixedSize(true);
        campaignsAdapter = new CampaignsAdapter(context, campaignsModels);
        binding.campaignsRecView.setAdapter(campaignsAdapter);

        campaignsModels.clear();
        campaignsModels.add(new CampaignsModel("https://images.pexels.com/photos/2097090/pexels-photo-2097090.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Spicy Crab Early Food"));
        campaignsModels.add(new CampaignsModel("https://images.pexels.com/photos/2641886/pexels-photo-2641886.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Spicy Chicken"));
        campaignsModels.add(new CampaignsModel("https://images.pexels.com/photos/3186654/pexels-photo-3186654.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Spicy Crab Early Food"));
        campaignsModels.add(new CampaignsModel("https://images.pexels.com/photos/958546/pexels-photo-958546.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Spicy Chicken"));
        campaignsModels.add(new CampaignsModel("https://images.pexels.com/photos/2679501/pexels-photo-2679501.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Spicy Crab Early Food"));
    }


    private void getPopularRestaurants() {
        binding.restaurantsRecView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.restaurantsRecView.setHasFixedSize(true);
        popularRestaurantsAdapter = new PopularRestaurantsAdapter(context, popularRestaurantsModels);
        binding.restaurantsRecView.setAdapter(popularRestaurantsAdapter);

        popularRestaurantsModels.clear();

        getActiveRestaurants();
    }

    private void getPopularProducts() {

        RetrofitBuilder.getService().getPopularProducts("1", "100")
                .enqueue(new Callback<PopularProducts>() {
                    @Override
                    public void onResponse(Call<PopularProducts> call, Response<PopularProducts> response) {
                        popularFoodsNearByModels.clear();
                        if (response.body().getGetProd().size() > 0) {
                            for (int i = 0; i < response.body().getGetProd().size(); i++) {
                                popularFoodsNearByModels.add(new PopularFoodsNearByModel(
                                        response.body().getGetProd().get(i).getpId() + "",
                                        response.body().getGetProd().get(i).getProdImg1(),
                                        response.body().getGetProd().get(i).getMrp(),
                                        response.body().getGetProd().get(i).getProdNameEn(),
                                        response.body().getGetProd().get(i).getShopNameEn()
                                ));

                            }
                        }
                        binding.popularFoodNearByRecView.getAdapter().notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<PopularProducts> call, Throwable t) {

                    }
                });


    }

    private void getActiveRestaurants() {

        RetrofitBuilder.getService().getActiveRestaurant("1", "100")
                .enqueue(new Callback<ActiveRestaurantModel>() {
                    @Override
                    public void onResponse(Call<ActiveRestaurantModel> call, Response<ActiveRestaurantModel> response) {
                        popularRestaurantsModels.clear();
                        if (response.body().getFetchRest().size() > 0) {
                            for (int i = 0; i < response.body().getFetchRest().size(); i++) {
                                popularRestaurantsModels.add(new PopularRestaurantsModel(
                                        response.body().getFetchRest().get(i).getId() + "",
                                        response.body().getFetchRest().get(i).getShopLogo(),
                                        response.body().getFetchRest().get(i).getShopNameEn()
                                ));
                                allRestaurantsModels.add(new AllRestaurantsModel(
                                        response.body().getFetchRest().get(i).getId() + "",
                                        response.body().getFetchRest().get(i).getShopLogo(),
                                        response.body().getFetchRest().get(i).getShopNameEn()
                                ));

                            }
                        }
                        binding.restaurantsRecView.getAdapter().notifyDataSetChanged();
                        binding.allRestaurantsRecView.getAdapter().notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<ActiveRestaurantModel> call, Throwable t) {

                    }
                });


    }

    private void getCategories() {

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
                            setAdapter();
                        }


                    }

                    @Override
                    public void onFailure(Call<CategoryModel> call, Throwable t) {

                    }
                });
    }

    private void setAdapter() {
        binding.categoriesRecView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        binding.categoriesRecView.setHasFixedSize(true);
        categoriesAdapter = new CategoriesAdapter(context, modelList);
        binding.categoriesRecView.setAdapter(categoriesAdapter);
    }

    private void putDataIntoSlider1() {

        sliderAdapter1 = new SliderAdapter1(context, sliderItems, binding.viewPagerImageSlider);

        //next set adapter to ViewPager2
        binding.viewPagerImageSlider.setAdapter(sliderAdapter1);

//        sliderItems.clear();
//        sliderItems.add(new SliderItem("https://images.pexels.com/photos/1010657/pexels-photo-1010657.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
//        sliderAdapter1.setItems(sliderItems);
//        sliderAdapter1.notifyDataSetChanged();

        sliderItems.add(new SliderItem1(R.drawable.profile_bg));
        sliderItems.add(new SliderItem1(R.drawable.profile_bg));
        sliderItems.add(new SliderItem1(R.drawable.profile_bg));
        sliderItems.add(new SliderItem1(R.drawable.profile_bg));

        binding.viewPagerImageSlider.setClipToPadding(false);
        binding.viewPagerImageSlider.setClipChildren(false);
        binding.viewPagerImageSlider.setOffscreenPageLimit(3);
        binding.viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        binding.viewPagerImageSlider.setPageTransformer(compositePageTransformer);
        binding.viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // slide duration 3 Seconds
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            binding.viewPagerImageSlider.setCurrentItem(binding.viewPagerImageSlider.getCurrentItem() + 1);
        }
    };

    private void putDataIntoSlider() {
        // setting up our slider

        sliderAdapter = new SliderAdapter(context);
        binding.mainImageSlider.setSliderAdapter(sliderAdapter);
        binding.mainImageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.mainImageSlider.startAutoCycle();


        sliderAdapter.addItem(new SliderItem("https://images.pexels.com/photos/1010657/pexels-photo-1010657.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        sliderAdapter.addItem(new SliderItem("https://images.pexels.com/photos/3369102/pexels-photo-3369102.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        sliderAdapter.addItem(new SliderItem("https://images.pexels.com/photos/3884476/pexels-photo-3884476.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        sliderAdapter.addItem(new SliderItem("https://images.pexels.com/photos/2356045/pexels-photo-2356045.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));

    }

}