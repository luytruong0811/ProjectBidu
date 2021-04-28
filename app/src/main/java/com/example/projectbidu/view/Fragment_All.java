package com.example.projectbidu.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectbidu.R;
import com.example.projectbidu.adapter.AdapterCategory;
import com.example.projectbidu.adapter.AdapterProduct;
import com.example.projectbidu.model.Category;
import com.example.projectbidu.model.Product;
import com.example.projectbidu.viewmodel.CategoryViewModel;
import com.example.projectbidu.viewmodel.ProductTopViewModel;

import java.util.ArrayList;
import java.util.List;


public class Fragment_All extends Fragment implements AdapterProduct.ItemClickListener, AdapterCategory.ItemClickListener {
    private View view;
    private AdapterCategory adapterCategory;
    private AdapterProduct adapterProduct;
    private RecyclerView rvCategory,rvProduct;
    private LinearLayoutManager mLinearLayoutManagerCategory;
    private GridLayoutManager mGridLayoutManagerProduct;

    private ProductTopViewModel productTopViewModel;
    private CategoryViewModel categoryViewModel;

    public Fragment_All() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__all, container, false);
        init();
        setRecyclerviewCategory();
        setRecyclerviewProduct();

        return view;
    }

    private void setRecyclerviewProduct() {
        rvProduct.setHasFixedSize(true);

        mGridLayoutManagerProduct =new GridLayoutManager(getContext(),2);
        rvProduct.setLayoutManager(mGridLayoutManagerProduct);

        productTopViewModel = new ViewModelProvider(this).get(ProductTopViewModel.class);
        //adapter
        adapterProduct = new AdapterProduct(productTopViewModel.getListProductLiveData().getValue(),this);

        productTopViewModel.getListProductLiveData().observe(getViewLifecycleOwner(),products -> {
            adapterProduct.notifyDataSetChanged();
        });
        rvProduct.setAdapter(adapterProduct);


    }

    private void setRecyclerviewCategory() {
        rvCategory.setHasFixedSize(true);
        mLinearLayoutManagerCategory = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(mLinearLayoutManagerCategory);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getListCategoryLiveData().observe(getViewLifecycleOwner(),categorys->{
            if(adapterCategory==null) {
                adapterCategory = new AdapterCategory(categorys,this);
                rvCategory.setAdapter(adapterCategory);
            }
            adapterCategory.notifyDataSetChanged();
        });
    }

    private void init() {
        rvCategory = view.findViewById(R.id.rvCategory);
        rvProduct =view.findViewById(R.id.rvProduct);
    }

    @Override
    public void onClick(int position) {
        productTopViewModel.updateProduct(position);
    }


    @Override
    public void getDataItemClick(Category category) {
        productTopViewModel.resetListProduct(category);
    }
}