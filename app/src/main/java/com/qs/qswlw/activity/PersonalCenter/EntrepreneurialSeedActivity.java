package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.EntrepreneurialIncentiveFragment;
import com.qs.qswlw.fragment.InnovationIncentiveFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class EntrepreneurialSeedActivity extends BaseInfoActivity {
    private LinearLayout ll_EntrepreneurialSeed;
    private View view_entrepreneurial,view_innovate;
    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
    private TextView tv_entrepreneurial,tv_innovate;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_entrepreneurialseed, null);
        ll_EntrepreneurialSeed = (LinearLayout) inflate.findViewById(R.id.ll_EntrepreneurialSeed);
        tv_entrepreneurial = (TextView) inflate.findViewById(R.id.tv_entrepreneurial);
        tv_innovate = (TextView) inflate.findViewById(R.id.tv_innovate);
        view_entrepreneurial = (View) inflate.findViewById(R.id.view_entrepreneurial);
        view_innovate = (View) inflate.findViewById(R.id.view_innovate);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        fragmentManager = getSupportFragmentManager();
        initFragment();
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("创业种子");

    }

    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(EntrepreneurialIncentiveFragment.newInstener());
        fragments.add(InnovationIncentiveFragment.newInstener());
        showFragment(fragments.get(1));

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
        //点击radioButton切换到指定页面
        tv_entrepreneurial.setOnClickListener(this);
        tv_innovate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_entrepreneurial:
                view_entrepreneurial.setVisibility(View.VISIBLE);
                view_innovate.setVisibility(View.INVISIBLE);
                tv_entrepreneurial.setTextColor(getResources().getColor(R.color.red));
                tv_innovate.setTextColor(getResources().getColor(R.color.view));
                showFragment(fragments.get(0));
                break;
            case R.id.tv_innovate:
                view_entrepreneurial.setVisibility(View.INVISIBLE);
                view_innovate.setVisibility(View.VISIBLE);
                tv_entrepreneurial.setTextColor(getResources().getColor(R.color.view));
                tv_innovate.setTextColor(getResources().getColor(R.color.red));
                showFragment(fragments.get(1));
                break;
        }
    }
}



