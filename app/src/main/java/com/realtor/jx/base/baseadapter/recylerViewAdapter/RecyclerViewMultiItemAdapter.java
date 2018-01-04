package com.realtor.jx.base.baseadapter.recylerViewAdapter;

import android.content.Context;
import android.view.ViewGroup;

import com.realtor.jx.base.baseadapter.ViewHolder;

import java.util.List;

/**
 * author: sundong
 * created at 2017/4/24 14:21
 */
public abstract class RecyclerViewMultiItemAdapter<T> extends RecyclerViewAdapter<T> {

    protected RecyclerViewMultiItemTypeSupport<T> mRecyclerViewMultiItemTypeSupport;

    public RecyclerViewMultiItemAdapter(Context context, List<T> datas,
                                        RecyclerViewMultiItemTypeSupport<T> recyclerViewMultiItemTypeSupport) {
        super(context, -1, datas);
        mRecyclerViewMultiItemTypeSupport = recyclerViewMultiItemTypeSupport;

        if (mRecyclerViewMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mAbsListViewMultiItemTypeSupport can not be null.");
    }

    public RecyclerViewMultiItemAdapter(Context context,
                                        RecyclerViewMultiItemTypeSupport<T> recyclerViewMultiItemTypeSupport) {
        super(context, -1);
        mRecyclerViewMultiItemTypeSupport = recyclerViewMultiItemTypeSupport;

        if (mRecyclerViewMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mAbsListViewMultiItemTypeSupport can not be null.");
    }

    @Override
    public int getItemViewType(int position) {
        if (mRecyclerViewMultiItemTypeSupport != null)
            return mRecyclerViewMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mRecyclerViewMultiItemTypeSupport == null)
            return super.onCreateViewHolder(parent, viewType);

        int layoutId = mRecyclerViewMultiItemTypeSupport.getLayoutId(viewType);
        ViewHolder holder = ViewHolder.get(mContext, null, parent, layoutId, -1);
        setListener(parent, holder, viewType);
        return holder;
    }

}
