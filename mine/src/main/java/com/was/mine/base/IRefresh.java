package com.was.mine.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.was.mine.widget.recycler.RefreshAdapter;
import com.was.mine.widget.recycler.quick.BaseQuickAdapter;
import com.was.mine.widget.recycler.quick.BaseViewHolder;

import java.util.List;

/**
 * 刷新接口
 *
 * @param <T>
 * @param <K>
 */
public interface IRefresh<T, K extends BaseViewHolder> extends SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    void setView(RecyclerView recyclerView, SwipeRefreshLayout srhLayout);

    void start(boolean refresh);

    void initRecyclerView(RefreshAdapter<T, K> refreshAdapter, RecyclerView.ItemDecoration itemDecoration,
                          RecyclerView.OnItemTouchListener... onItemTouchListeners);


    void initView();  //初始化 adapter

    void requestData(boolean isRefresh); //请求数据

    void requestFail(boolean isRefresh, Throwable e); //数据加载失败

    void requestSuccess(List<T> datas, boolean isRefresh); //数据加载成功

}
