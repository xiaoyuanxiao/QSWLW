package com.qs.qswlw.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.qs.qswlw.BaseInfoData;
import com.qs.qswlw.R;

import static com.qs.qswlw.R.color.view;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public abstract class BaseDataBindingFragment extends Fragment {
    public BaseInfoData baseInfoData;
    ViewDataBinding inflate;
    int titleview = View.VISIBLE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (baseInfoData == null)
            initBaseTitle();
        container.removeAllViews();
        return baseInfoData.getRoot();
    }

    public int getTitleview() {
        return titleview;
    }

    private void initBaseTitle() {
        LayoutInflater from = LayoutInflater.from(getActivity());
        baseInfoData = DataBindingUtil.inflate(from, R.layout.title, null, false);
        baseInfoData.rlTitlebar.setVisibility(getTitleview());
        inflate = DataBindingUtil.inflate(from, initview(), baseInfoData.contentParntView, true);
        initdatabinding();
        initData();
        baseInfoData.setBaseInfoActivityonclic(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }

    public void setTitleName(String titlename) {
        baseInfoData.setTitlename(titlename);
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

    public void setVisible(int visible) {
        baseInfoData.rlTitlebar.setVisibility(visible);
    }

    public <T extends ViewDataBinding> T getBind() {
        return (T) inflate;
    }

    protected abstract int initview();

    protected abstract void initdatabinding();

    protected abstract void initData();
}
