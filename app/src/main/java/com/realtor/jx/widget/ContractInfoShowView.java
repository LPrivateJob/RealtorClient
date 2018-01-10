package com.realtor.jx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtor.jx.R;

/**
 * description:
 * autour: lewish
 * created at: 2018/1/10 21:08
 */
public class ContractInfoShowView extends RelativeLayout {
    private Context mContext;
    private RelativeLayout mRlContractInfo;
    private RelativeLayout mRlRenterInfo;
    private RelativeLayout mRlAgingInfo;
    private TextView mTvContentContractNum;
    private TextView mTvContentName;
    private TextView mTvContentPhoneNum;
    private TextView mTvContentIDCardNum;
    private TextView mTvContentMonthlyRent;
    private TextView mTvContentLeaseFrom;
    private TextView mTvContentLeaseTo;
    private TextView mTvContentServiceFeeBear;
    private TextView mTvContentDownPaymentsMethod;
    private TextView mTvContentAccountNum;
    private TextView mTvContentRemarks;

    public ContractInfoShowView(Context context) {
        this(context, null);
    }

    public ContractInfoShowView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContractInfoShowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_contractinfo_view, this);
        initView(context);
    }

    private void initView(Context context) {
        mRlContractInfo = findViewById(R.id.mRlContractInfo);
        mRlRenterInfo = findViewById(R.id.mRlRenterInfo);
        mRlAgingInfo = findViewById(R.id.mRlAgingInfo);

        mTvContentContractNum = findViewById(R.id.mTvContentContractNum);

        mTvContentName = findViewById(R.id.mTvContentName);
        mTvContentPhoneNum = findViewById(R.id.mTvContentPhoneNum);
        mTvContentIDCardNum = findViewById(R.id.mTvContentIDCardNum);

        mTvContentMonthlyRent = findViewById(R.id.mTvContentMonthlyRent);
        mTvContentLeaseFrom = findViewById(R.id.mTvContentLeaseFrom);
        mTvContentLeaseTo = findViewById(R.id.mTvContentLeaseTo);
        mTvContentServiceFeeBear = findViewById(R.id.mTvContentServiceFeeBear);
        mTvContentDownPaymentsMethod = findViewById(R.id.mTvContentDownPaymentsMethod);
        mTvContentAccountNum = findViewById(R.id.mTvContentAccountNum);
        mTvContentRemarks = findViewById(R.id.mTvContentRemarks);
    }

    public void fillData() {

    }
}
