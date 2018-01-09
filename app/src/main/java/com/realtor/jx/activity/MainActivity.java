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
import com.realtor.jx.widget.BottomTabLayout;
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
    private BottomTabLayout mBottomTabLayout;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBottomTabLayout = findViewById(R.id.mBottomTabLayout);
    }

    @Override
    protected void initListener() {
        mBottomTabLayout.setOnInteractListener(new BottomTabLayout.OnInteractListener() {
            @Override
            public void onContractTabSelect() {
                Toast.makeText(MainActivity.this, "onContractTabSelect", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMineTabSelect() {
                Toast.makeText(MainActivity.this, "onMineTabSelect", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNewTabClick() {
                startActivity(new Intent(MainActivity.this, CommitContractActivity.class));
            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
