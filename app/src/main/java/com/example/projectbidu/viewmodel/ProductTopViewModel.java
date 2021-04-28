package com.example.projectbidu.viewmodel;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Category;
import com.example.projectbidu.model.Product;
import com.example.projectbidu.view.Fragment_All;

import java.util.ArrayList;
import java.util.List;

public class ProductTopViewModel extends ViewModel {
    private MutableLiveData<List<Product>> mListProductLiveData;
    private List<Product> mListProduct;

    public ProductTopViewModel() {
        mListProductLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mListProduct = new ArrayList<>();
        mListProduct.add(new Product(R.drawable.productdemo,false,"[Woman] Trousers short","Jacket",450000L,600000L,true,15L));
        mListProduct.add(new Product(R.drawable.productdemo,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Sweater",450000L,null,false,15L));
        mListProduct.add(new Product(R.drawable.productdemo,true,"[Woman] Trousers short","Jacket",450000L,null,true,15L));
        mListProduct.add(new Product(R.drawable.productdemo,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Blouse",450000L,null,true,15L));
        mListProduct.add(new Product(R.drawable.productdemo,true,"[Woman] Trousers short","Skinny pants",450000L,600000L,true,null));
        mListProduct.add(new Product(R.drawable.productdemo,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Blouse",450000L,null,false,15L));
        mListProduct.add(new Product(R.drawable.productdemo,true,"[Woman] Trousers short","Sweater",450000L,null,true,15L));
        mListProduct.add(new Product(R.drawable.productdemo,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Skinny pants",450000L,null,true,null));
        mListProduct.add(new Product(R.drawable.productdemo,false,"[Woman] Trousers short","Sweater",450000L,600000L,true,15L));
        mListProductLiveData.setValue(mListProduct);
    }

    public LiveData<List<Product>> getListProductLiveData() {
        return mListProductLiveData;
    }

    public void updateProduct(int position) {
       if(mListProduct.get(position).isLike()){
           mListProduct.get(position).setLike(false);
       }else{
           mListProduct.get(position).setLike(true);
       }
       mListProductLiveData.setValue(mListProduct);
    }

    public void resetListProduct(Category category) {
        if(category.getTitle().equals("All")){
            mListProductLiveData.setValue(mListProduct);
        }else{
            List<Product> temp = new ArrayList<>();
            for (int i=0;i<mListProduct.size();i++){
                if(mListProduct.get(i).getCategory().equals(category.getTitle())){
                    temp.add(mListProduct.get(i));
                }
            }
            mListProductLiveData.setValue(temp);
        }
    }
}
