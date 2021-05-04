package com.example.projectbidu.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.projectbidu.model.HasTag;

import java.util.ArrayList;
import java.util.List;

public class HasTagViewModel extends ViewModel {
    private final MutableLiveData<List<HasTag>> mutableLiveData;

    public HasTagViewModel() {
        mutableLiveData = new MutableLiveData<>();
        List<HasTag> hasTags = new ArrayList<>();
        hasTags.add(new HasTag("#happy"));
        hasTags.add(new HasTag("#clothes"));
        mutableLiveData.setValue(hasTags);
    }

    public LiveData<List<HasTag>> getListHasTagLiveData() {
        return mutableLiveData;
    }
}
