package com.example.administrator.indicatorframe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2016-08-15.
 */
public class FeaturedViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mList;
    private String[] mTitle;
    public FeaturedViewPagerAdapter(FragmentManager fm,List<Fragment> mList,String[] mTitle) {
        super(fm);
        this.mList = mList ;
        this.mTitle = mTitle;
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }

}
