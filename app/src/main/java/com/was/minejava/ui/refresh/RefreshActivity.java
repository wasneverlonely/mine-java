package com.was.minejava.ui.refresh;


import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.minejava.BR;
import com.was.minejava.R;
import com.was.minejava.dapter.RefreshListAdapter;
import com.was.minejava.ui.BaseRefreshActivity;


public class RefreshActivity extends BaseRefreshActivity {

    RefreshViewModel mRefreshModel;
    RefreshListAdapter adapter;

    @Override
    protected void initView() {
        setBack();
        setTitleText("刷新列表");
    }

    @Override
    protected void initViewModel() {
        mRefreshModel = new RefreshViewModel();
        mRefreshViewModel = mRefreshModel;

        adapter = new RefreshListAdapter();
        mRefreshAdapter = adapter;

        mRefreshModel.refreshRequest.getData().observe(this, (state) -> {
            if (state.isSuccess()) {
                requestSuccess(state.getData(), state.isRefresh());
            } else {
                requestFail(state, state.isRefresh());
            }
        });
        mRefreshModel.refreshRequest.start();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {

        return new DataBindingConfig(R.layout.activity_refresh, BR.vm, mRefreshModel)
                .addBindingParam(BR.adapter, adapter)
                .addBindingParam(BR.refreshListener, new BaseRefreshActivity.Refresh())
                .addBindingParam(BR.loadMoreListener, new BaseRefreshActivity.LoadMore());
    }


    @Override
    protected void refresh() {
        mRefreshModel.refreshRequest.start();
    }

    @Override
    protected void loadMore() {
        mRefreshModel.refreshRequest.requestData(false);
    }


}