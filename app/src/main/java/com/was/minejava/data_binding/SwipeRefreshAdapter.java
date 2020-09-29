package com.was.minejava.data_binding;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshAdapter {

    @BindingAdapter(value = {"setRefreshListener"}, requireAll = false)
    public static void setOnRefreshListener(SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {

        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
    }
}
