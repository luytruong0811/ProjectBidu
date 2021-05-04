package com.example.projectbidu.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Category;
import com.example.projectbidu.model.Product;
import com.example.projectbidu.model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellersViewModel extends ViewModel {
    private MutableLiveData<List<Seller>> mutableLiveData;
    private List<Seller> sellers;

    public SellersViewModel() {
        mutableLiveData = new MutableLiveData<>();
        sellers = new ArrayList<>();
        sellers.add(new Seller(1,"Person Mandaley", R.drawable.topseller1,1,"Jacket","#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(2,"Tuyen Nguyen Kim",R.drawable.topseller2,2,"Sweater","#Jacket #Sweater"));
        sellers.add(new Seller(3,"Veray Rose",R.drawable.topseller3,3,"Skinny","#Jacket #Skinny pants #<16"));
        sellers.add(new Seller(4,"Angel Angel",R.drawable.topseller4,4,"Jacket","#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(5,"Person Mandaley",R.drawable.topseller1,5,"<16","#<16"));
        sellers.add(new Seller(6,"Person Mandaley",R.drawable.topseller2,6,"Sweater","#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(7,"Person Mandaley",R.drawable.topseller4,7,"Jacket","#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(8,"Person Mandaley",R.drawable.topseller3,8,"Jacket","#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        mutableLiveData.setValue(sellers);
    }

    public LiveData<List<Seller>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void resetListSellers(Category category) {
        if(category.getTitle().equals("All")){
            mutableLiveData.setValue(sellers);
        }else{
            List<Seller> temp = new ArrayList<>();
            for (int i=0;i<sellers.size();i++){
                if(sellers.get(i).getCategory().equals(category.getTitle())){
                    temp.add(sellers.get(i));
                }
            }
            mutableLiveData.setValue(temp);
        }
    }
}
