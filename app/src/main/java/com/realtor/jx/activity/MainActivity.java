package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.baseadapter.fragmentAdapter.CommonFragmentPagerAdapter;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.fragment.tab.TabContractFragment;
import com.realtor.jx.fragment.tab.TabMineFragment;
import com.realtor.jx.widget.BanSlideViewPager;
import com.realtor.jx.widget.BottomTabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: Home主页
 * autour: Tait
 * created at: 2018/1/6 14:42
 */
public class MainActivity extends BaseActivity {
    public enum TAB {
        TAB_CONTRACT, TAB_MINE
    }

    private BottomTabLayout mBottomTabLayout;
    private BanSlideViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> mTitles = Arrays.asList("合同", "我的");
    private TAB mSelectedTab;

    public static void open(BaseActivity activity, TAB tab) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_ENUM, tab);
        activity.startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle bundle = getIntent().getExtras();
        mSelectedTab = (TAB) bundle.getSerializable(Commons.BUNDLE_KEYS.EXTRA_ENUM);
        selectTab();
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();
        Bundle bundle = getIntent().getExtras();
        mSelectedTab = (TAB) bundle.getSerializable(Commons.BUNDLE_KEYS.EXTRA_ENUM);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBottomTabLayout = findViewById(R.id.mBottomTabLayout);
        mViewPager = findViewById(R.id.mViewPager);
        fragments.add(new TabContractFragment());
        fragments.add(new TabMineFragment());
        mViewPager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), fragments, mTitles));
        selectTab();
    }

    private void selectTab() {
        switch (mSelectedTab) {
            case TAB_CONTRACT:
                mViewPager.setCurrentItem(0);
                mBottomTabLayout.refreshUI(BottomTabLayout.SelectedTab.CONTRACT);
                break;
            case TAB_MINE:
                mViewPager.setCurrentItem(1);
                mBottomTabLayout.refreshUI(BottomTabLayout.SelectedTab.MINE);
                break;
        }
    }

    @Override
    protected void initListener() {
        mBottomTabLayout.setOnInteractListener(new BottomTabLayout.OnInteractListener() {
            @Override
            public void onContractTabSelect() {
                ifShowHideKeyboard();
                mViewPager.setCurrentItem(0);
            }

            @Override
            public void onMineTabSelect() {
                ifShowHideKeyboard();
                mViewPager.setCurrentItem(1);
            }

            @Override
            public void onNewTabClick() {
                ifShowHideKeyboard();
                CommitContractActivity.open(MainActivity.this, null);
            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

}
