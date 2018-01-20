package com.realtor.jx.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.realtor.jx.R;
import com.realtor.jx.adapter.ContractListAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.DividerItemDecoration;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.OnItemClickListener;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.OrderListDto;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.entity.ContractListItemData;
import com.realtor.jx.entity.FakeData;
import com.realtor.jx.fragment.tab.TabContractFragment;
import com.realtor.jx.netcore.JsonUiCallback;
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
        mContractListAdapter.setOnItemClickListener(new OnItemClickListener<OrderListDto.OrdersBean>() {

            @Override
            public void onItemClick(ViewGroup parent, View view, OrderListDto.OrdersBean ordersBean, int position) {
                int status = ordersBean.getStatus();
                switch (status) {
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_APPLYING :
                        break;
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_WAITMODIFY :
                        //待修改->待修改页面
                        break;
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_WAITREVIEW :
                        //待审核->修改订单流程
                        break;
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_WAITSCANQRCODE :
                        //待扫码->扫码页
                        break;
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_INREVIEW :
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_INREPAYMENT:
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_SETTLED:
                        //审核中、还款中、已结清->详情页
                        break;
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_RENEGE:
                        //已违约->提示暂不可点击
                        break;
                    case Commons.CONTRACT_STATUS.CONTRACT_STATE_REJECT:
                        //审核拒绝->提示被拒绝原因
                        break;
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, OrderListDto.OrdersBean ordersBean, int position) {
                return false;
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
        invokeInterface();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mContractListAdapter.loadMoreData(FakeData.getInstance().getContractList());
//                mRefreshLayout.finishLoadmore();
//            }
//        }, 2000);

    }

    private void invokeInterface() {
        // TODO: 2018/1/7  调接口
        AppDAO.getInstance().queryOrderList(null, getOrderStatus(), ""+mOrderType, ""+mPage, ""+10, new JsonUiCallback<OrderListDto>(mActivity) {
            @Override
            public void onSuccess(OrderListDto result) {
//                if (mPage == 1) {
//                    if(result.getOrders()==null||result.getOrders().size()==0) {
//
//                    }
//                    .refreshData(userLoanListDto.getData());
//                    mSmartRefreshLayout.finishRefresh();
//                } else if (result.getOrders()==null||result.getOrders().size()==0) {
//                    snackyTip("暂无更多数据");
//                    mPage = userLoanListDto.getTotalPages();
//                    mSmartRefreshLayout.finishLoadmore();
//                } else {
//                    repaymentListAdapter.loadMoreData(userLoanListDto.getData());
//                    mSmartRefreshLayout.finishLoadmore();
//                }
            }

            @Override
            public void onBizFailed(String resultCode, String resultInfo) {
                super.onBizFailed(resultCode, resultInfo);
            }

            @Override
            public void onConnectionFailed() {
                super.onConnectionFailed();
            }
        });
    }

    public void refreshData() {
        mPage = 1;
        mRecView.scrollToPosition(0);
        invokeInterface();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mContractListAdapter.refreshData(FakeData.getInstance().getContractList());
//                mRefreshLayout.finishRefresh();
//            }
//        }, 2000);
    }

    public String getOrderStatus(){
        Integer orderStatus = ((TabContractFragment) getParentFragment()).getOrderStatus();
        if(orderStatus!=null) {
            return orderStatus.toString();
        }else {
            return null;
        }

    }
}
