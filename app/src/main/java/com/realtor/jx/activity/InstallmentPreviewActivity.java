package com.realtor.jx.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.baseadapter.ViewHolder;
import com.realtor.jx.base.baseadapter.absListViewAdapter.AbsListViewAdapter;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.utils.NullUtil;

import java.io.Serializable;
import java.util.List;

/**
 * description: 分期预览页
 * autour: lewish
 * created at: 2018/1/6 14:42
 */
public class InstallmentPreviewActivity extends BaseActivity {
    private TextView mTvTitleRenterRepayAmount;
    private ListView mListViewRenter;
    private InstallmentPreviewAdapter mAdapter;
    private TextView mBtnNext;
    private int mRenterTotalAmount;
    private List<ContractDetailDto.InstalmentOrdersBean> mDataList;

    public static void open(BaseActivity activity, int totalAmount, List<ContractDetailDto.InstalmentOrdersBean> dataList) {
        Intent intent = new Intent(activity, InstallmentPreviewActivity.class);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTAR_INT, totalAmount);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_LIST, (Serializable) dataList);
        activity.startActivity(intent);
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();
        Bundle bundle = getIntent().getExtras();
        mRenterTotalAmount = bundle.getInt(Commons.BUNDLE_KEYS.EXTAR_INT);
        mDataList = (List<ContractDetailDto.InstalmentOrdersBean>) bundle.getSerializable(Commons.BUNDLE_KEYS.EXTRA_LIST);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvTitleRenterRepayAmount = findViewById(R.id.mTvTitleRenterRepayAmount);
        mListViewRenter = findViewById(R.id.mListViewRenter);
        mBtnNext = findViewById(R.id.mBtnNext);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtnNext.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        mTvTitleRenterRepayAmount.setText(Html.fromHtml(String.format("租户应还共计<font color=\"#d40000\">%s</font>元", NullUtil.convertFen2YuanStr(mRenterTotalAmount))));
        mListViewRenter.setAdapter(new InstallmentPreviewAdapter(this, R.layout.item_list_installmentpreview_renter, mDataList));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_installment_preview;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "请点击下一步上传照片", Toast.LENGTH_SHORT).show();
    }

    class InstallmentPreviewAdapter extends AbsListViewAdapter<ContractDetailDto.InstalmentOrdersBean> {

        public InstallmentPreviewAdapter(Context context, int layoutId, List<ContractDetailDto.InstalmentOrdersBean> datas) {
            super(context, layoutId, datas);
        }

        @Override
        public void convert(int position, ViewHolder holder, ContractDetailDto.InstalmentOrdersBean instalmentOrdersBean) {
            holder.setText(R.id.mTvRepayTerm, String.format("第%s期", instalmentOrdersBean.getTermNo()));
            holder.setText(R.id.mTvRepayDate, instalmentOrdersBean.getRepayDate());
            holder.setText(R.id.mTvRepayAmount, NullUtil.convertFen2YuanStr(instalmentOrdersBean.getTotalAmt()));
        }
    }
}
