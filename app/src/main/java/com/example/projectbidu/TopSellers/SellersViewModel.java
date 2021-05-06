package com.example.projectbidu.TopSellers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectbidu.R;
import com.example.projectbidu.Category.Category;

import java.util.ArrayList;
import java.util.List;

public class SellersViewModel extends ViewModel {
    private final MutableLiveData<List<Seller>> listMutableLiveData;
    private final List<Seller> sellers;

    public SellersViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        sellers = new ArrayList<>();
        sellers.add(new Seller(1,"Person Mandaley", R.drawable.topseller1,1,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(2,"Tuyen Nguyen Kim",R.drawable.topseller2,2,"#Jacket #Sweater"));
        sellers.add(new Seller(3,"Veray Rose",R.drawable.topseller3,3,"#Jacket #Skinny pants #<16"));
        sellers.add(new Seller(4,"Angel Angel",R.drawable.topseller4,4,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(5,"Person Mandaley",R.drawable.topseller1,5,"#<16"));
        sellers.add(new Seller(6,"Person Mandaley",R.drawable.topseller2,6,"#Jacket #Sweater #Jeans #<16"));
        sellers.add(new Seller(7,"Person Mandaley",R.drawable.topseller4,7,"#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16"));
        sellers.add(new Seller(8,"Person Mandaley",R.drawable.topseller3,8,"#Jacket #Sweater #Skinny pants"));
        listMutableLiveData.setValue(sellers);
    }

    public LiveData<List<Seller>> getMutableLiveData() {
        return listMutableLiveData;
    }

    public void resetListSellers(Category category) {
        String title = category.getTitle();
        if(title.equals("All")) {
            listMutableLiveData.setValue(sellers);
        } else {
            List<Seller> temp = new ArrayList<>();
            for (int i=0;i<sellers.size();i++) {
                if(sellers.get(i).getCategory().contains(title)) {
                    temp.add(sellers.get(i));
                }
            }
            listMutableLiveData.setValue(temp);
        }
    }
}
