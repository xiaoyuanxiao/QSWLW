package com.qs.qswlw.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.qs.qswlw.BR;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.MyBonusZTFGData;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.BaseRecyleAdapter;
import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.okhttp.Iview.IMyBonusView;
import com.qs.qswlw.okhttp.Presenter.MyBonusPersenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyBonusZTFragment extends BaseDataBindingFragment implements IMyBonusView {
    private MyBonusPersenter myBonusPersenter = new MyBonusPersenter(this);
    private MyBonusZTFGData bind;
    private LinearLayoutManager linearLayoutManager;
    private BaseRecyleAdapter adapter;
    private String temp2,temp1;

    public static MyBonusZTFragment newInstance() {
        return new MyBonusZTFragment();
    }

    @Override
    protected int initview() {
        return R.layout.fg_mybonuszt;
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

        myBonusPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID),"");
    }

    @Override
    public void setdata(MyBonusBean myBonusBean) {
        bind.pbItemforestry.setVisibility(View.GONE);
        bind.llFgMybonuszt.setVisibility(View.VISIBLE);
        MyBonusBean.GoldCountModel1Bean goldCountModel1Bean = myBonusBean.getGold_count_model1().get(0);
        bind.setGoldcountmodel1Bean(goldCountModel1Bean);
        if(goldCountModel1Bean.getTemp2()!=null){
            temp2 = goldCountModel1Bean.getTemp2();
        }else{
            temp2 ="0.000";
        }
        if(goldCountModel1Bean.getTemp1()!=null){
            temp1 = goldCountModel1Bean.getTemp1();
        }else{
            temp1 ="0.000";
        }
        bind.tvMybonusAll.setText("合计:    "+temp2+"     "+temp1);
        List<MyBonusBean.ListBean> list = myBonusBean.getList();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(R.layout.item_mybonuszt, BR.myBonusZTBean);
        adapter = new BaseRecyleAdapter(list, map);
        bind.rvFgMybonuszt.setAdapter(adapter);
    }

    @Override
    public void setOnTokenFile() {

    }
}
