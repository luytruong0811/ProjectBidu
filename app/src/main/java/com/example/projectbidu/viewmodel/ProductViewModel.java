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

import java.nio.channels.MulticastChannel;
import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {
    private final MutableLiveData<List<Product>> listMutableLiveData;
    private final MutableLiveData<Product> productMutableLiveData;
    private final MutableLiveData<List<Product>> mListDataFitter;
    private List<Product> products;

    public void setListProduct(List<Product> products) {
        this.products = products;
    }

    public ProductViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        productMutableLiveData = new MutableLiveData<>();
        mListDataFitter = new MutableLiveData<>();
        products = new ArrayList<>();
        products.add(new Product(1,R.drawable.anh1,false,"[Woman] Trousers short","Jacket",1700000L,null,false,null));
        products.add(new Product(2,R.drawable.anh2,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers......","Sweater",1700000L,1900000L,false,12L));
        products.add(new Product(3,R.drawable.anh3,true,"[Woman] Trousers short","Jacket",240000L,1900000L,true,12L));
        products.add(new Product(4,R.drawable.anh4,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Blouse",1700000L,null,true,15L));
        products.add(new Product(5,R.drawable.anh1,true,"[Woman] Trousers short","Skinny pants",450000L,600000L,true,null));
        products.add(new Product(6,R.drawable.anh3,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Blouse",450000L,null,false,15L));
        products.add(new Product(7,R.drawable.anh4,true,"[Woman] Trousers short","Sweater",450000L,null,true,15L));
        products.add(new Product(8,R.drawable.anh2,false,"[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers","Skinny pants",450000L,null,true,null));
        products.add(new Product(9,R.drawable.anh1,false,"[Woman] Trousers short","Sweater",450000L,600000L,true,15L));
        listMutableLiveData.setValue(products);
    }

    public MutableLiveData<List<Product>> getListProductLiveData() {
        return listMutableLiveData;
    }

    public MutableLiveData<Product> getProduct() {
        return productMutableLiveData;
    }

    public MutableLiveData<List<Product>> getListDataFitter() {
        return mListDataFitter;
    }

    public void updateProduct(Product product) {
        for (Product item :products) {
            if(item.getIdProduct() == product.getIdProduct()){
                if(item.isLike()) {
                    item.setLike(false);
                } else {
                    item.setLike(true);
                }
                productMutableLiveData.setValue(item);
            }
        }
    }

    public void resetListProduct(Category category) {
        if(category.getTitle().equals("All")) {
            listMutableLiveData.setValue(products);
        } else {
            List<Product> temp = new ArrayList<>();
            for (int i=0;i<products.size();i++){
                if(products.get(i).getCategory().equals(category.getTitle())){
                    temp.add(products.get(i));
                }
            }
            listMutableLiveData.setValue(temp);
        }
    }
}
