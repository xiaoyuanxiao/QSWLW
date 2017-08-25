package com.qs.qswlw.Mode;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;


/**
 * Created by 小猴子 on 2016/3/15.
 */
public abstract class BaseMode implements View.OnClickListener {
    public View view;
    public Context context;
    public RelativeLayout rl_titlebar;
    public ImageView iv_titlebar_left;
    public TextView tv_titlebar;
    public ImageView iv_titlebar_right;

    public BaseMode(Context context) {
        this.context = context;
        view = initView();

    }

    protected void initHead() {
        View inflate = View.inflate(context, R.layout.titlebar, null);
//        rl_titlebar = (RelativeLayout) inflate.findViewById(R.id.rl_titlebar);
//        iv_titlebar_left = (ImageView) inflate.findViewById(R.id.iv_titlebar_left);
//        tv_titlebar = (TextView) inflate.findViewById(R.id.tv_titlebar);
//        iv_titlebar_right = (ImageView) inflate.findViewById(R.id.iv_titlebar_right);
//        iv_titlebar_left.setOnClickListener(this);
//        tv_titlebar.setOnClickListener(this);
//        iv_titlebar_right.setOnClickListener(this);
//        tv_titlebar.setText("1111");

    }

    /**
     * 初始化布局
     */
    protected abstract View initView();

    /**
     * 初始化数据
     */
    public void initData() {
    }

    @Override
    public void onClick(View v) {

    }


}
