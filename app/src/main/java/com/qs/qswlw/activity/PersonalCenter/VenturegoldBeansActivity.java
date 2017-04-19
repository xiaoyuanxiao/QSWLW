package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.VentureGoldBeansAdapter;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class VentureGoldBeansActivity extends BaseInfoActivity {

    private ListView lv_venturegoldbeans;

    private TextView tv_venturegold_left,tv_venturegold_center,tv_venturegold_right;
    private View view_left,view_center,view_right;
    private TextView tv_venturegoldbeans_titile;

    @Override
    public View setConetnView() {
        View inflate =  View.inflate(this, R.layout.activity_venturegoldbeans, null);
        lv_venturegoldbeans = (ListView) inflate.findViewById(R.id.lv_venturegoldbeans);
        tv_venturegold_left = (TextView) inflate.findViewById(R.id.tv_venturegold_left);
        tv_venturegold_center = (TextView) inflate.findViewById(R.id.tv_venturegold_center);
        tv_venturegold_right = (TextView) inflate.findViewById(R.id.tv_venturegold_right);
        view_left = (View) inflate.findViewById(R.id.view_left);
        view_center = (View) inflate.findViewById(R.id.view_center);
        view_right = (View) inflate.findViewById(R.id.view_right);
        tv_venturegoldbeans_titile = (TextView) inflate.findViewById(R.id.tv_venturegoldbeans_titile);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("创业金豆");
    }

    @Override
    public void initData() {
        super.initData();
        lv_venturegoldbeans.setAdapter(new VentureGoldBeansAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_venturegold_left.setOnClickListener(this);
        tv_venturegold_center.setOnClickListener(this);
        tv_venturegold_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_venturegold_left:
                tv_venturegold_left.setTextColor(getResources().getColor(R.color.red));
                tv_venturegold_center.setTextColor(getResources().getColor(R.color.black));
                tv_venturegold_right.setTextColor(getResources().getColor(R.color.black));
                view_left.setBackgroundColor(getResources().getColor(R.color.red));
                view_center.setBackgroundColor(getResources().getColor(R.color.view));
                view_right.setBackgroundColor(getResources().getColor(R.color.view));
                break;
            case R.id.tv_venturegold_center:
                tv_venturegold_center.setTextColor(getResources().getColor(R.color.red));
                tv_venturegold_left.setTextColor(getResources().getColor(R.color.black));
                tv_venturegold_right.setTextColor(getResources().getColor(R.color.black));
                view_center.setBackgroundColor(getResources().getColor(R.color.red));
                view_left.setBackgroundColor(getResources().getColor(R.color.view));
                view_right.setBackgroundColor(getResources().getColor(R.color.view));
                tv_venturegoldbeans_titile.setText("累计推荐创业金豆");
                break;
            case R.id.tv_venturegold_right:
                tv_venturegold_right.setTextColor(getResources().getColor(R.color.red));
                tv_venturegold_center.setTextColor(getResources().getColor(R.color.black));
                tv_venturegold_left.setTextColor(getResources().getColor(R.color.black));
                view_right.setBackgroundColor(getResources().getColor(R.color.red));
                view_center.setBackgroundColor(getResources().getColor(R.color.view));
                view_left.setBackgroundColor(getResources().getColor(R.color.view));
                tv_venturegoldbeans_titile.setText("累计获赠创业金豆");
                break;

        }
    }
}
