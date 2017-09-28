package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.MerchantAuditFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditActivity extends BaseInfoActivity{

    private TextView tv_merchantaudit_left,tv_merchantaudit_right;
    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;


    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_merchantaudit, null);
        tv_merchantaudit_left = (TextView) inflate.findViewById(R.id.tv_merchantaudit_left);
        tv_merchantaudit_right = (TextView) inflate.findViewById(R.id.tv_merchantaudit_right);
        return inflate;
    }
    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商家审核");
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
        fragments.add(MerchantAuditFragment.newInstance(MerchantAuditFragment.IS_OK));
        fragments.add(MerchantAuditFragment.newInstance(MerchantAuditFragment.NO_OK));
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
        tv_merchantaudit_left.setOnClickListener(this);
        tv_merchantaudit_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_merchantaudit_left:
                setTopColor(tv_merchantaudit_left,tv_merchantaudit_right);
                showFragment(fragments.get(0));

                break;
            case R.id.tv_merchantaudit_right:
                setTopColor(tv_merchantaudit_right,tv_merchantaudit_left);
                showFragment(fragments.get(1));
                break;
        }

    }
    private void setTopColor(TextView tv,TextView tv1){
        tv.setTextColor(this.getResources().getColor(R.color.white));
        tv.setBackgroundColor(this.getResources().getColor(R.color.red));
        tv1.setTextColor(this.getResources().getColor(R.color.red));
        tv1.setBackgroundColor(this.getResources().getColor(R.color.white));
    }


}
