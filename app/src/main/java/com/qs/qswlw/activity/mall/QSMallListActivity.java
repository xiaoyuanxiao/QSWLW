package com.qs.qswlw.activity.mall;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.fragment.QSMalListNewFragment;
import com.qs.qswlw.fragment.QSMallListCommentFragment;
import com.qs.qswlw.fragment.QSMallListPriceFragment;
import com.qs.qswlw.fragment.QSMallListSalesVolumeFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMallListActivity extends BaseActivity {

    private LinearLayout ll_container;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private TabLayout tabLayout;
    private MyPagerAdapter myPagerAdapter;
    private TextView tv;

    @Override
    public Object initView() {
        return R.layout.activity_qsmalllist;
    }

    @Override
    public void initfindviewByid() {
        ll_container = (LinearLayout) findViewById(R.id.ll_container);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


    }

    @Override
    public void initData() {
        super.initData();
        fragmentManager = getSupportFragmentManager();
        initFragment();
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.red));
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        initTab();
    }

    private void initTab() {
        tabLayout.addTab(tabLayout.newTab().setText("最新"));
        tabLayout.addTab(tabLayout.newTab().setText("销量"));
        tabLayout.addTab(tabLayout.newTab().setText("评论"));
        tabLayout.addTab(tabLayout.newTab().setCustomView(tab_icon("价格",R.mipmap.user_icon)));
    }

    private View tab_icon(String name,int iconID){
        View newtab =  LayoutInflater.from(this).inflate(R.layout.tablayout,null);
        tv = (TextView) newtab.findViewById(R.id.tv_tab);
        tv.setText(name);
        ImageView im = (ImageView)newtab.findViewById(R.id.iv_tab);
        im.setImageResource(iconID);
        return newtab;
    }

    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(QSMalListNewFragment.newInstance());
        fragments.add(QSMallListCommentFragment.newInstance());
        fragments.add(QSMallListSalesVolumeFragment.newInstance());
        fragments.add(QSMallListPriceFragment.newInstance());
        showFragment(fragments.get(0));

    }
    /**
     * 显示fragment
     *
     * @param fragment 要显示的fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.ll_container, fragment, fragment.getClass().getName());
        }
        transaction.commit();
    }

    /**
     * 隐藏其他fragment
     *
     * @param transaction 控制器
     */
    private void hideFragment(FragmentTransaction transaction) {
        for (int i = 0; fragments.size() > i; i++) {
            if (fragments.get(i).isVisible()) {
                transaction.hide(fragments.get(i));
            }
        }
    }


    @Override
    public void setOnclick() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override

            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment fragment = (Fragment)myPagerAdapter.instantiateItem(ll_container, position);

                myPagerAdapter.setPrimaryItem(ll_container, position, fragment);

                if(position==2){
                    tv.setTextColor(getResources().getColor(R.color.red));
                }
                myPagerAdapter.finishUpdate(ll_container);
            }

            @Override

            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override

            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }

    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        public MyPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new QSMalListNewFragment();
                case 1:
                    return new QSMallListCommentFragment();
                case 2:
                    return new QSMallListPriceFragment();
                case 3:
                    return new QSMallListSalesVolumeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
