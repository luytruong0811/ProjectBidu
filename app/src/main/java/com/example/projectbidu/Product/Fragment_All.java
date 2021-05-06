package com.example.projectbidu.Product;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

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
import com.example.projectbidu.Hastag.HasTagAdapter;
import com.example.projectbidu.Category.Category;
import com.example.projectbidu.Category.CategoryViewModel;
import com.example.projectbidu.Hastag.HasTagViewModel;


public class Fragment_All extends Fragment implements ProductAdapter.ItemClickListener, CategoryAdapter.ItemClickListener {
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private RecyclerView rvCategory;
    private RecyclerView rvProduct;
    private RecyclerView rvHasTag;
    private ProductViewModel productViewModel;


    public Fragment_All() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__all, container, false);
        rvCategory = view.findViewById(R.id.rvCategory);
        rvProduct = view.findViewById(R.id.rvProduct);
        rvHasTag = view.findViewById(R.id.rv_has_tag);
        ImageView ivFilter = view.findViewById(R.id.iv_filter);
        ImageView ivDateFilter = view.findViewById(R.id.iv_date);
        setRecyclerviewCategory();
        setRecyclerviewProduct();
        setRecyclerviewHasTag();
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

    private void setRecyclerviewHasTag() {
        rvHasTag.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHasTag.setLayoutManager(linearLayoutManager);

        HasTagViewModel hasTagViewModel = new ViewModelProvider(this).get(HasTagViewModel.class);
        HasTagAdapter hasTagAdapter = new HasTagAdapter(hasTagViewModel.getListHasTagLiveData().getValue());

        hasTagViewModel.getListHasTagLiveData().observe(getViewLifecycleOwner(), hasTags -> hasTagAdapter.notifyDataSetChanged());
        rvHasTag.setAdapter(hasTagAdapter);
    }

    private void setRecyclerviewProduct() {
        rvProduct.setHasFixedSize(true);
        ((SimpleItemAnimator) rvProduct.getItemAnimator()).setSupportsChangeAnimations(false);

        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),2);
        rvProduct.setLayoutManager(gridLayoutManager);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productViewModel.getListProductLiveData().observe(getViewLifecycleOwner(), products -> {
            productAdapter = new ProductAdapter(products, this);
            rvProduct.setAdapter(productAdapter);
        });

        productViewModel.getProduct().observe(getViewLifecycleOwner(), product -> {
            int pos = productAdapter.findItemProduct(product);
            ProductAdapter.ProductViewHolder vh = (ProductAdapter.ProductViewHolder) rvProduct.findViewHolderForAdapterPosition(pos);
            if (vh!= null) {
                vh.upDateLike(product.isLike());
            } else {
                productAdapter.updateUIPosition(product);
            }
        });
    }

    private void setRecyclerviewCategory() {
        rvCategory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);
        CategoryViewModel categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getListCategoryLiveData().observe(getViewLifecycleOwner(), categories->{
            if(categoryAdapter ==null) {
                categoryAdapter = new CategoryAdapter(categories,this);
                rvCategory.setAdapter(categoryAdapter);
            }
            categoryAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onClick(Product product) {
        productViewModel.updateProduct(product);
    }


    @Override
    public void getDataItemClick(Category category) {
        productViewModel.resetListProduct(category);
    }
}