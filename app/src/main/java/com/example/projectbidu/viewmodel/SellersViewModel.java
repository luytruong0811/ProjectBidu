package com.example.projectbidu.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Product;
import com.example.projectbidu.model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellersViewModel extends ViewModel {
    private MutableLiveData<List<Seller>> mListSellersLiveData;
    private List<Seller> mListSellers;

    public SellersViewModel() {
         mListSellersLiveData = new MutableLiveData<>();
         initData();
    }

    private void initData() {
        mListSellers = new ArrayList<>();
        mListSellers.add(new Seller("Person Mandaley", R.drawable.sellerdemo,1,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,2,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,3,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,4,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,5,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,6,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,7,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellers.add(new Seller("Person Mandaley",R.drawable.sellerdemo,8,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mListSellersLiveData.setValue(mListSellers);
    }

    public LiveData<List<Seller>> getmListSellersLiveData() {
        return mListSellersLiveData;
    }

}
