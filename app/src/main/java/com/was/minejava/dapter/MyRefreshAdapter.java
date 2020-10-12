package com.was.minejava.dapter;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.was.minejava.bean.ProvinceBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyRefreshAdapter extends RefreshAdapter<ProvinceBean, BaseViewHolder> {

    public MyRefreshAdapter(int layoutResId, List<ProvinceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ProvinceBean provinceBean) {

    }
}
