package com.was.mine.base.tab;

import android.support.v4.view.ViewPager;

import com.was.mine.utils.Utils;

/**
 * 页面状态改变
 */
public class PageStateChangeListener implements ViewPager.OnPageChangeListener {

    PageStateChangeObservable mPageStateChangeObservable;

    int mCurrentPosition;

    public int getCurrentPosition() {
        return mCurrentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.mCurrentPosition = currentPosition;
    }

    public PageStateChangeListener(PageStateChangeObservable pageStateChangeObservable) {
        this.mPageStateChangeObservable = pageStateChangeObservable;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if (!Utils.isNull(mPageStateChangeObservable))
            mPageStateChangeObservable.notifyObserver(mCurrentPosition,
                    ITabPage.STATE_PAGE_SWITCH);
        mCurrentPosition = position;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
