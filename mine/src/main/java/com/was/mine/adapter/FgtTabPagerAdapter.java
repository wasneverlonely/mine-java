package com.was.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * viewPager
 * 不销毁adapter
 */
public class FgtTabPagerAdapter extends FgtPagerAdapter {

    String[] titles;

    public FgtTabPagerAdapter(FragmentManager fm, List<Fragment> frgList, String[] titles) {
        this(fm, frgList, titles, true);
    }

    public FgtTabPagerAdapter(FragmentManager fm, List<Fragment> frgList, String[] titles, boolean destroy) {
        super(fm, frgList, destroy);
        this.titles = titles;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null) {
            return titles[position];
        }
        return super.getPageTitle(position);
    }
}
