package com.example.projectbidu.TopSellers;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectbidu.R;
import com.example.projectbidu.Category.CategoryAdapter;
import com.example.projectbidu.Category.Category;
import com.example.projectbidu.Category.CategoryViewModel;


public class Fragment_TopSellers extends Fragment implements CategoryAdapter.ItemClickListener {
    private CategoryAdapter categoryAdapter;
    private RecyclerView rvCategory;

    private TopSellerAdapter topSellerAdapter;
    private RecyclerView rvSeller;
    private SellersViewModel sellersViewModel;

    public Fragment_TopSellers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__top_sellers, container, false);
        rvCategory = view.findViewById(R.id.rvCategoryTop);
        rvSeller = view.findViewById(R.id.rvSellers);
        ImageView ivFilter = view.findViewById(R.id.iv_filter);
        ImageView ivDateFilter = view.findViewById(R.id.iv_date);
        setRecyclerviewCategory();
        setRecyclerviewSeller();
        ivFilter.setOnClickListener(v -> openFilterDialog());
        ivDateFilter.setOnClickListener(v -> openDateFilterDialog());
        return view;
    }

    private void openDateFilterDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_date);

        Window window = dialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == Gravity.CENTER) {
            dialog.setCancelable(false);
        }
        TextView tvExit = dialog.findViewById(R.id.tv_exit_date);
        TextView tvConfirm = dialog.findViewById(R.id.tv_confirm);

        tvExit.setOnClickListener(v -> dialog.dismiss());

        tvConfirm.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void openFilterDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_filter);

        Window window = dialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == Gravity.CENTER) {
            dialog.setCancelable(false);
        }
        TextView tvExit = dialog.findViewById(R.id.tv_exit);
        TextView tvConfirmFilter = dialog.findViewById(R.id.tv_confirm_filter);

        tvExit.setOnClickListener(v -> dialog.dismiss());

        tvConfirmFilter.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void setRecyclerviewSeller() {
        rvSeller.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvSeller.setLayoutManager(linearLayoutManager);

        sellersViewModel = new ViewModelProvider(this).get(SellersViewModel.class);
        sellersViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), seller -> {
            topSellerAdapter = new TopSellerAdapter(seller);
            rvSeller.setAdapter(topSellerAdapter);
        });
    }

    private void setRecyclerviewCategory() {
        rvCategory.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);

        CategoryViewModel categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getListCategoryLiveData().observe(getViewLifecycleOwner(),categories->{
            if(categoryAdapter == null) {
                categoryAdapter = new CategoryAdapter(categories,this);
                rvCategory.setAdapter(categoryAdapter);
            }
            categoryAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void getDataItemClick(Category category) {
        sellersViewModel.resetListSellers(category);
    }

}