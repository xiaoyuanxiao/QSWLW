package com.qs.qswlw.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.qs.qswlw.BaseInfoData;
import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public abstract class BaseDataBindingActivity extends FragmentActivity {
    public BaseInfoData baseInfoData;
    ViewDataBinding inflate;
    int titleview = View.VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBaseTitle();
    }

    public int getTitleview() {
        return titleview;
    }

    private void initBaseTitle() {
        baseInfoData = DataBindingUtil.setContentView(this, R.layout.title);
        baseInfoData.rlTitlebar.setVisibility(getTitleview());
        LayoutInflater from = LayoutInflater.from(this);
        inflate = DataBindingUtil.inflate(from, initview(), baseInfoData.contentParntView, true);
        initdatabinding();
        initData();
        baseInfoData.setBaseInfoActivityonclic(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void setTitleName(String titlename) {
        baseInfoData.setTitlename(titlename);
    }

    public void setTitleRightName(int visiable,String rightName) {
        baseInfoData.tvTitlebarRight.setVisibility(visiable);
        baseInfoData.setRightname(rightName);
    }

    public <T> void setTitleLeftimg(T img) {
        Glide.with(this).load(img).into(baseInfoData.ivTitlebarLeft);
    }

    public void setTitleBg(int color) {
        baseInfoData.rlTitlebar.setBackgroundColor(getResources().getColor(color));
    }

    public <T> void setTitleRightimg(T img) {
        Glide.with(this).load(img).into(baseInfoData.ivTitlebarRight);
    }

  /*  public void setTextVisible(int visible) {
        baseInfoData.tvTitlebarLeft.setVisibility(visible);
    }*/

    public <T extends ViewDataBinding> T getBind() {
        return (T) inflate;
    }

    protected abstract int initview();

    protected abstract void initdatabinding();

    protected abstract void initData();

}
