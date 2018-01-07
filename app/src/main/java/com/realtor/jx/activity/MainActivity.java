package com.realtor.jx.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.baseadapter.fragmentAdapter.CommonFragmentPagerAdapter;
import com.realtor.jx.fragment.ContractListFragment;
import com.realtor.jx.widget.ContractListPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: Home主页
 * autour: lewish
 * created at: 2018/1/6 14:42
 */
public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private List<String> mTitles = Arrays.asList("全部", "逾期");
    private ContractListPagerIndicator mPagerIndicator;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        mPagerIndicator = findView(R.id.mPagerIndicator);
        mViewPager = findView(R.id.mViewPager);

        for (String mTitle : mTitles) {
            ContractListFragment contentFragment = ContractListFragment.newInstance(mTitle);
            fragments.add(contentFragment);
        }

        mViewPager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), fragments, mTitles));

        mPagerIndicator.setTabVisibleCount(mTitles.size());
        mPagerIndicator.setTabItemTitles(mTitles);
        mPagerIndicator.setUpWithViewPager(mViewPager, 0);
        mPagerIndicator.addOnPageChangeListener(new ContractListPagerIndicator.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 走新建合同流程
         */
        findViewById(R.id.mTvNew).setOnClickListener(v -> {

        });
        /**
         * 走到我的页面
         */
        findView(R.id.mTvMine).setOnClickListener(v -> {

        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
