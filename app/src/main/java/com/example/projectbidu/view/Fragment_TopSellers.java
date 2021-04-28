package com.example.projectbidu.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectbidu.R;
import com.example.projectbidu.adapter.AdapterCategory;
import com.example.projectbidu.adapter.AdapterSellers;
import com.example.projectbidu.model.Category;
import com.example.projectbidu.model.Seller;
import com.example.projectbidu.viewmodel.CategoryViewModel;
import com.example.projectbidu.viewmodel.SellersViewModel;

import java.util.ArrayList;
import java.util.List;


public class Fragment_TopSellers extends Fragment implements AdapterCategory.ItemClickListener {
    private View view;
    private AdapterCategory adapterCategory;
    private RecyclerView rvCategory;

    private AdapterSellers adapterSellers;
    private RecyclerView rvSellers;
    private LinearLayoutManager linearLayoutManagerSellers,linearLayoutManagerCategory;

    private SellersViewModel sellersViewModel;

    private CategoryViewModel categoryViewModel;
    public Fragment_TopSellers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__top_sellers, container, false);
        init();
        setRecyclerviewCategory();
        setRecyclerviewSeller();
        return  view;
    }

    private void setRecyclerviewSeller() {
        rvSellers.setHasFixedSize(true);
        linearLayoutManagerSellers =new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvSellers.setLayoutManager(linearLayoutManagerSellers);
        sellersViewModel = new ViewModelProvider(this).get(SellersViewModel.class);

        rvSellers.setAdapter(adapterSellers);
    }

    private void setRecyclerviewCategory() {
        rvCategory.setHasFixedSize(true);
        linearLayoutManagerCategory = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(linearLayoutManagerCategory);
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
        rvCategory = view.findViewById(R.id.rvCategoryTop);
        rvSellers = view.findViewById(R.id.rvSellers);
    }



    @Override
    public void getDataItemClick(Category category) {

    }
}