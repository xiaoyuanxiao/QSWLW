package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.MyBobusDatabinding;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.fragment.MyBonusGLFragment;
import com.qs.qswlw.fragment.MyBonusZTFragment;
import com.qs.qswlw.okhttp.Iview.IMyBonusView;
import com.qs.qswlw.okhttp.Presenter.MyBonusPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyBonusActivity extends BaseDataBindingActivity implements View.OnClickListener,IMyBonusView {

    private MyBobusDatabinding bind;

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
    private MyBonusPersenter myBonusPersenter = new MyBonusPersenter(this);

    @Override
    protected int initview() {
        return R.layout.activity_mybonus;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        setTitleName("我的奖金");

    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ll_container,new MyBonusZTFragment());
        fragmentTransaction.commit();
        myBonusPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID),"");
        bind.setOnclick(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_mybonus_zhitui:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.ll_container,new MyBonusZTFragment());
                fragmentTransaction.commit();
                break;

            case R.id.rb_mybonus_guanli:
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.ll_container,new MyBonusGLFragment());
                fragmentTransaction1.commit();
                break;
        }
    }

    @Override
    public void setdata(MyBonusBean myBonusBean) {
        bind.setModelBean(myBonusBean.getModel());
    }

    @Override
    public void setOnTokenFile() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }
}
