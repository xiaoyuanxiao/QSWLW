package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.BusinessTurnoverFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class BusinessTurnoverActivity extends BaseInfoActivity {


    private TextView tv_businessturnover_left, tv_businessturnover_right;
    private View view_turnover_left, view_turnover_right;

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_businessturnover, null);
        tv_businessturnover_left = (TextView) inflate.findViewById(R.id.tv_businessturnover_left);
        tv_businessturnover_right = (TextView) inflate.findViewById(R.id.tv_businessturnover_right);
        view_turnover_left = inflate.findViewById(R.id.view_turnover_left);
        view_turnover_right = inflate.findViewById(R.id.view_turnover_right);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商家营业额");
    }

    @Override
    public void initData() {
        super.initData();
        fragmentManager = getSupportFragmentManager();
        initFragment();
    }

    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(BusinessTurnoverFragment.newInstance(BusinessTurnoverFragment.ISHISTORY));
        fragments.add(BusinessTurnoverFragment.newInstance(BusinessTurnoverFragment.HISTORY));
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
        super.setOnclick();
        tv_businessturnover_left.setOnClickListener(this);
        tv_businessturnover_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_businessturnover_left:
                setTopColor(tv_businessturnover_left, tv_businessturnover_right, view_turnover_left, view_turnover_right);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_businessturnover_right:
                setTopColor(tv_businessturnover_right, tv_businessturnover_left, view_turnover_right, view_turnover_left);
                showFragment(fragments.get(1));
                break;
        }
    }

    private void setTopColor(TextView tv, TextView tv1, View view, View view1) {
        tv.setTextColor(this.getResources().getColor(R.color.red));
        tv1.setTextColor(this.getResources().getColor(R.color.view));
        view.setBackgroundColor(this.getResources().getColor(R.color.red));
        view1.setBackgroundColor(this.getResources().getColor(R.color.view));
    }


}
