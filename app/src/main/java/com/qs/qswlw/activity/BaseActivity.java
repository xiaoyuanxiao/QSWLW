package com.qs.qswlw.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by 小羽 on 2017/3/22.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    public RelativeLayout rl_titlebar;
    public ImageView iv_titlebar;
    public TextView tv_titlebar_center;
    public TextView tv_titlebar_right;

    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        Object initView = initView();
        if (initView instanceof View) {
            setContentView((View) initView);
        } else {
            setContentView((Integer) initView);
        }
        initData();
    }

    private void initData() {
        initfindviewByid();
        setOnclick();
    }

    protected void initHead() {
        View inflate = View.inflate(BaseActivity.this, R.layout.titlebar, null);
        rl_titlebar = (RelativeLayout) inflate.findViewById(R.id.rl_titlebar);
        iv_titlebar = (ImageView) inflate.findViewById(+R.id.iv_titlebar);
        tv_titlebar_center = (TextView) inflate.findViewById(R.id.tv_titlebar_center);
        tv_titlebar_right = (TextView) inflate.findViewById(R.id.tv_titlebar_right);
        iv_titlebar.setOnClickListener(this);
        tv_titlebar_center.setOnClickListener(this);
        tv_titlebar_right.setOnClickListener(this);
    }

    public abstract Object initView();

    public abstract void initfindviewByid();

    public abstract void setOnclick();
}
