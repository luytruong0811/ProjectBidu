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
    private MutableLiveData<List<Category>> mutableLiveData;
    private List<Category> categories;

    public CategoryViewModel() {
        mutableLiveData = new MutableLiveData<>();
        categories = new ArrayList<>();
        categories.add(new Category("All"));
        categories.add(new Category("Jacket"));
        categories.add(new Category("Sweater"));
        categories.add(new Category("Skinny pants"));
        categories.add(new Category("Blouse"));
        categories.add(new Category("Sweater"));
        categories.add(new Category("Skinny pants"));
        categories.add(new Category("Blouse"));
        mutableLiveData.setValue(categories);
    }

    public LiveData<List<Category>> getListCategoryLiveData() {
        return mutableLiveData;
    }
}
