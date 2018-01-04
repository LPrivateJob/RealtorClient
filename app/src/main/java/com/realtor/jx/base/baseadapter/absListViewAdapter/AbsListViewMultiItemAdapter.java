package com.realtor.jx.base.baseadapter.absListViewAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.realtor.jx.base.baseadapter.ViewHolder;

import java.util.List;

/**
 * author: sundong
 * created at 2016/11/24 16:31
 */
public abstract class AbsListViewMultiItemAdapter<T> extends AbsListViewAdapter<T> {

    protected AbsListViewMultiItemTypeSupport<T> mAbsListViewMultiItemTypeSupport;

    public AbsListViewMultiItemAdapter(Context context, List<T> datas,
                                       AbsListViewMultiItemTypeSupport<T> absListViewMultiItemTypeSupport) {
        super(context, -1, datas);
        mAbsListViewMultiItemTypeSupport = absListViewMultiItemTypeSupport;
        if (mAbsListViewMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mAbsListViewMultiItemTypeSupport can not be null.");
    }

    @Override
    public int getViewTypeCount() {
        if (mAbsListViewMultiItemTypeSupport != null)
            return mAbsListViewMultiItemTypeSupport.getViewTypeCount();
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (mAbsListViewMultiItemTypeSupport != null)
            return mAbsListViewMultiItemTypeSupport.getItemViewType(position,
                    mDatas.get(position));
        return super.getItemViewType(position);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mAbsListViewMultiItemTypeSupport == null)
            return super.getView(position, convertView, parent);

        int layoutId = mAbsListViewMultiItemTypeSupport.getLayoutId(position,
                getItem(position));
        ViewHolder viewHolder = ViewHolder.get(mContext, convertView, parent,
                layoutId, position);
        convert(position, viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }

}
