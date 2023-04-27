package com.example.final_project_lnt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);

        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2,
                ((tab, position) -> tab.setText(pagerAdapter.getFragmentTitle(position)))).attach();
    }

    public void setViewPager2 (ViewPager2 viewPager2) {
        if(pagerAdapter == null){
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new FirstFragment(),"Counter");
            pagerAdapter.addFragment(new SecondFragment(),"Area");
            pagerAdapter.addFragment(new ThirdFragment(),"Volume");
            viewPager2.setAdapter(pagerAdapter);
        }

    }
}