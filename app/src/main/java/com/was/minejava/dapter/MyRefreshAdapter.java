package com.was.minejava.dapter;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.was.minejava.data.model.Province;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyRefreshAdapter extends RefreshAdapter<Province, BaseViewHolder> {

    public MyRefreshAdapter(int layoutResId, List<Province> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Province provinceBean) {

    }
}
