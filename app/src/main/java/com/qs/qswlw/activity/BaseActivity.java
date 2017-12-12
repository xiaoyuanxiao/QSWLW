package com.qs.qswlw.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by 小羽 on 2017/3/22.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {


    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Log.d("ACTIVITY", "====================" + getClass().getName());
        Log.d("Activity", getClass().getName());
        Object initView = initView();
        if (initView instanceof View) {
            setContentView((View) initView);
        } else {
            setContentView((Integer) initView);
        }
        initData();
    }

    public void initData() {
        initfindviewByid();
        setOnclick();
    }


    public abstract Object initView();

    public abstract void initfindviewByid();

    public abstract void setOnclick();
}
