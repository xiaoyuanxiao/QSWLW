package com.qs.qswlw.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.qs.qswlw.MyGoldenFGData;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.okhttp.Iview.IMyGoldenView;
import com.qs.qswlw.utils.ActivityManagerUtils;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class MyGoldenFragment extends BaseDataBindingFragment implements IMyGoldenView, View.OnClickListener {

    Sub1MyGoldenFragment sub1MyGoldenFragment;
    Sub2MyGoldenFragment sub2MyGoldenFragment;
    private MyGoldenFGData bind;
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
        sub1MyGoldenFragment = new Sub1MyGoldenFragment();
        sub2MyGoldenFragment = new Sub2MyGoldenFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ll_container1,sub1MyGoldenFragment);
        fragmentTransaction.commit();
        bind.setOnclick(this);

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
               // showFragment(fragments.get(0));
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.remove(sub2MyGoldenFragment);
                fragmentTransaction1.add(R.id.ll_container1,sub1MyGoldenFragment);
                fragmentTransaction1.commit();
                break;
            case R.id.rb_myGoldenBean_right:
//                showFragment(fragments.get(1));
                FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                fragmentTransaction3.remove(sub1MyGoldenFragment);
                fragmentTransaction3.add(R.id.ll_container1,sub2MyGoldenFragment);
                fragmentTransaction3.commit();
                break;
        }

    }
}
