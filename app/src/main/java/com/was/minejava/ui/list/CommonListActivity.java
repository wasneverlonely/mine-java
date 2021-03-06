package com.was.minejava.ui.list;


import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.minejava.common.base.BaseActivity;
import com.was.core.utils.ToastUtils;
import com.was.minejava.BR;
import com.was.minejava.R;
import com.was.minejava.dapter.CommonListAdapter;
import com.was.minejava.utils.InjectorUtil;


public class CommonListActivity extends BaseActivity {

    CommonListViewModel mCommonListModel;

    @Override
    protected void initView() {
        setBack();
        setTitleText("普通列表");
    }


    @Override
    protected void initViewModel() {
        mCommonListModel = new CommonListViewModel(InjectorUtil.getPlaceRepository());

        mCommonListModel.getProvinceList();
//        mCommonListModel.listRequest.getData().observe(this, (state) -> {
//            if (state.isSuccess()) {
//                mCommonListModel.list.postValue(state.getData());
//            } else {
//                ToastUtils.showShort(state.getMessage());
//            }
//        });

//        mCommonListModel.listRequest.lookProvince();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_common_list, BR.vm, mCommonListModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new CommonListAdapter());

        //.addBindingParam(BR.gridLayoutManager, new GridLayoutManager(this, 2))
    }


    public class ClickProxy {
        public void click() {

        }
    }
}