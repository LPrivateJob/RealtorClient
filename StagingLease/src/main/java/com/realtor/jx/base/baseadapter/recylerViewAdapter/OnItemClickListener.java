package com.realtor.jx.base.baseadapter.recylerViewAdapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * description:
 * autour: Tait
 * created at 2017/4/24 14:20
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);

    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}