package com.realtor.jx.activity;

import android.content.DialogInterface;
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
                mViewPager.setCurrentItem(0);
            }

            @Override
            public void onMineTabSelect() {
                mViewPager.setCurrentItem(1);
            }

            @Override
            public void onNewTabClick() {
                showTip("这是一条提示", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
                    }
                });
//                CommitContractActivity.open(MainActivity.this, null);
            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
