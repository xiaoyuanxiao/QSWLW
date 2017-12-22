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
        bind.setOnclick(this);

    }

    @Override
    public void setVenturegoldBeanData(VenturegoldBean venturegoldBeanData) {
        bind.setVenturegoldBean(venturegoldBeanData);
        bind.tvFgMygoldenbeanGold.setText("累计创业金豆"+venturegoldBeanData.getModel().getGold());
        bind.tvFgMygoldenbeanTaxgold.setText("累计消费金豆"+venturegoldBeanData.getModel().getTaxgold());
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(getActivity());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_myGoldenBean_left:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Sub1MyGoldenFragment myGoldenFragment = new Sub1MyGoldenFragment();
                fragmentTransaction.add(R.id.ll_container,myGoldenFragment);
                fragmentTransaction.commit();
                break;
            case R.id.rb_myGoldenBean_right:
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                Sub2MyGoldenFragment sub2MyGoldenFragment = new Sub2MyGoldenFragment();
                fragmentTransaction1.add(R.id.ll_container,sub2MyGoldenFragment);
                fragmentTransaction1.commit();
                break;
        }

    }
}
