package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.fragment.GetGoldBeanFragment;
import com.qs.qswlw.fragment.MyGoldBeanFragment;
import com.qs.qswlw.fragment.RecommendBeanFragment;
import com.qs.qswlw.okhttp.Iview.IVenturegoldBeansView;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class VenturegoldBeansActivity extends BaseInfoActivity implements IVenturegoldBeansView {

    private FragmentManager fragmentManager;
    private TextView tv_venturegold_left, tv_venturegold_center, tv_venturegold_right;
    private View view_left, view_center, view_right;
    private LinearLayout ll_venturegold_container;
    private ArrayList<Fragment> fragments;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_venturegoldbean, null);
        tv_venturegold_left = (TextView) inflate.findViewById(R.id.tv_venturegold_left);
        tv_venturegold_center = (TextView) inflate.findViewById(R.id.tv_venturegold_center);
        tv_venturegold_right = (TextView) inflate.findViewById(R.id.tv_venturegold_right);
        view_left = (View) inflate.findViewById(R.id.view_left);
        view_center = (View) inflate.findViewById(R.id.view_center);
        view_right = (View) inflate.findViewById(R.id.view_right);
        ll_venturegold_container = (LinearLayout) inflate.findViewById(R.id.ll_venturegold_container);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("创业金豆");
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
        fragments.add(MyGoldBeanFragment.newInstance());
        fragments.add(RecommendBeanFragment.newInstance());
        fragments.add(GetGoldBeanFragment.newInstance());
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
            transaction.add(R.id.ll_venturegold_container, fragment, fragment.getClass().getName());
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
        tv_venturegold_left.setOnClickListener(this);
        tv_venturegold_center.setOnClickListener(this);
        tv_venturegold_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_venturegold_left:
                setView(tv_venturegold_left,tv_venturegold_center,tv_venturegold_right,view_left,view_center,view_right);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_venturegold_center:
                setView(tv_venturegold_center,tv_venturegold_left,tv_venturegold_right,view_center,view_left,view_right);
                showFragment(fragments.get(1));
                break;
            case R.id.tv_venturegold_right:
                setView(tv_venturegold_right,tv_venturegold_center,tv_venturegold_left,view_right,view_center,view_left);
                showFragment(fragments.get(2));

                break;

        }
    }

    private void setView(TextView tv1,TextView tv2,TextView tv3,View view1,View view2,View view3){
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.black));
        tv3.setTextColor(getResources().getColor(R.color.black));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
    }
    @Override
    public void setVenturegoldBeanData(VenturegoldBean venturegoldBeanData) {

    }
}
