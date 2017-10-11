package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.CommodityManagementFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class CommodityManagementActivity extends BaseInfoActivity {

    private RadioButton rb_onSale;
    private RadioButton rb_underTheShelf;
    private TextView tv_add;
    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_commoditymanagement, null);
        rb_onSale = (RadioButton) inflate.findViewById(R.id.rb_onSale);
        rb_underTheShelf = (RadioButton) inflate.findViewById(R.id.rb_underTheShelf);
        tv_add = (TextView) inflate.findViewById(R.id.tv_add);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商品管理");
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
        fragments.add(CommodityManagementFragment.newInstance());
        fragments.add(CommodityManagementFragment.newInstance());
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
        rb_onSale.setOnClickListener(this);
        rb_underTheShelf.setOnClickListener(this);
        tv_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rb_onSale:
                showFragment(fragments.get(0));
                break;
            case R.id.rb_underTheShelf:
                showFragment(fragments.get(1));
                break;
            case R.id.tv_add:
                Intent intent = new Intent(this,AddProductActivity.class);
                startActivity(intent);
                break;
        }

    }

}
