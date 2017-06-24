package com.example.zjj.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zjj.myapplication.R;
import com.example.zjj.myapplication.adapter.FragmentAdapter;
import com.example.zjj.myapplication.fragments.ListFragment;
import com.example.zjj.myapplication.listener.PageChangeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zjj on 2017/6/22.
 */

public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);
       // toolBar.setLogo(R.drawable.katon);
        toolBar.setTitle("示例");
        toolBar.setSubtitle("toolBar,tabLayout.");
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        init();
    }

    private void init(){
        List<String> titles = new ArrayList<String>();
        for (int i = 1; i <= 10; i++ ){
            titles.add("名人" + i);
        }
        for(int i = 0; i < titles.size(); i++){
            tabs.addTab(tabs.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        for(int i = 0 ; i < titles.size(); i++){
            fragmentList.add(new ListFragment());
        }
        FragmentAdapter fm = new FragmentAdapter(getSupportFragmentManager(), titles, fragmentList);
        viewpager.setAdapter(fm);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabs.setupWithViewPager(viewpager);
        tabs.setTabsFromPagerAdapter(fm);
        viewpager.addOnPageChangeListener(new PageChangeListener(tabs));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
