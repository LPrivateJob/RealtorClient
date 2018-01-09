package com.realtor.jx.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtor.jx.R;

import static com.realtor.jx.widget.BottomTabLayout.SelectedTab.CONTRACT;
import static com.realtor.jx.widget.BottomTabLayout.SelectedTab.MINE;

/**
 * description: BottomTabLayout
 * autour: lewish
 * created at: 2018/1/9 23:56
 */

public class BottomTabLayout extends RelativeLayout implements View.OnClickListener {


    public enum SelectedTab {
        CONTRACT, MINE
    }

    private Context mContext;
    private TextView mTvContract;
    private TextView mTvMine;
    private TextView mTvNew;
    public SelectedTab mSelectedTab = CONTRACT;
    private OnInteractListener mOnInteractListener;

    public BottomTabLayout(Context context) {
        this(context, null);
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_bottom_tablayout, this);

        mTvContract = findViewById(R.id.mTvContract);
        mTvMine = findViewById(R.id.mTvMine);
        mTvNew = findViewById(R.id.mTvNew);
        mTvContract.setOnClickListener(this);
        mTvMine.setOnClickListener(this);
        mTvNew.setOnClickListener(this);

        refreshUI(CONTRACT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mTvContract:
                refreshUI(CONTRACT);
                if (mOnInteractListener != null)
                    mOnInteractListener.onContractTabSelect();
                break;
            case R.id.mTvMine:
                refreshUI(MINE);
                if (mOnInteractListener != null)
                    mOnInteractListener.onMineTabSelect();
                break;
            case R.id.mTvNew:
                if (mOnInteractListener != null)
                    mOnInteractListener.onNewTabClick();
                break;
        }
    }

    public void refreshUI(SelectedTab selectedTab) {
        switch (selectedTab) {
            case CONTRACT:
                mTvContract.setTextColor(Color.parseColor("#f5cc3f"));
                setTextViewDrawable(mTvContract, R.drawable.icon_bottom_contract_checked);
                mTvMine.setTextColor(Color.parseColor("#8c8c8c"));
                setTextViewDrawable(mTvMine, R.drawable.icon_bottom_mine_normal);
                break;
            case MINE:
                mTvContract.setTextColor(Color.parseColor("#8c8c8c"));
                setTextViewDrawable(mTvContract, R.drawable.icon_bottom_contract_normal);
                mTvMine.setTextColor(Color.parseColor("#f5cc3f"));
                setTextViewDrawable(mTvMine, R.drawable.icon_bottom_mine_checked);
                break;
        }
    }

    private void setTextViewDrawable(TextView textView, @DrawableRes int drawable) {
        Drawable nav_up = getResources().getDrawable(drawable);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        textView.setCompoundDrawables(null, nav_up, null, null);
    }

    public interface OnInteractListener {
        void onContractTabSelect();

        void onMineTabSelect();

        void onNewTabClick();
    }

    public void setOnInteractListener(OnInteractListener mOnInteractListener) {
        this.mOnInteractListener = mOnInteractListener;
    }
}
