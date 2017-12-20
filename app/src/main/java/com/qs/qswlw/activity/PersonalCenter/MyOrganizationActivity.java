package com.qs.qswlw.activity.PersonalCenter;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.bumptech.glide.Glide;
import com.qs.qswlw.BR;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.MyOriganizationData;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.adapter.MyOrganizationAdapter;
import com.qs.qswlw.bean.MyOrganizationBean;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IMyOrganizationView;
import com.qs.qswlw.okhttp.Presenter.MyOrganizationPersenter;
import com.qs.qswlw.utils.RoleJudgeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public class MyOrganizationActivity extends BaseDataBindingActivity implements IMyOrganizationView {

    private MyOriganizationData myOriganizationData;
    private LinearLayoutManager linearLayoutManager;
    private MyOrganizationPersenter myOrganizationPersenter = new MyOrganizationPersenter(this);
    private MyOrganizationAdapter myOrganizationAdapter;


    @Override
    protected int initview() {
        return R.layout.activity_myorganization;
    }

    @Override
    protected void initdatabinding() {
        setTitleName("网络图");
        myOriganizationData = getBind();
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        myOriganizationData.rvMyoriganization.setLayoutManager(linearLayoutManager);
        myOrganizationPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID));
    }

    @Override
    public void setdata(MyOrganizationBean myOrganizationBean) {
        myOriganizationData.pbItemforestry.setVisibility(View.GONE);
        myOriganizationData.llMyoriganization.setVisibility(View.VISIBLE);
        myOriganizationData.setUserBean(myOrganizationBean.getUser());
        Glide.with(this).load(ReHttpUtils.getBaseUrl()+myOrganizationBean.getUser().getHead_pic()).into(myOriganizationData.ivMyoriganizationAvater);
        String s = RoleJudgeUtil.roleJudeg(MyApplication.ROLE);
        myOriganizationData.tvMyoriganizationRole.setText(s);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(R.layout.item_myoriganization, BR.tuiDataBean);
        myOrganizationAdapter=  new MyOrganizationAdapter(myOrganizationBean.getTui_data(),map);
            myOriganizationData.rvMyoriganization.setAdapter(myOrganizationAdapter);

    }
}
