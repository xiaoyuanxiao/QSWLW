package com.qs.qswlw.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qs.qswlw.activity.BaseActivity;


/**
 * Created by xiaoyu on 2016/2/24.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected BaseActivity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View view;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (BaseActivity) activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = initView();

        return view;
    }

    abstract View initView();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }


    /**
     * 初始化数据
     */
    protected void initData() {
        setOnclick();
    }

    protected abstract void setOnclick();


    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

    public void runOnUiThread(Runnable runnable) {
        getActivity().runOnUiThread(runnable);
    }
}

