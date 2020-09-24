package com.was.mine.widget.roll;

import android.view.View;

/**
 * Created by Administrator on 2017/7/21.
 */
public class HintViewImp implements HintView {

    private View mContentView;// View 功能实现

    public View getContentView() {
        return mContentView;
    }

    public void setContentView(View contentView) {
        this.mContentView = contentView;
    }

    @Override
    public void initView(int length, int gravity) {

    }

    @Override
    public void setCurrent(int current) {

    }
}
