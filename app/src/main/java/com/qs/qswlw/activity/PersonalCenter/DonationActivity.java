package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class DonationActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_donation, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我要转赠");
        tv_titlebar_right.setText("转赠记录");
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
