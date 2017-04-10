package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public abstract class BaseInfoActivity extends BaseActivity {

    public RelativeLayout rl_titlebar;
    public ImageView iv_titlebar;
    public TextView tv_titlebar_center;
    public TextView tv_titlebar_right;


    @Override
    public Object initView() {
        return R.layout.baseinfo_activity;
    }

    @Override
    public void initfindviewByid() {
        RelativeLayout viewById = (RelativeLayout) findViewById(R.id.conten_relay);
        viewById.addView(setConetnView());
        rl_titlebar = (RelativeLayout) findViewById(R.id.rl_titlebar);
        iv_titlebar = (ImageView) findViewById(R.id.iv_titlebar);
        tv_titlebar_center = (TextView) findViewById(R.id.tv_titlebar_center);
        tv_titlebar_right = (TextView) findViewById(R.id.tv_titlebar_right);
    }

    @Override
    public void setOnclick() {
        iv_titlebar.setOnClickListener(this);
        tv_titlebar_center.setOnClickListener(this);
        tv_titlebar_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


    }

    abstract View setConetnView();
}
