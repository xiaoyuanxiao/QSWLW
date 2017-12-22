package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

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

public class MyRoleActivity extends BaseDataBindingActivity implements IMyRoleView, View.OnClickListener {

    private MyRolePresenter myRolePresenter = new MyRolePresenter(this);
    private MyRoleDatabinding bind;
    private LinearLayoutManager linearLayoutManager;
    private MyRoleAdapter adapter;
    private Intent intent;

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
        bind.setOnclick(this);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_role_upgradeone:
                intent = new Intent(this,RoleDetailsActivity.class);
                intent.putExtra("info","cyts_info");
                startActivity(intent);
                break;
            case R.id.tv_role_upgradetwo:
                intent = new Intent(this,RoleDetailsActivity.class);
                intent.putExtra("info","cyzx_info");
                startActivity(intent);
                break;
            case R.id.tv_role_upgradethree:
                intent = new Intent(this,RoleDetailsActivity.class);
                intent.putExtra("info","cyzj_info");
                startActivity(intent);
                break;
            case R.id.tv_role_upgradefour:
                intent = new Intent(this,RoleDetailsActivity.class);
                intent.putExtra("info","cyds_info");
                startActivity(intent);
                break;
        }

    }
}
