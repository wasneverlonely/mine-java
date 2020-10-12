package com.was.minejava.ui.refresh;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.core.ui.BaseActivity;
import com.was.minejava.BR;
import com.was.minejava.R;
import com.was.minejava.dapter.ListActivityAdapter;
import com.was.minejava.dapter.MyRefreshAdapter;

import java.util.List;

public class RefreshActivity extends BaseActivity implements OnLoadMoreListener {

    RefreshViewModel mRefreshModel;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSrhLayout;

    private int pageSize = 10;// 每页加载的条数
    private int pageIndex;// 加载下标

    MyRefreshAdapter adapter;

    //页码
    public int getPageIndex(boolean isRefresh) {
        return isRefresh ? pageIndex = 1 : ++pageIndex;
    }

    //获取一页个数
    public int getPageSize() {
        return pageSize;
    }

    @Override
    protected void initViewModel() {
        mRefreshModel = new RefreshViewModel();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {

        return new DataBindingConfig(R.layout.activity_refresh, BR.vm, mRefreshModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new ListActivityAdapter(this))
                .addBindingParam(BR.refreshListener, new Refresh());
    }


    //请求数据
    void requestData(boolean isRefresh) {

    }

    //开启加载动画

    public void requestRefreshing() {
        if (!mSrhLayout.isRefreshing()) {
            mSrhLayout.setRefreshing(true);
        }
        requestData(true);
    }


    //初始化下拉
    public void start(boolean request) {
//        mSrhLayout.setColorSchemeResources(colorSchemeResId);
//        mSrhLayout.setOnRefreshListener(this);
//        initView();
        if (request) {
            requestRefreshing();
        }
    }

    //请求成功
    public void requestSuccess(List datas, boolean isRefresh) {
        if (isRefresh) {
//            mRefreshAdapter.setNewData(datas);
            mSrhLayout.setRefreshing(false);
            mRecyclerView.scrollToPosition(0);
        } else {
//            mRefreshAdapter.addData(datas);
            mSrhLayout.setEnabled(true);
        }

    }

    public void requestFail(boolean isRefresh, Throwable e) {
        if (isRefresh) {
            mSrhLayout.setRefreshing(false);
//            if (mRefreshAdapter != null) {
//                mRefreshAdapter.getLoadMoreModule().setEnableLoadMore(true);
//            }
        } else {
//            mRefreshAdapter.getLoadMoreModule().loadMoreFail();
            mSrhLayout.setEnabled(true);
        }


    }


    @Override
    public void onLoadMore() {
        //下拉状态
        if (mSrhLayout.isRefreshing())
            mSrhLayout.setRefreshing(false);
        //禁止下拉
        mSrhLayout.setEnabled(false);
        requestData(false);
    }


    public class ClickProxy {
        public void click() {

        }
    }

    public class Refresh implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            //禁止下拉

        }
    }


}