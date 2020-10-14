package com.was.minejava.dapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.was.minejava.R;
import com.was.minejava.bean.ProvinceBean;
import com.was.minejava.databinding.ItemListBinding;

import org.jetbrains.annotations.NotNull;

public class CommonListAdapter extends BaseQuickAdapter<ProvinceBean, BaseDataBindingHolder<ItemListBinding>> {

    public CommonListAdapter() {
        super(R.layout.item_list);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemListBinding> holder, ProvinceBean provinceBean) {
        ItemListBinding itemBinding = holder.getDataBinding();
        if (itemBinding != null) {
            itemBinding.setData(provinceBean);
            itemBinding.executePendingBindings();
        }
    }
}


//
//public class ListActivityAdapter extends SimpleDataBindingAdapter<ProvinceBean, ItemListBinding> {
//
//    public ListActivityAdapter(Context context) {
//
//        super(context, R.layout.item_list, new DiffUtil.ItemCallback<ProvinceBean>() {
//            @Override
//            public boolean areItemsTheSame(@NonNull ProvinceBean oldItem, @NonNull ProvinceBean newItem) {
//                return oldItem.equals(newItem);
//            }
//
//            @Override
//            public boolean areContentsTheSame(@NonNull ProvinceBean oldItem, @NonNull ProvinceBean newItem) {
//                return oldItem.getCode().equals(newItem.getCode());
//            }
//        });
//        setOnItemClickListener(((item, position) -> {
//            ToastUtils.showShort("item  点击 ------> " + item.getName());
//        }));
//    }
//
//    @Override
//    protected void onBindItem(ItemListBinding binding, ProvinceBean item, RecyclerView.ViewHolder holder) {
//        binding.setData(item);
//    }
//}
