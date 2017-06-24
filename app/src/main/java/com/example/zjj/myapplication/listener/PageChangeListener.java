package com.example.zjj.myapplication.listener;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

/**
 * Created by zjj on 2017/6/23.
 */

public class PageChangeListener implements OnPageChangeListener {

    private TabLayout tabLayout;

    public PageChangeListener(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabLayout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
