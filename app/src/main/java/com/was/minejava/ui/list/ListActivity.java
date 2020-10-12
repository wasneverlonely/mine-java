package com.was.minejava.ui.list;


import androidx.lifecycle.Observer;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.core.common.http.NetState;
import com.was.minejava.base.BaseActivity;
import com.was.core.utils.ToastUtils;
import com.was.minejava.BR;
import com.was.minejava.R;
import com.was.minejava.bean.ProvinceBean;
import com.was.minejava.dapter.ListActivityAdapter;

import java.util.List;

public class ListActivity extends BaseActivity {

    ListViewModel mListModel;

    @Override
    protected void initViewModel() {
        mListModel = new ListViewModel();

        mListModel.listRequest.getData().observe(this, new Observer<NetState<List<ProvinceBean>>>() {
            @Override
            public void onChanged(NetState<List<ProvinceBean>> state) {
                if (state.isSuccess()) {
                    mListModel.list.postValue(state.getData());
                } else {
                    ToastUtils.showShort(state.getMessage());
                }
            }
        });

        mListModel.listRequest.lookProvince();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_list, BR.vm, mListModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new ListActivityAdapter(this));
    }


    public class ClickProxy {
        public void click() {

        }
    }
}