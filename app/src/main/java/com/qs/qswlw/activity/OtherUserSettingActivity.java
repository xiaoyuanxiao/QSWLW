package com.qs.qswlw.activity;

import android.view.View;

import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/8/29.
 */

public class OtherUserSettingActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        return null;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("个人中心");
    }
}
