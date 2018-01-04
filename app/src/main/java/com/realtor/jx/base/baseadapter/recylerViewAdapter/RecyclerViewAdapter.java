package com.realtor.jx.base.baseadapter.recylerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realtor.jx.base.baseadapter.ViewHolder;

import java.util.List;

/**
 * author: sundong
 * created at 2017/4/24 14:21
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    protected OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public RecyclerViewAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    public RecyclerViewAdapter(Context context, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }


    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    mOnItemClickListener.onItemClick(parent, v, mDatas.get(position), position);
                }
            }
        });


        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get(position), position);
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 向指定位置添加元素
     *
     * @param position
     * @param data
     */
    public void addDataByPosition(int position, T data) {
        if (data != null) {
            mDatas.add(position, data);
            notifyItemInserted(position);
        }
    }

    /**
     * 删除指定位置元素
     *
     * @param position
     */
    public void delDataByPosition(int position) {
        if (position >= 0) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * 下拉刷新时用
     *
     * @param datas
     */
    public void refreshData(List<T> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 上拉加载时用
     *
     * @param datas
     */
    public void loadMoreData(List<T> datas) {
        int itemPreCount = getItemCount();
        mDatas.addAll(itemPreCount, datas);
        notifyItemRangeInserted(itemPreCount, datas.size());
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    public List getDatas() {
        return mDatas;
    }


}
