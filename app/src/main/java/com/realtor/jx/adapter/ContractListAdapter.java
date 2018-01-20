package com.realtor.jx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.realtor.jx.R;
import com.realtor.jx.base.baseadapter.ViewHolder;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.RecyclerViewMultiItemAdapter;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.RecyclerViewMultiItemTypeSupport;
import com.realtor.jx.dto.OrderListDto;
import com.realtor.jx.utils.NullUtil;

import java.util.List;

/**
 * description: 合同列表适配器
 * autour: lewish
 * created at: 2018/1/7 16:09
*/
public class ContractListAdapter extends RecyclerViewMultiItemAdapter<OrderListDto.OrdersBean> {
    public ContractListAdapter(Context context, List datas) {
        super(context, datas, new RecyclerViewMultiItemTypeSupport<OrderListDto.OrdersBean>() {
            @Override
            public int getLayoutId(int itemType) {
                if(itemType==1) {
                    return R.layout.item_contractlist_overdue;
                }else {
                    return R.layout.item_contractlist_normal;
                }
            }

            @Override
            public int getItemViewType(int position, OrderListDto.OrdersBean ordersBean) {
                int status = ordersBean.getStatus();
                if(status==7) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, OrderListDto.OrdersBean ordersBean) {
        switch (holder.getLayoutId()) {
            case R.layout.item_contractlist_normal :
                holder.setText(R.id.mTvContentRenter, NullUtil.getString(ordersBean.getTenancyName()));
                holder.setText(R.id.mTvContentPhone,NullUtil.getString(ordersBean.getTenancyMobile()));
                //审核时间
//                holder.setText(R.id.mTvContentReviewingTime,)
                break;
            case R.layout.item_contractlist_overdue:
                holder.setText(R.id.mTvContentRenter, NullUtil.getString(ordersBean.getTenancyName()));
                holder.setText(R.id.mTvContentPhone,NullUtil.getString(ordersBean.getTenancyMobile()));
                //应还款日
//                holder.setText(R.id.mTvContentRepaymentDate,NullUtil.getString());
                break;
        }
    }
}
