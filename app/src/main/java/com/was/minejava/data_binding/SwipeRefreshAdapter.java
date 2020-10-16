package com.was.minejava.data_binding;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshAdapter {

    @BindingAdapter(value = {"refreshing", "isEnabledRefresh", "setRefreshListener"}, requireAll = false)
    public static void setOnRefreshListener(SwipeRefreshLayout swipeRefreshLayout, boolean refreshing, boolean isEnabledRefresh, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {

        if (swipeRefreshLayout != null) {

            swipeRefreshLayout.setRefreshing(refreshing);
            swipeRefreshLayout.setEnabled(isEnabledRefresh);
            swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        }
    }


}
