package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.MyMallLeftFragment;
import com.qs.qswlw.fragment.MyMallRightFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/10/13.
 */

public class MyMallActivity extends BaseInfoActivity {
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private TextView tv_mymall_left,tv_mymall_right;
    private View view_left,view_right;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mymall, null);
        tv_mymall_left = (TextView) inflate.findViewById(R.id.tv_mymall_left);
        tv_mymall_right = (TextView) inflate.findViewById(R.id.tv_mymall_right);
        view_left = inflate.findViewById(R.id.view_left);
        view_right = inflate.findViewById(R.id.view_right);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        RelativeLayout title = (RelativeLayout) findViewById(R.id.title);
        title.setVisibility(View.GONE);
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
        fragments.add(MyMallLeftFragment.newInstance());
        fragments.add(MyMallRightFragment.newInstance());
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
        tv_mymall_left.setOnClickListener(this);
        tv_mymall_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_mymall_left:
                setView(tv_mymall_left,tv_mymall_right,view_left,view_right);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_mymall_right:
                setView(tv_mymall_right,tv_mymall_left,view_right,view_left);
                showFragment(fragments.get(1));
                break;
        }
    }

    private void setView(TextView tv1, TextView tv2,  View view1, View view2) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.black));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
    }

}
