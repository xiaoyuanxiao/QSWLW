package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public abstract class BaseInfoActivity extends BaseActivity {

    public RelativeLayout title;
    public ImageView iv_titlebar;
    public TextView tv_titlebar_center;
    public TextView tv_titlebar_right;
    public ImageView iv_titlebar_right;
    public LinearLayout ll_titlebar_right;

    @Override
    public Object initView() {
        return R.layout.baseinfo_activity;
    }

    @Override
    public void initfindviewByid() {
        RelativeLayout viewById = (RelativeLayout) findViewById(R.id.conten_relay);
        viewById.addView(setConetnView());
        title = (RelativeLayout) findViewById(R.id.title);
        iv_titlebar = (ImageView) findViewById(R.id.iv_titlebar);
        tv_titlebar_center = (TextView) findViewById(R.id.tv_titlebar_center);
        tv_titlebar_right = (TextView) findViewById(R.id.tv_titlebar_right);
        iv_titlebar_right = (ImageView) findViewById(R.id.iv_titlebar_right);
        ll_titlebar_right = (LinearLayout) findViewById(R.id.ll_titlebar_right);
    }

    @Override
    public void setOnclick() {
        iv_titlebar.setOnClickListener(this);
        tv_titlebar_center.setOnClickListener(this);
        tv_titlebar_right.setOnClickListener(this);
        ll_titlebar_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_titlebar:
                finish();
                break;
        }

    }

    public abstract View setConetnView();
}
