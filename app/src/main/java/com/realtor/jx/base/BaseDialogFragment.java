package com.realtor.jx.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.realtor.jx.R;

/**
 * description:
 * autour: Tait
 * created at 2017/8/31 20:33
 */
public abstract class BaseDialogFragment extends DialogFragment {
    private static boolean isShow;
    protected Activity mActivity;
    protected View mRootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getIncomingValue();
        initWindow();
        mRootView = inflater.inflate(getLayoutResource(), container, false);
        onFragmentCreateView();
        initViewAndSetListener();
        loadData();
        return mRootView;
    }

    /**
     * 注意：Fragment需可见，才能生效
     */
    public void setCanceledOnTouchOutside(boolean cancel) {
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(cancel);
        }
    }

    protected abstract void loadData();

    protected void onFragmentCreateView() {

    }

    //默认Window居中，宽x640，高Wrap_Content
    protected void initWindow() {
        configWindow(Gravity.CENTER, (int) mActivity.getResources().getDimension(R.dimen.x640), ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    protected void configWindow(int gravity, int width, int height) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // 将Dialog显示到屏幕的中间
        window.setGravity(gravity);
        // 去掉Dialog本身的padding
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // 设置宽度为屏幕宽度
        layoutParams.width = width;
        layoutParams.height = height;
        window.setAttributes(layoutParams);
    }

    protected abstract void initViewAndSetListener();

    protected abstract void getIncomingValue();

    protected <T extends View> T findViewById(int id) {
        return (T) mRootView.findViewById(id);
    }

    protected abstract int getLayoutResource();

    @Override
    public void show(FragmentManager manager, String tag) {
        isShow = true;
        super.show(manager, tag);
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        isShow = true;
        return super.show(transaction, tag);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        isShow = false;
        super.onDismiss(dialog);
    }

    public boolean isDialogShowing() {
        return isShow;
    }

}
