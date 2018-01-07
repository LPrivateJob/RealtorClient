package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;

import org.w3c.dom.Text;

/**
 * description: 合同列表页Fragment
 * autour: lewish
 * created at: 2018/1/7 15:12
 */
public class ContractListFragment extends BaseFragment {
    private String content;
    private TextView mTv1;
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
        mTv1 = findViewById(R.id.mTv1);
        mTv1.setText(content);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_contractlist;
    }
}
