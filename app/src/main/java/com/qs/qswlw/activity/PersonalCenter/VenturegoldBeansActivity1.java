package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.VenturegoldBeansData;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.fragment.MyGoldenFragment;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class VenturegoldBeansActivity1 extends BaseDataBindingActivity implements View.OnClickListener {

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_venturegold_left:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyGoldenFragment myGoldenFragment = new MyGoldenFragment();
                fragmentTransaction.add(R.id.ll_container,myGoldenFragment);
                fragmentTransaction.commit();

                break;
            case R.id.tv_venturegold_center:
                break;
            case R.id.tv_venturegold_right:
                break;
        }

    }
}
