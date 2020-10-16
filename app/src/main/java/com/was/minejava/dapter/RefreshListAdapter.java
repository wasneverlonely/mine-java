package com.was.minejava.dapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.was.minejava.R;
import com.was.minejava.bean.SchoolUniformBean;
import com.was.minejava.databinding.ItemRefreshBinding;

import org.jetbrains.annotations.NotNull;


public class RefreshListAdapter extends BaseRefreshAdapter<SchoolUniformBean, BaseDataBindingHolder<ItemRefreshBinding>> {

    public RefreshListAdapter() {
        super(R.layout.item_refresh);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemRefreshBinding> holder, SchoolUniformBean bean) {
        ItemRefreshBinding itemBinding = holder.getDataBinding();
        if (itemBinding != null) {
            itemBinding.setData(bean);
            itemBinding.executePendingBindings();
        }
    }
}
//
//public class RefreshListAdapter extends BaseQuickAdapter<SchoolUniformBean, BaseDataBindingHolder<ItemRefreshBinding>>
//        {
//
//    public RefreshListAdapter() {
//        super(R.layout.item_refresh);
//    }
//
//    @Override
//    protected void convert(@NotNull BaseDataBindingHolder<ItemRefreshBinding> holder, SchoolUniformBean bean) {
//        ItemRefreshBinding itemBinding = holder.getDataBinding();
//        if (itemBinding != null) {
//            itemBinding.setData(bean);
//            itemBinding.executePendingBindings();
//        }
//    }
//}

