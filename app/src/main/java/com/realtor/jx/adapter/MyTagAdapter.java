package com.realtor.jx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagAdapter;

import java.util.List;

/**
 * description: MyTagAdapter
 * autour: lewish
 * created at: 2018/1/15 21:20
 */
public class MyTagAdapter extends TagAdapter<String> {
    private BaseActivity mActivity;
    private ViewGroup mViewGroup;

    public MyTagAdapter(List<String> datas, BaseActivity activity, ViewGroup root) {
        super(datas);
        mActivity = activity;
        mViewGroup = root;
        initialSelectedList(0);
    }

    @Override
    public View getView(FlowLayout parent, int position, String s) {
        TextView tv = (TextView) mActivity.getLayoutInflater().inflate(R.layout.widget_flowlayout_tv,
                mViewGroup, false);
        tv.setText(s);
        return tv;
    }

    public MyTagAdapter initialSelectedList(int... poses) {
        setSelectedList(poses);
        return this;
    }
}
