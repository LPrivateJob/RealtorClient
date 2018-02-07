package com.realtor.jx.base.baseadapter.fragmentAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * description:
 * autour: Tait
 * created at: 2018/1/4 15:24
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mDataList;
    private List<String> mTitleList;

    public CommonFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> mDataList, List<String> mTitleList) {
        super(fm);
        this.mDataList = mDataList;
        this.mTitleList = mTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mTitleList == null ? super.getPageTitle(position) : mTitleList.get(position);
    }

    public void setTitleData(List<String> titleData) {
        mTitleList = titleData;
    }

    public List<String> getTitleList() {
        return mTitleList;
    }

    public void setData(List<Fragment> data) {
        this.mDataList = data;
        notifyDataSetChanged();
    }
}
