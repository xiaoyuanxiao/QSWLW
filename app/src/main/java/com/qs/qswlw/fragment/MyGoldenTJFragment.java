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
 * Created by xiaoyu on 2017/12/26.
 */

public class MyGoldenTJFragment extends BaseDataBindingFragment implements IMyGoldenView, View.OnClickListener {

    Sub1MyGoldenTJFragment sub1MyGoldenTJFragment;
    Sub2MyGoldenTJFragment sub2MyGoldenTJFragment;
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
        bind.tvSubMygoldenbeanThree.setVisibility(View.GONE);
        bind.tvSubMygoldenbeanFour.setVisibility(View.GONE);
        bind.tvSubMygoldenbeanTwo.setText("获得金豆");
        bind.tvSubMygoldenbeanOne.setText("获奖时间");
        fragmentManager = getFragmentManager();
        sub1MyGoldenTJFragment = new Sub1MyGoldenTJFragment();
        sub2MyGoldenTJFragment = new Sub2MyGoldenTJFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ll_container1,sub1MyGoldenTJFragment);
        fragmentTransaction.commit();
        bind.setOnclick(this);
    }


    @Override
    public void setVenturegoldBeanData(VenturegoldBean venturegoldBeanData) {
        bind.setVenturegoldBean(venturegoldBeanData);
        bind.tvFgMygoldenbeanGold.setText("累计创业金豆"+venturegoldBeanData.getTjjd().getGold());
        bind.tvFgMygoldenbeanTaxgold.setText("累计消费金豆"+venturegoldBeanData.getTjjd().getTaxgold());
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(getActivity());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_myGoldenBean_left:
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.remove(sub2MyGoldenTJFragment);
                fragmentTransaction1.add(R.id.ll_container1,sub1MyGoldenTJFragment);
                fragmentTransaction1.commit();
                break;
            case R.id.rb_myGoldenBean_right:
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.remove(sub1MyGoldenTJFragment);
                fragmentTransaction2.add(R.id.ll_container1,sub2MyGoldenTJFragment);
                fragmentTransaction2.commit();
                break;
        }

    }
}
