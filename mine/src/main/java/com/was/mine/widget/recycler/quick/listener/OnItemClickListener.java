package com.was.mine.widget.recycler.quick.listener;

import android.view.View;

import com.was.mine.widget.recycler.quick.BaseQuickAdapter;


/**
 * Created by AllenCoder on 2016/8/03.
 * <p>
 * <p>
 * A convenience class to extend when you only want to OnItemClickListener for a subset
 * of all the SimpleClickListener. This implements all methods in the
 * {@link SimpleClickListener}
 */
public abstract class OnItemClickListener extends SimpleClickListener {


    @Override
    public void onItemClick(BaseQuickAdapter quickAdapter, View view, int position) {
        onSimpleItemClick(quickAdapter, view, position);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter quickAdapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter quickAdapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter quickAdapter, View view, int position) {

    }

    public abstract void onSimpleItemClick(BaseQuickAdapter quickAdapter, View view, int position);
}
