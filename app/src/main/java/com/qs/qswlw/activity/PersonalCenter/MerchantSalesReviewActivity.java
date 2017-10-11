package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.MerchantSalesReviewFiveFragment;
import com.qs.qswlw.fragment.MerchantSalesReviewFourFragment;
import com.qs.qswlw.fragment.MerchantSalesReviewOneFragment;
import com.qs.qswlw.fragment.MerchantSalesReviewThreeFragment;
import com.qs.qswlw.fragment.MerchantSalesReviewTwoFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/10/10.
 */

public class MerchantSalesReviewActivity extends BaseInfoActivity {

    private TextView tv_merchantsalesreview_one,tv_merchantsalesreview_two,tv_merchantsalesreview_three,
            tv_merchantsalesreview_four,tv_merchantsalesreview_five;
    private View view_one,view_two,view_three,view_four,view_five;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_merchantsalesreview, null);
        tv_merchantsalesreview_one = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_one);
        tv_merchantsalesreview_two = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_two);
        tv_merchantsalesreview_three = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_three);
        tv_merchantsalesreview_four = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_four);
        tv_merchantsalesreview_five = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_five);
        view_one = inflate.findViewById(R.id.view_one);
        view_two = inflate.findViewById(R.id.view_two);
        view_three = inflate.findViewById(R.id.view_three);
        view_four = inflate.findViewById(R.id.view_four);
        view_five = inflate.findViewById(R.id.view_five);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();

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
        fragments = new ArrayList<>();
        fragments.add(MerchantSalesReviewOneFragment.newInstance());
        fragments.add(MerchantSalesReviewTwoFragment.newInstance());
        fragments.add(MerchantSalesReviewThreeFragment.newInstance());
        fragments.add(MerchantSalesReviewFourFragment.newInstance());
        fragments.add(MerchantSalesReviewFiveFragment.newInstance());
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
        tv_merchantsalesreview_one.setOnClickListener(this);
        tv_merchantsalesreview_two.setOnClickListener(this);
        tv_merchantsalesreview_three.setOnClickListener(this);
        tv_merchantsalesreview_four.setOnClickListener(this);
        tv_merchantsalesreview_five.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_merchantsalesreview_one:
                setView(tv_merchantsalesreview_one,tv_merchantsalesreview_two,tv_merchantsalesreview_three,tv_merchantsalesreview_four,tv_merchantsalesreview_five,
                        view_one,view_two,view_three,view_four,view_five);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_merchantsalesreview_two:
                setView(tv_merchantsalesreview_two,tv_merchantsalesreview_one,tv_merchantsalesreview_three,tv_merchantsalesreview_four,tv_merchantsalesreview_five,
                        view_two,view_one,view_three,view_four,view_five);
                showFragment(fragments.get(1));
                break;
            case R.id.tv_merchantsalesreview_three:
                setView(tv_merchantsalesreview_three,tv_merchantsalesreview_one,tv_merchantsalesreview_two,tv_merchantsalesreview_four,tv_merchantsalesreview_five,
                        view_three,view_one,view_two,view_four,view_five);
                showFragment(fragments.get(2));
                break;
            case R.id.tv_merchantsalesreview_four:
                setView(tv_merchantsalesreview_four,tv_merchantsalesreview_one,tv_merchantsalesreview_two,tv_merchantsalesreview_three,tv_merchantsalesreview_five,
                        view_four,view_one,view_two,view_three,view_five);
                showFragment(fragments.get(3));
                break;
            case R.id.tv_merchantsalesreview_five:
                setView(tv_merchantsalesreview_five,tv_merchantsalesreview_one,tv_merchantsalesreview_two,tv_merchantsalesreview_three,tv_merchantsalesreview_four,
                        view_five,view_one,view_two,view_three,view_four);
                showFragment(fragments.get(4));
                break;
        }
    }

    private void setView(TextView tv1, TextView tv2, TextView tv3, TextView tv4, TextView tv5, View view1, View view2, View view3,View view4,View view5) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.tv_china));
        tv3.setTextColor(getResources().getColor(R.color.tv_china));
        tv4.setTextColor(getResources().getColor(R.color.tv_china));
        tv5.setTextColor(getResources().getColor(R.color.tv_china));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
        view4.setBackgroundColor(getResources().getColor(R.color.view));
        view5.setBackgroundColor(getResources().getColor(R.color.view));
    }

}
