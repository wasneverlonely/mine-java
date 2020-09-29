package com.was.minejava.ui.refresh;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.core.ui.BaseActivity;
import com.was.core.utils.ToastUtils;
import com.was.minejava.BR;
import com.was.minejava.R;
import com.was.minejava.dapter.ListActivityAdapter;

public class RefreshActivity extends BaseActivity {

    RefreshViewModel mRefreshModel;

    @Override
    protected void initViewModel() {
        mRefreshModel = new RefreshViewModel();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_refresh, BR.vm, mRefreshModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new ListActivityAdapter(this))
                .addBindingParam(BR.refreshListener, new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ToastUtils.showShort("下拉刷新!!!");
                    }
                });
    }


    public class ClickProxy {
        public void click() {

        }


    }

    public class Refresh implements SwipeRefreshLayout.OnRefreshListener {


        public void onRefresh() {

        }

//        SwipeRefreshLayout swipeRefreshLayout;
//
//        void dd() {
//            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                @Override
//                public void onRefresh() {
//
//                }
//            });
//        }
    }


}