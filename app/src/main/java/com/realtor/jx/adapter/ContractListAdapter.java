package com.realtor.jx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.realtor.jx.R;
import com.realtor.jx.base.baseadapter.ViewHolder;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.RecyclerViewMultiItemAdapter;
import com.realtor.jx.base.baseadapter.recylerViewAdapter.RecyclerViewMultiItemTypeSupport;

import java.util.List;

/**
 * description: 合同列表适配器
 * autour: lewish
 * created at: 2018/1/7 16:09
*/
public class ContractListAdapter extends RecyclerViewMultiItemAdapter {
    public ContractListAdapter(Context context, List datas) {
        super(context, datas, new RecyclerViewMultiItemTypeSupport() {
            @Override
            public int getLayoutId(int itemType) {
                return R.layout.item_contractlist_normal;
            }

            @Override
            public int getItemViewType(int position, Object o) {
                return 1;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, Object o) {

    }
}
