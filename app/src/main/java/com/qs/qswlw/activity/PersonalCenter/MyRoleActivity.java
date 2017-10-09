package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MyRoleBean;
import com.qs.qswlw.okhttp.Iview.IMyRoleView;
import com.qs.qswlw.okhttp.Presenter.MyRolePresenter;
import com.qs.qswlw.utils.DateUtils;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MyRoleActivity extends BaseInfoActivity implements IMyRoleView {

    private ImageView iv_role_avater;
    private TextView tv_role_companyName,tv_role_nickname,tv_role,tv_role_address,tv_role_time;
    private MyRolePresenter myRolePresenter = new MyRolePresenter(this);

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_role, null);
        iv_role_avater = (ImageView) inflate.findViewById(R.id.iv_role_avater);
        tv_role_companyName = (TextView) inflate.findViewById(R.id.tv_role_companyName);
        tv_role_nickname = (TextView) inflate.findViewById(R.id.tv_role_nickname);
        tv_role = (TextView) inflate.findViewById(R.id.tv_role);
        tv_role_address = (TextView) inflate.findViewById(R.id.tv_role_address);
        tv_role_time = (TextView) inflate.findViewById(R.id.tv_role_time);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的角色");
    }

    @Override
    public void initData() {
        super.initData();
        myRolePresenter.getData(MyApplication.TOKEN);
    }

    @Override
    public void setMyRoleViewList(MyRoleBean myRoleBean) {
        tv_role_companyName.setText(myRoleBean.getNickname());
        tv_role_nickname.setText(myRoleBean.getCyzx_name().getNickname());
        String role = myRoleBean.getRole();
        String is_cyzx = myRoleBean.getIs_cyzx();
        if("1".equals(is_cyzx) ){
            tv_role.setText("创业中心");
        }
        if(("0").equals(role)){
            tv_role.setText("消费天使");
        }else if(("10".equals(role))){
            tv_role.setText("商家");
        }
        tv_role_address.setText(myRoleBean.getCyzx_address().getAddress());
        tv_role_time.setText(DateUtils.long2date(Integer.parseInt(myRoleBean.getReg_time()) * 1000L));
       // tv_role_time.setText(DateUtils.stampToDate(Integer.parseInt(myRoleBean.getReg_time()) * 1000L));

    }
}
