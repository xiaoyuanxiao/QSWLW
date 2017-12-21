package com.qs.qswlw.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.qs.qswlw.BR;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.MyBonusGLFGData;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyBonusGLAdapter;
import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.okhttp.Iview.IMyBonusView;
import com.qs.qswlw.okhttp.Presenter.MyBonusPersenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyBonusGLFragment extends BaseDataBindingFragment implements IMyBonusView{

    private MyBonusGLFGData bind;
    private MyBonusPersenter myBonusPersenter = new MyBonusPersenter(this);
    private LinearLayoutManager linearLayoutManager;
    private MyBonusGLAdapter myBonusGLAdapter;

    @Override
    protected int initview() {
        return R.layout.fg_mybonusgl;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
    }

    @Override
    protected void initData() {
        setVisible(View.GONE);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        bind.rvFgMybonuszt.setLayoutManager(linearLayoutManager);
        myBonusPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID),"glj");
    }

    @Override
    public void setdata(MyBonusBean myBonusBean) {
        bind.pbItemforestry.setVisibility(View.GONE);
        bind.llFgMybonuszt.setVisibility(View.VISIBLE);
        MyBonusBean.GoldCountModel2Bean goldCountModel2Bean = myBonusBean.getGold_count_model2().get(0);
        bind.setGoldcountmodel2Bean(goldCountModel2Bean);
        List<MyBonusBean.ListBean> list = myBonusBean.getList();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(R.layout.item_mybonusgl, BR.myBonusGLBean);
        myBonusGLAdapter = new MyBonusGLAdapter(list, map);
        bind.rvFgMybonuszt.setAdapter(myBonusGLAdapter);
    }

    @Override
    public void setOnTokenFile() {

    }
}
