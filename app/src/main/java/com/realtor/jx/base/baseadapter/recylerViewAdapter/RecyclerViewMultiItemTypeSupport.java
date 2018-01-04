package com.realtor.jx.base.baseadapter.recylerViewAdapter;

/**
 * author: sundong
 * created at 2017/4/24 14:21
 */
public interface RecyclerViewMultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}