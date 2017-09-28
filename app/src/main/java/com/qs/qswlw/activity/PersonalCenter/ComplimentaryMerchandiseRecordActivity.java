package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.ComplimentaryMerchandiseLeftFragment;
import com.qs.qswlw.fragment.ComplimentaryMerchandiseRightFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class ComplimentaryMerchandiseRecordActivity extends BaseInfoActivity {

    private RadioButton rb_complimentarymerchandise_left,rb_complimentarymerchandise_right;

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_complimentarymerchandise, null);
        rb_complimentarymerchandise_left = (RadioButton) inflate.findViewById(R.id.rb_complimentarymerchandise_left);
        rb_complimentarymerchandise_right = (RadioButton) inflate.findViewById(R.id.rb_complimentarymerchandise_right);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("选送商品记录");
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
        fragments.add(ComplimentaryMerchandiseLeftFragment.newInstance());
        fragments.add(ComplimentaryMerchandiseRightFragment.newInstance());
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
        rb_complimentarymerchandise_left.setOnClickListener(this);
        rb_complimentarymerchandise_right.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.rb_complimentarymerchandise_left:
                showFragment(fragments.get(0));

                break;
            case R.id.rb_complimentarymerchandise_right:
                showFragment(fragments.get(1));
                break;
        }

    }
}
