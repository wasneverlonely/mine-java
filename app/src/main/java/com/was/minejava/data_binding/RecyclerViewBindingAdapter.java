package com.was.minejava.data_binding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;

import java.util.List;

public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = {"adapter", "data", "onLoadMoreListener", "isEnableLoadMore", "autoScrollToTopWhenInsert", "autoScrollToBottomWhenInsert"}, requireAll = false)
    public static void bindList(RecyclerView recyclerView, BaseQuickAdapter adapter, List data, OnLoadMoreListener loadMore, boolean isEnableLoadMore,
                                boolean autoScrollToTopWhenInsert, boolean autoScrollToBottomWhenInsert) {
        if (recyclerView != null && data != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(adapter);

                adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                    @Override
                    public void onItemRangeInserted(int positionStart, int itemCount) {
                        if (autoScrollToTopWhenInsert) {
                            recyclerView.scrollToPosition(0);
                        } else if (autoScrollToBottomWhenInsert) {
                            recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount());
                        }
                    }
                });

                if (loadMore != null) {
                    adapter.getLoadMoreModule().setOnLoadMoreListener(loadMore);
                    adapter.getLoadMoreModule().setEnableLoadMore(isEnableLoadMore);
                }
            }
            adapter.setList(data);
        }
    }


    @BindingAdapter(value = {"notifyCurrentListChanged"})
    public static void notifyListChanged(RecyclerView recyclerView, boolean notify) {
        if (notify && recyclerView != null && recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
