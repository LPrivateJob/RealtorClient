package com.realtor.jx.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.realtor.jx.R;
import com.realtor.jx.adapter.ContractListAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.DividerItemDecoration;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.entity.ContractListItemData;
import com.realtor.jx.entity.FakeData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;


/**
 * description: 合同列表页Fragment
 * autour: lewish
 * created at: 2018/1/7 15:12
 */
public class ContractListFragment extends BaseFragment {
    private int mOrderType = 0;
    private int mPage;
    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecView;
    private ContractListAdapter mContractListAdapter;
    private List<ContractListItemData> mDatas = new ArrayList<>();

    public static ContractListFragment newInstance(String mStrContractType) {
        ContractListFragment instance = new ContractListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Commons.BUNDLE_KEYS.EXTRA_CONTENT, mStrContractType);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected void getIncomingValue() {
        super.getIncomingValue();
        switch (getArguments().getString(Commons.BUNDLE_KEYS.EXTRA_CONTENT)) {
            case "全部":
                mOrderType = Commons.CONTRACT_TYPE.ALL;
                break;
            case "逾期":
                mOrderType = Commons.CONTRACT_TYPE.OVERDUE;
                break;
        }
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mRecView = findViewById(R.id.mRecView);
        mRefreshLayout = findViewById(R.id.mRefreshLayout);

        mRecView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.ORIENTATION_HORIZONTAL, mActivity.getResources().getColor(R.color.white), 10));
        mContractListAdapter = new ContractListAdapter(mActivity, mDatas);
        mRecView.setAdapter(mContractListAdapter);
        mRecView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                loadMoreData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshData();
            }
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        refreshData();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_contractlist;
    }

    private void loadMoreData() {
        mPage++;
        mRecView.scrollToPosition(mContractListAdapter.getItemCount() - 1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mContractListAdapter.loadMoreData(FakeData.getInstance().getContractList());
                mRefreshLayout.finishLoadmore();
            }
        }, 2000);
        //加载更多债权
//        invokeInterface();
    }

    private void invokeInterface() {
        // TODO: 2018/1/7  调接口
//        AppDAO.getInstance().queryOrderList(null,);
    }

    public void refreshData() {
        mPage = 1;
        mRecView.scrollToPosition(0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mContractListAdapter.refreshData(FakeData.getInstance().getContractList());
                mRefreshLayout.finishRefresh();
            }
        }, 2000);

//        invokeInterface();
    }
}
