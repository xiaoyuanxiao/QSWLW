package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.VenturegoldBeansData;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.fragment.MyGoldenFragment;
import com.qs.qswlw.fragment.MyGoldenGiveFragment;
import com.qs.qswlw.fragment.MyGoldenTJFragment;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class VenturegoldBeansActivity1 extends BaseDataBindingActivity implements View.OnClickListener {

    MyGoldenFragment myGoldenFragment;
    MyGoldenTJFragment MyGoldenTJFragment;
    MyGoldenGiveFragment MyGoldenGiveFragment;
    private VenturegoldBeansData bind;
    private FragmentManager fragmentManager;

    @Override
    protected int initview() {
        return R.layout.activity_venturegoldbean1;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        setTitleName("我的金豆");
        setTitleRightName(View.VISIBLE,"筛选");
        setTitleRightimg(R.mipmap.down);
        bind.setOnclick(this);
    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        myGoldenFragment = new MyGoldenFragment();
        MyGoldenTJFragment = new MyGoldenTJFragment();
        MyGoldenGiveFragment = new MyGoldenGiveFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ll_container,myGoldenFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_venturegold_left:
                setView(bind.tvVenturegoldLeft, bind.tvVenturegoldCenter, bind.tvVenturegoldRight, bind.viewLeft, bind.viewCenter, bind.viewRight);
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.ll_container,myGoldenFragment);
                fragmentTransaction1.commit();

                break;
            case R.id.tv_venturegold_center:
                setView( bind.tvVenturegoldCenter, bind.tvVenturegoldLeft,bind.tvVenturegoldRight,bind.viewCenter, bind.viewLeft, bind.viewRight);
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.replace(R.id.ll_container,MyGoldenTJFragment);
                fragmentTransaction2.commit();
                break;
            case R.id.tv_venturegold_right:
                setView(bind.tvVenturegoldRight,bind.tvVenturegoldLeft, bind.tvVenturegoldCenter,bind.viewRight , bind.viewLeft, bind.viewCenter);
                FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                fragmentTransaction3.replace(R.id.ll_container,MyGoldenGiveFragment);
                fragmentTransaction3.commit();
                break;
        }
    }

    private void setView(TextView tv1, TextView tv2, TextView tv3, View view1, View view2, View view3) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.black));
        tv3.setTextColor(getResources().getColor(R.color.black));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
    }
}
