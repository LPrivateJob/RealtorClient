package com.realtor.jx.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: sundong
 * created at 2018/1/4 15:22
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        getIncomingValue();
        rootView = inflater.inflate(getLayoutResource(), container, false);
        initView(rootView, savedInstanceState);
        initListener();
        loadData();
        return rootView;
    }

    protected void loadData() {

    }

    protected abstract void initView(View rootView, Bundle savedInstanceState);

    protected void initListener() {
    }

    protected void getIncomingValue() {
    }

    protected <T extends View> T findViewById(int id) {
        return (T) rootView.findViewById(id);
    }

    protected abstract @LayoutRes
    int getLayoutResource();

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getContext(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }

    public void openSystemSetting() {
        Intent intent =  new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(intent);
    }
}
