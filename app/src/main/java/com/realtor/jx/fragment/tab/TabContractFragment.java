package com.realtor.jx.fragment.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.activity.MainActivity;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.base.baseadapter.fragmentAdapter.CommonFragmentPagerAdapter;
import com.realtor.jx.fragment.ContractListFragment;
import com.realtor.jx.widget.ContractListPagerIndicator;
import com.realtor.jx.widget.SearchBar;
import com.realtor.jx.widget.SlidingMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 合同Tab
 * autour: lewish
 * created at: 2018/1/9 23:00
 */

public class TabContractFragment extends BaseFragment {
    private SearchBar mSearchBar;
    private ImageView mIvFilter;
    private DrawerLayout mDrawerLayout;
    private SlidingMenu mSlidingMenu;
    private ViewPager mViewPager;
    private List<String> mTitles = Arrays.asList("全部", "逾期");
    private ContractListPagerIndicator mPagerIndicator;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mSearchBar = findViewById(R.id.mSearchBar);
        mIvFilter = findViewById(R.id.mIvFilter);
        mDrawerLayout = findViewById(R.id.mDrawerLayout);
        mSlidingMenu = findViewById(R.id.mSlidingMenu);
        mPagerIndicator = findViewById(R.id.mPagerIndicator);
        mViewPager = findViewById(R.id.mViewPager);

        for (String mTitle : mTitles) {
            ContractListFragment contentFragment = ContractListFragment.newInstance(mTitle);
            fragments.add(contentFragment);
        }

        mViewPager.setAdapter(new CommonFragmentPagerAdapter(getChildFragmentManager(), fragments, mTitles));

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
                Toast.makeText(mActivity, "" + filterContractStateCode, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tab_contract;
    }
}
