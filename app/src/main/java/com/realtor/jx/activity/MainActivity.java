package com.realtor.jx.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.baseadapter.fragmentAdapter.CommonFragmentPagerAdapter;
import com.realtor.jx.fragment.tab.TabContractFragment;
import com.realtor.jx.fragment.tab.TabMineFragment;
import com.realtor.jx.widget.BanSlideViewPager;
import com.realtor.jx.widget.BottomTabLayout;
import com.realtor.jx.widget.CommitContractStepIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: Home主页
 * autour: lewish
 * created at: 2018/1/6 14:42
 */
public class MainActivity extends BaseActivity {
    private BottomTabLayout mBottomTabLayout;
    private BanSlideViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> mTitles = Arrays.asList("合同", "我的");

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBottomTabLayout = findViewById(R.id.mBottomTabLayout);
        mViewPager = findViewById(R.id.mViewPager);
        fragments.add(new TabContractFragment());
        fragments.add(new TabMineFragment());
        mViewPager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), fragments, mTitles));
    }

    @Override
    protected void initListener() {
        mBottomTabLayout.setOnInteractListener(new BottomTabLayout.OnInteractListener() {
            @Override
            public void onContractTabSelect() {
                Toast.makeText(MainActivity.this, "onContractTabSelect", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(0);
            }

            @Override
            public void onMineTabSelect() {
                Toast.makeText(MainActivity.this, "onMineTabSelect", Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(1);
            }

            @Override
            public void onNewTabClick() {
                CommitContractActivity.open(MainActivity.this, CommitContractStepIndicator.STEP.LOCATION);
            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
