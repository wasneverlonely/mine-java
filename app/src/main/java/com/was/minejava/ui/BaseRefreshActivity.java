package com.was.minejava.ui;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.was.core.common.http.NetState;
import com.was.minejava.common.base.BaseActivity;
import com.was.minejava.dapter.BaseRefreshAdapter;
import com.was.minejava.ui.refresh.BaseRefreshViewModel;

import java.util.List;

public abstract class BaseRefreshActivity<T> extends BaseActivity {

    public BaseRefreshViewModel<T> mRefreshViewModel;
    public BaseRefreshAdapter mRefreshAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected abstract void refresh();

    protected abstract void loadMore();


    public void requestSuccess(List<T> datas, boolean isRefresh) {
        if (isRefresh) {
            mRefreshViewModel.list.setValue(datas);
            mRefreshViewModel.refreshing.set(false);
            mRefreshViewModel.isEnabledRefresh.set(true);
        } else {
            mRefreshViewModel.addData(datas);
            mRefreshViewModel.isEnabledRefresh.set(true);
        }
    }

    public void requestFail(NetState state, boolean isRefresh) {

        if (isRefresh) {
            mRefreshViewModel.refreshing.set(false);
            if (mRefreshViewModel != null) {
                mRefreshViewModel.isEnableLoadMore.set(true);
            }
        } else {
            mRefreshAdapter.getLoadMoreModule().loadMoreFail();
            mRefreshViewModel.isEnabledRefresh.set(true);
        }
    }


    public class Refresh implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            refresh();
        }
    }

    public class LoadMore implements OnLoadMoreListener {
        @Override
        public void onLoadMore() {
            loadMore();
        }
    }
}
