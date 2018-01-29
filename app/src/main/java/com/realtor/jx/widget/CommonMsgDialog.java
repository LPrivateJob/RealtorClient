package com.realtor.jx.widget;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseDialogFragment;

/**
 * description:
 * autour: lewish
 * created at: 2018/1/29 20:39
*/

public class CommonMsgDialog extends BaseDialogFragment implements View.OnClickListener {
    private static final String TAG = "CommonMsgDialog";
    public enum DialogStyle{
        TIP,
        NOTICE
    }
    public static final String KEY_MSG = "msg";
    public static final String KEY_STYLE = "style";

    public static final String DEFAULT_TITLE_TXT = "提示";
    public static final String DEFAULT_CONFIRM_TXT = "确定";
    public static final String DEFAULT_CANCLE_TXT = "取消";
    public static final String DEFAULT_IKNOW_TXT = "我知道了";

    private DialogStyle mDialogStyle;
    private String mStrMsg;

    private TextView mTvTitle;
    private TextView mTvMsg;
    private TextView mTvConfirm;
    private TextView mTvCancle;

    private OnInteractListener mOnInteractListener;

    public static CommonMsgDialog newTip(String mStrMsg){
        CommonMsgDialog commonMsgDialog = new CommonMsgDialog();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MSG,mStrMsg);
        bundle.putSerializable(KEY_STYLE,DialogStyle.TIP);
        commonMsgDialog.setArguments(bundle);
        return commonMsgDialog;
    }

    public static CommonMsgDialog newNotice(String mStrMsg){
        CommonMsgDialog commonMsgDialog = new CommonMsgDialog();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MSG,mStrMsg);
        bundle.putSerializable(KEY_STYLE,DialogStyle.NOTICE);
        commonMsgDialog.setArguments(bundle);
        return commonMsgDialog;
    }

    @Override
    protected void getIncomingValue() {
        Bundle bundle = getArguments();
        mStrMsg = bundle.getString(KEY_MSG);
        mDialogStyle = (DialogStyle) bundle.getSerializable(KEY_STYLE);
    }

    @Override
    protected void initViewAndSetListener() {
        mTvTitle = findViewById(R.id.mTvTitle);
        mTvMsg = findViewById(R.id.mTvMsg);
        mTvConfirm = findViewById(R.id.mTvConfirm);
        mTvCancle = findViewById(R.id.mTvCancle);


        mTvConfirm.setOnClickListener(this);
        mTvCancle.setOnClickListener(this);

        mTvTitle.setText(DEFAULT_TITLE_TXT);
        mTvCancle.setText(DEFAULT_CANCLE_TXT);
        mTvMsg.setText(mStrMsg);

        if(mDialogStyle==DialogStyle.TIP) {
            mTvCancle.setVisibility(View.GONE);
            mTvConfirm.setText(DEFAULT_IKNOW_TXT);
        }else if(mDialogStyle == DialogStyle.NOTICE) {
            mTvCancle.setVisibility(View.VISIBLE);
            mTvConfirm.setText(DEFAULT_CONFIRM_TXT);
        }

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.dialog_common_msg;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mTvConfirm :
                if(mOnInteractListener!=null) {
                    dismiss();
                    mOnInteractListener.onClick(true);
                }
                break;
            case R.id.mTvCancle:
                if(mOnInteractListener!=null) {
                    dismiss();
                    mOnInteractListener.onClick(false);
                }
                break;
        }
    }

    public CommonMsgDialog onInteractListener(OnInteractListener onInteractListener) {
        this.mOnInteractListener = onInteractListener;
        return this;
    }

    public interface OnInteractListener{
        void onClick(boolean flag);
    }

    public void show(FragmentManager manager) {
        super.show(manager, TAG);
    }
}
