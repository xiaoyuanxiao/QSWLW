package com.qs.qswlw.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by 小羽 on 2017/8/27.
 */

public class UnioncheckView extends ViewGroup {

    private TextView tv_monthranking;
    private ImageView iv_monthranking;

    public UnioncheckView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    RelativeLayout rlact;
    private void initView(Context context) {
        View.inflate(context, R.layout.view_union_check, this);
        rlact = (RelativeLayout) findViewById(R.id.view_month_ranking);
        tv_monthranking = (TextView) findViewById(R.id.tv_monthranking);
        iv_monthranking = (ImageView) findViewById(R.id.iv_monthranking);
    }

    public void check(Boolean b) {
        if (b) {
            rlact.setBackgroundColor(getResources().getColor(R.color.red));
            tv_monthranking.setTextColor(this.getResources().getColor(R.color.white));
            iv_monthranking.setImageResource(R.mipmap.oo2_03);
        } else {
            rlact.setBackgroundColor(getResources().getColor(R.color.white));
            tv_monthranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
            iv_monthranking.setImageResource(R.mipmap.oo_03);
        }
    }

}
