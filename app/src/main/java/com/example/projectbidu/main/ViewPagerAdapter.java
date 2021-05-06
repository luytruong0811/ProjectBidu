package com.example.projectbidu.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projectbidu.Product.Fragment_All;
import com.example.projectbidu.TopSellers.Fragment_TopSellers;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment_All();
            case 1:
                return new Fragment_TopSellers();
            default:
                return new Fragment_All();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void setTitle(TabLayout.Tab tab, int position) {
        switch (position){
            case 0:
                tab.setText("All");
                break;
            case 1:
                tab.setText("Top Sellers");
                break;
        }
    }
}