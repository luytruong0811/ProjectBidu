package com.example.projectbidu.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projectbidu.R;
import com.example.projectbidu.main.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager2, viewPagerAdapter::setTitle).attach();

//        TabLayout.Tab tab = tabLayout.getTabAt(0);
//        tab.setCustomView(R.layout.custom_title_tablayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LinearLayout tabLayout1 = (LinearLayout)((ViewGroup) tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout1.getChildAt(1);
                Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.lenxend_bold);
                tabTextView.setTypeface(typeface);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LinearLayout tabLayout1 = (LinearLayout)((ViewGroup) tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout1.getChildAt(1);
                Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.lexend_regular);
                tabTextView.setTypeface(typeface);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }
}