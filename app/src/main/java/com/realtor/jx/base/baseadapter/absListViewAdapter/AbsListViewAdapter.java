package com.realtor.jx.base.baseadapter.absListViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.realtor.jx.base.baseadapter.ViewHolder;

import java.util.List;

/**
 * description:
 * autour: Tait
 * created at: 2016/11/24 16:31
 */
public abstract class AbsListViewAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId;

    public AbsListViewAdapter(Context context, int layoutId, List<T> datas) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
                layoutId, position);
        convert(position, holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(int position, ViewHolder holder, T t);

    /**
     * 向指定位置添加元素
     *
     * @param position
     * @param data
     */
    public void addDataByPosition(int position, T data) {
        if (data != null) {
            mDatas.add(position, data);
            notifyDataSetChanged();
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
            notifyDataSetChanged();
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
        int itemPreCount = getCount();
        mDatas.addAll(itemPreCount, datas);
        notifyDataSetChanged();
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

}
