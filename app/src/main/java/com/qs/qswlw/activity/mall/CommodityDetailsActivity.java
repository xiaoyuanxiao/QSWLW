package com.qs.qswlw.activity.mall;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.fragment.CommodityDetailsDetailFragment;
import com.qs.qswlw.fragment.CommodityDetailsEvaluateFragment;
import com.qs.qswlw.fragment.CommodityDetailsWareFragment;
import com.qs.qswlw.view.NoScrollViewPager;

import java.util.ArrayList;

import static com.qs.qswlw.R.id.continer;

/**
 * Created by xiaoyu on 2017/4/27.
 */

public class CommodityDetailsActivity extends BaseActivity {

    private TabLayout tabLayout;
    private NoScrollViewPager viewPager;
    private PageAdapter PageAdapter;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;

    @Override
    public Object initView() {
        return R.layout.activity_commoditydetails;
    }

    @Override
    public void initfindviewByid() {
        tabLayout= (TabLayout) findViewById(R.id.tabLayout_commodity);
        viewPager = (NoScrollViewPager) findViewById(continer);

    }

    @Override
    public void initData() {
        super.initData();
        fragmentManager = getSupportFragmentManager();
        initFragment();
        PageAdapter = new PageAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(PageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }


    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(CommodityDetailsWareFragment.newInstance());
        fragments.add(CommodityDetailsDetailFragment.newInstance());
        fragments.add(CommodityDetailsEvaluateFragment.newInstance());
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
            transaction.add(continer, fragment, fragment.getClass().getName());
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }

    }

    class PageAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[]{"商品", "详情", "评价"};
        private Context context;

        public PageAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new CommodityDetailsWareFragment();
                case 1:
                    return new CommodityDetailsDetailFragment();
                case 2:
                    return new CommodityDetailsEvaluateFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
