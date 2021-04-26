package com.example.projectbidu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Fragment_All extends Fragment {
    private View view;
    private AdapterCategory adapterCategory;
    private RecyclerView rvCategory;
    private LinearLayoutManager linearLayoutManager;
    private List<Category> mListCategory;


    public Fragment_All() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__all, container, false);
        rvCategory = view.findViewById(R.id.rvCategory);
        rvCategory.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);
        adapterCategory =new AdapterCategory(getContext());
        adapterCategory.setData(getData());
        rvCategory.setAdapter(adapterCategory);
        return view;
    }

    private List<Category> getData() {
        mListCategory =new ArrayList<>();
        mListCategory.add(new Category("Jacket"));
        mListCategory.add(new Category("Sweater"));
        mListCategory.add(new Category("Skinny"));
        mListCategory.add(new Category("Jacket"));
        mListCategory.add(new Category("Jacket"));
        mListCategory.add(new Category("Jacket"));
        mListCategory.add(new Category("Jacket"));
        return mListCategory;
    }
}