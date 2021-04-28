package com.example.projectbidu.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Category;
import com.example.projectbidu.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel {
    private MutableLiveData<List<Category>> mListCategoryLiveData;
    private List<Category> mListCategory;

    public CategoryViewModel() {
        mListCategoryLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mListCategory = new ArrayList<>();
        mListCategory.add(new Category("All"));
        mListCategory.add(new Category("Jacket"));
        mListCategory.add(new Category("Sweater"));
        mListCategory.add(new Category("Skinny pants"));
        mListCategory.add(new Category("Blouse"));
        mListCategory.add(new Category("Sweater"));
        mListCategory.add(new Category("Skinny pants"));
        mListCategory.add(new Category("Blouse"));
        mListCategoryLiveData.setValue(mListCategory);
    }

    public LiveData<List<Category>> getListCategoryLiveData() {
        return mListCategoryLiveData;
    }
}
