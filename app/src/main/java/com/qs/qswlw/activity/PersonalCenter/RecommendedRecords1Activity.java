package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.RecommendRecordFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class RecommendedRecords1Activity extends BaseInfoActivity {

    private TextView tv_consumer,tv_business;

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recommendedrecords1, null);
        tv_consumer = (TextView) inflate.findViewById(R.id.tv_consumer);
        tv_business = (TextView) inflate.findViewById(R.id.tv_business);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("推荐记录");
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
        fragments.add(RecommendRecordFragment.newInstance(RecommendRecordFragment.JID4));
        fragments.add(RecommendRecordFragment.newInstance(RecommendRecordFragment.J1D3));
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
        tv_consumer.setOnClickListener(this);
        tv_business.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_consumer:
                setTopColor(tv_consumer,tv_business);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_business:
                setTopColor(tv_business,tv_consumer);
                showFragment(fragments.get(1));
                break;
        }
    }

    private void setTopColor(TextView tv,TextView tv1){
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv1.setBackgroundColor(getResources().getColor(R.color.white));
        tv.setTextColor(getResources().getColor(R.color.white));
        tv.setBackgroundColor(getResources().getColor(R.color.tv_green));
    }


}
