package com.realtor.jx.base.baseadapter.absListViewAdapter;

/**
 * description:
 * autour: Tait
 * created at: 2016/11/24 16:31
 */
public interface AbsListViewMultiItemTypeSupport<T> {
    /**
     * 得到布局Id
     */
    int getLayoutId(int position, T t);

    /**
     * 一共有多少种View?
     */
    int getViewTypeCount();

    /**
     * 得到Item的View的类型
     */
    int getItemViewType(int position, T t);
}