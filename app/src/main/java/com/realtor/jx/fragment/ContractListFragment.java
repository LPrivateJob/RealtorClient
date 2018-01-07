package com.realtor.jx.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;


/**
 * description: 合同列表页Fragment
 * autour: lewish
 * created at: 2018/1/7 15:12
 */
public class ContractListFragment extends BaseFragment {
    private String content;
    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecView;

    public static ContractListFragment newInstance(String mStrContractType) {
        ContractListFragment instance = new ContractListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Tab", mStrContractType);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected void getIncomingValue() {
        super.getIncomingValue();
        content = getArguments().getString("Tab");
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mRecView = findViewById(R.id.mRecView);
        mRefreshLayout = findViewById(R.id.mRefreshLayout);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                Toast.makeText(mActivity, "onLoadmore", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                Toast.makeText(mActivity, "onRefresh", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_contractlist;
    }
}
