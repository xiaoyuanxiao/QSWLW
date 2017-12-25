package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.qs.qswlw.BR;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.MyRoleDetailData;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.adapter.MyRoleDetailAdapter;
import com.qs.qswlw.bean.MyRoleDatailBean;
import com.qs.qswlw.okhttp.Iview.IRoleDetailsView;
import com.qs.qswlw.okhttp.Presenter.MyRoleDetailsPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class RoleDetailsActivity extends BaseDataBindingActivity implements IRoleDetailsView {

    private MyRoleDetailData bind;
    private MyRoleDetailsPersenter myRoleDetailsPersenter = new MyRoleDetailsPersenter(this);
    private LinearLayoutManager linearLayoutManager;
    private MyRoleDetailAdapter myRoleDetailAdapter;


    @Override
    protected int initview() {
        return R.layout.activity_myroledetail;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        linearLayoutManager = new LinearLayoutManager(this);
        bind.rvRoledetail.setLayoutManager(linearLayoutManager);
        bind.refreshLayout.setEnableLoadmoreWhenContentNotFull(false);
        bind.refreshLayout.setEnableRefresh(false);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String info = intent.getStringExtra("info");
        if("cyts_info".equals(info)){
            setTitleName("伞下创业主任");
        }else if("cyzx_info".equals(info)){
            setTitleName("伞下创业经理");
        }else if("cyzj_info".equals(info)){
            setTitleName("伞下创业总监");
        }else if("cyds_info".equals(info)){
            setTitleName("伞下创业董事");
        }
        myRoleDetailsPersenter.getdata(info, MyApplication.TOKEN, Integer.parseInt(MyApplication.ID));
    }

    @Override
    public void setdata(MyRoleDatailBean myRoleDatailBean) {
        bind.setMyroleBean(myRoleDatailBean);
        bind.tvMyroledetailTitle.setText("伞下共计"+myRoleDatailBean.getCount_num()+"个"+myRoleDatailBean.getRole_name());
        Map<Integer,Integer> map = new HashMap<>();
        map.put(R.layout.item_roledetail, BR.userListBean);
        myRoleDetailAdapter = new MyRoleDetailAdapter(myRoleDatailBean.getUser_list(),map);
        bind.rvRoledetail.setAdapter(myRoleDetailAdapter);

    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }

}
