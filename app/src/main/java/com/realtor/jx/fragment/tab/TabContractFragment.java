package com.realtor.jx.fragment.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;

import com.realtor.jx.R;
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
    private Integer mOrderStatus;
    private String mStrSearchKeyWords="";
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

        //DrawerLayout关闭手势滑动
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //ViewPager初始化
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
                //只有全部时可对合同列表进行按状态筛选
                mIvFilter.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
                ((ContractListFragment)fragments.get(0)).refreshData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initListener() {
        mSearchBar.setOnInteractListener(content -> {
            mStrSearchKeyWords = content;
            ((ContractListFragment)fragments.get(mViewPager.getCurrentItem())).refreshData();
        });
        mIvFilter.setOnClickListener(v -> {
            mActivity.ifShowHideKeyboard();
            if (mDrawerLayout.isDrawerOpen(mSlidingMenu)) {
                mDrawerLayout.closeDrawers();
            } else {
                mDrawerLayout.openDrawer(GravityCompat.END);
            }
        });
        mSlidingMenu.setOnInteractListener(new SlidingMenu.OnInteractListener() {
            @Override
            public void onChecked(Integer filterContractStateCode) {
                mDrawerLayout.closeDrawers();
                mOrderStatus = filterContractStateCode;
                ((ContractListFragment)fragments.get(0)).refreshData();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tab_contract;
    }

    public Integer getOrderStatus() {
        return mOrderStatus;
    }

    public String getSearchKeyWords(){
        return mStrSearchKeyWords;
    }

}
