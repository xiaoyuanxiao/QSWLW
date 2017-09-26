package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.MySpendingLimitDeductionFragment;
import com.qs.qswlw.fragment.MySpendingLimitGetFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class MySpendingLimitActivity extends BaseInfoActivity{

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
    private TextView tv_myspendinglimit_left,tv_myspendinglimit_right;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_myspendinglimit, null);
        tv_myspendinglimit_left = (TextView) inflate.findViewById(R.id.tv_myspendinglimit_left);
        tv_myspendinglimit_right = (TextView) inflate.findViewById(R.id.tv_myspendinglimit_right);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的消费额度");
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
        fragments.add(MySpendingLimitGetFragment.newInstance());
        fragments.add(MySpendingLimitDeductionFragment.newInstance());
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
        tv_myspendinglimit_left.setOnClickListener(this);
        tv_myspendinglimit_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_myspendinglimit_left:
                setTopColor(tv_myspendinglimit_left,tv_myspendinglimit_right);
                showFragment(fragments.get(0));

                break;
            case R.id.tv_myspendinglimit_right:
                setTopColor(tv_myspendinglimit_right,tv_myspendinglimit_left);
                showFragment(fragments.get(1));
                break;
        }
    }

    private void setTopColor(TextView tv,TextView tv1){
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv1.setBackgroundColor(getResources().getColor(R.color.white));
        tv.setTextColor(getResources().getColor(R.color.white));
        tv.setBackgroundColor(getResources().getColor(R.color.red));
    }


}
