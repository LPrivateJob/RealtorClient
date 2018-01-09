package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.baseadapter.fragmentAdapter.CommonFragmentPagerAdapter;
import com.realtor.jx.fragment.ContractListFragment;
import com.realtor.jx.widget.ContractListPagerIndicator;
import com.realtor.jx.widget.SearchBar;
import com.realtor.jx.widget.SlidingMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: Home主页
 * autour: lewish
 * created at: 2018/1/6 14:42
 */
public class MainActivity extends BaseActivity {
    private SearchBar mSearchBar;
    private ImageView mIvFilter;
    private DrawerLayout mDrawerLayout;
    private SlidingMenu mSlidingMenu;
    private ViewPager mViewPager;
    private List<String> mTitles = Arrays.asList("全部", "逾期");
    private ContractListPagerIndicator mPagerIndicator;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        mSearchBar = findView(R.id.mSearchBar);
        mIvFilter = findViewById(R.id.mIvFilter);
        mDrawerLayout = findViewById(R.id.mDrawerLayout);
        mSlidingMenu = findViewById(R.id.mSlidingMenu);
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
        mIvFilter.setOnClickListener(v -> {
            if (mDrawerLayout.isDrawerOpen(mSlidingMenu)) {
                mDrawerLayout.closeDrawers();
            } else {
                mDrawerLayout.openDrawer(GravityCompat.END);
            }
        });
        mSlidingMenu.setOnInteractListener(new SlidingMenu.OnInteractListener() {
            @Override
            public void onChecked(int filterContractStateCode) {
                mDrawerLayout.closeDrawers();
                Toast.makeText(MainActivity.this, "" + filterContractStateCode, Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 走新建合同流程
         */
        findViewById(R.id.mTvNew).setOnClickListener(v -> {
            startActivity(new Intent(this, CommitContractActivity.class));
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
