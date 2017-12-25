package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.qs.qswlw.BR;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.SettingNewDataBinding;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.adapter.SettingNewAdapter;
import com.qs.qswlw.bean.SettingNewsBean;
import com.qs.qswlw.okhttp.Iview.ISettingNewView;
import com.qs.qswlw.okhttp.Presenter.SettingNewPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.view.webviewpb.WebviewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public class SettingNewActivity extends BaseDataBindingActivity implements ISettingNewView,View.OnClickListener {
    private LinearLayoutManager linearLayoutManager;
    private SettingNewDataBinding bind;
    private SettingNewPersenter settingNewPersenter = new SettingNewPersenter(this);
    private SettingNewAdapter settingNewAdapter;
    private List<SettingNewsBean.MessageBean> settingNewsBean;
    private String customerservice;
    private Intent intent;


    @Override
    protected int initview() {
        return R.layout.activity_settingnews;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        setTitleName("我的消息");
        setTitleRightimg(R.mipmap.shezhi);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        bind.rvSettingnews.setLayoutManager(linearLayoutManager);
        settingNewsBean = new ArrayList<>();
        settingNewPersenter.getData(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID));
        bind.setSettingNewActivityclick(this);
    }

    @Override
    public void setdata(SettingNewsBean settingNewsBean) {
        List<SettingNewsBean.MessageBean> message = settingNewsBean.getMessage();
        customerservice = settingNewsBean.getCustomerservice();
        this.settingNewsBean = message;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(R.layout.item_setting_news, BR.settingnewbean);
        settingNewAdapter = new SettingNewAdapter(this.settingNewsBean,map);
        bind.rvSettingnews.setAdapter(settingNewAdapter);

    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(SettingNewActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_settingnews_consultation:
               intent = new Intent(this, WebviewActivity.class);
                intent.putExtra("customerservice", customerservice);
                startActivity(this.intent);
                break;
        }

    }

}
