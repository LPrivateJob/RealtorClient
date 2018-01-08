package com.realtor.jx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.entity.Constants;
import com.realtor.jx.fragment.RenterInfoFragment;
import com.realtor.jx.widget.CommitContractStepIndicator;
import com.realtor.jx.widget.Header;

/**
 * description: 新建和修改合同页面
 * autour: lewish
 * created at: 2018/1/6 16:34
 */
public class CommitContractActivity extends BaseActivity {
    private Header mHeader;
    private CommitContractStepIndicator mStepIndicator;
    private FragmentManager mFragmentManager = getSupportFragmentManager();

    public static void open(Activity act, CommitContractStepIndicator.STEP step) {
        Intent intent = new Intent(act, CommitContractActivity.class);
        intent.putExtra(Constants.EXTRA_ENUM, step);
        act.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findView(R.id.mHeader);
        mStepIndicator = findView(R.id.mStepIndicator);
        addFragment(R.id.mFragmentLayout,new RenterInfoFragment());
    }

    @Override
    protected void initListener() {
        mHeader.setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {
                Toast.makeText(CommitContractActivity.this, "onBackClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick() {

            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_commit_contract;
    }

    //添加fragment
    protected void addFragment(int layoutId, BaseFragment fragment) {
        if (fragment != null) {
            if (mFragmentManager.findFragmentById(layoutId) != null) {
                //之前添加过
                mFragmentManager.beginTransaction()
                        .replace(layoutId, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commitAllowingStateLoss();
            } else {
                //之前未添加过
                mFragmentManager.beginTransaction()
                        .add(layoutId, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commitAllowingStateLoss();
            }

        }
    }

    //移除fragment
    protected void removeFragment() {
        if (mFragmentManager.getBackStackEntryCount() > 1) {
            mFragmentManager.popBackStack();
        } else {
            finish();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (mFragmentManager.getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
