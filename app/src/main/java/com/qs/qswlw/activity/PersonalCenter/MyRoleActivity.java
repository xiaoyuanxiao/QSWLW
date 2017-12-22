package com.qs.qswlw.activity.PersonalCenter;

import android.support.v7.widget.LinearLayoutManager;

import com.qs.qswlw.BR;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.MyRoleDatabinding;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.adapter.MyRoleAdapter;
import com.qs.qswlw.bean.MyRoleBean;
import com.qs.qswlw.okhttp.Iview.IMyRoleView;
import com.qs.qswlw.okhttp.Presenter.MyRolePresenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.utils.DateUtils;
import com.qs.qswlw.utils.RoleJudgeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MyRoleActivity extends BaseDataBindingActivity implements IMyRoleView {

    private MyRolePresenter myRolePresenter = new MyRolePresenter(this);
    private MyRoleDatabinding bind;
    private LinearLayoutManager linearLayoutManager;
    private MyRoleAdapter adapter;

    @Override
    protected int initview() {
        return R.layout.activity_role;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        setTitleName("我的角色");

    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        bind.rvRole.setLayoutManager(linearLayoutManager);
        myRolePresenter.getData(MyApplication.TOKEN);
    }

    @Override
    public void setMyRoleViewList(MyRoleBean myRoleBean) {
        bind.setRoleBean(myRoleBean);
        bind.tvRole.setText(RoleJudgeUtil.roleJudeg(myRoleBean.getRole()));
        bind.tvRoleTime.setText(DateUtils.stampToDate(Integer.parseInt(myRoleBean.getReg_time()) * 1000L));
        bind.tvRoleCompanyName.setText(MyApplication.NICKNAME);
        List<MyRoleBean.LogsBean> logs = myRoleBean.getLogs();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(R.layout.item_role, BR.itemlogsBean);
        adapter = new MyRoleAdapter(logs,map);
        bind.rvRole.setAdapter(adapter);

    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }


}
