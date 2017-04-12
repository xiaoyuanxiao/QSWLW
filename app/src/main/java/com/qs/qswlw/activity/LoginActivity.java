package com.qs.qswlw.activity;

import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class LoginActivity extends BaseInfoActivity {

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_login, null);
        return inflate;
    }
    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("登录");
        tv_titlebar_center.setTextColor(this.getResources().getColor(R.color.white));
        title.setBackgroundColor(this.getResources().getColor(R.color.red));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }


}
