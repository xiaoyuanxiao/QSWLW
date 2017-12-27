package com.qs.qswlw.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.qs.qswlw.MyGoldenFGData;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.okhttp.Iview.IMyGoldenView;
import com.qs.qswlw.utils.ActivityManagerUtils;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class MyGoldenFragment extends BaseDataBindingFragment implements IMyGoldenView, View.OnClickListener {

    private MyGoldenFGData bind;
    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;

    @Override
    protected int initview() {
        return R.layout.fg_mygolden;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        setVisible(View.GONE);
    }

    @Override
    protected void initData() {
        fragmentManager = getFragmentManager();
        initFragment();
        bind.setOnclick(this);

    }

    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(Sub1MyGoldenFragment.newInstance());
        fragments.add(Sub2MyGoldenFragment.newInstance());
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
            transaction.add(R.id.ll_container1, fragment, fragment.getClass().getName()).show(fragment);
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
    public void setVenturegoldBeanData(VenturegoldBean venturegoldBeanData) {
        bind.setVenturegoldBean(venturegoldBeanData);
        bind.tvFgMygoldenbeanGold.setText("累计创业金豆" + venturegoldBeanData.getModel().getGold());
        bind.tvFgMygoldenbeanTaxgold.setText("累计消费金豆" + venturegoldBeanData.getModel().getTaxgold());
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_myGoldenBean_left:
                showFragment(fragments.get(0));
                break;
            case R.id.rb_myGoldenBean_right:
                showFragment(fragments.get(1));
                break;
        }

    }
}
