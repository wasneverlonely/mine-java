package com.was.minejava.dapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.was.minejava.R;
import com.was.minejava.data.model.Province;
import com.was.minejava.databinding.ItemListBinding;

import org.jetbrains.annotations.NotNull;

public class CommonListAdapter extends BaseQuickAdapter<Province, BaseDataBindingHolder<ItemListBinding>> {

    public CommonListAdapter() {
        super(R.layout.item_list);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemListBinding> holder, Province provinceBean) {
        ItemListBinding itemBinding = holder.getDataBinding();
        if (itemBinding != null) {
            itemBinding.setData(provinceBean);
            itemBinding.executePendingBindings();
        }
    }
}


//
//public class ListActivityAdapter extends SimpleDataBindingAdapter<Province, ItemListBinding> {
//
//    public ListActivityAdapter(Context context) {
//
//        super(context, R.layout.item_list, new DiffUtil.ItemCallback<Province>() {
//            @Override
//            public boolean areItemsTheSame(@NonNull Province oldItem, @NonNull Province newItem) {
//                return oldItem.equals(newItem);
//            }
//
//            @Override
//            public boolean areContentsTheSame(@NonNull Province oldItem, @NonNull Province newItem) {
//                return oldItem.getCode().equals(newItem.getCode());
//            }
//        });
//        setOnItemClickListener(((item, position) -> {
//            ToastUtils.showShort("item  点击 ------> " + item.getName());
//        }));
//    }
//
//    @Override
//    protected void onBindItem(ItemListBinding binding, Province item, RecyclerView.ViewHolder holder) {
//        binding.setData(item);
//    }
//}
