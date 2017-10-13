package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/10/13.
 */

public class MyShoppingActivity extends BaseInfoActivity {

    private TextView tv_merchantsalesreview_one,tv_merchantsalesreview_two,tv_merchantsalesreview_three,
            tv_merchantsalesreview_four,tv_merchantsalesreview_five,tv_merchantsalesreview_six;
    private View view_one,view_two,view_three,view_four,view_five,view_six;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_merchantsalesreview, null);
        tv_merchantsalesreview_one = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_one);
        tv_merchantsalesreview_two = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_two);
        tv_merchantsalesreview_three = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_three);
        tv_merchantsalesreview_four = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_four);
        tv_merchantsalesreview_five = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_five);
        tv_merchantsalesreview_six = (TextView) inflate.findViewById(R.id.tv_merchantsalesreview_six);
        view_one = inflate.findViewById(R.id.view_one);
        view_two = inflate.findViewById(R.id.view_two);
        view_three = inflate.findViewById(R.id.view_three);
        view_four = inflate.findViewById(R.id.view_four);
        view_five = inflate.findViewById(R.id.view_five);
        view_six = inflate.findViewById(R.id.view_six);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的购物订单");
    }

    @Override
    public void initData() {
        super.initData();
        tv_merchantsalesreview_six.setVisibility(View.VISIBLE);
        view_six.setVisibility(View.VISIBLE);
        tv_merchantsalesreview_one.setText("待支付");
        tv_merchantsalesreview_two.setText("已付款");
        tv_merchantsalesreview_three.setText("待收货");
        tv_merchantsalesreview_four.setText("全部");
        tv_merchantsalesreview_five.setText("已完成");
        tv_merchantsalesreview_six.setText("总报表");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_merchantsalesreview_one.setOnClickListener(this);
        tv_merchantsalesreview_two.setOnClickListener(this);
        tv_merchantsalesreview_three.setOnClickListener(this);
        tv_merchantsalesreview_four.setOnClickListener(this);
        tv_merchantsalesreview_five.setOnClickListener(this);
        tv_merchantsalesreview_six.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_merchantsalesreview_one:
                setView(tv_merchantsalesreview_one, tv_merchantsalesreview_two, tv_merchantsalesreview_three, tv_merchantsalesreview_four, tv_merchantsalesreview_five,tv_merchantsalesreview_six,
                        view_one, view_two, view_three, view_four, view_five,view_six);
                break;
            case R.id.tv_merchantsalesreview_two:
                setView(tv_merchantsalesreview_two, tv_merchantsalesreview_one, tv_merchantsalesreview_three, tv_merchantsalesreview_four, tv_merchantsalesreview_five,tv_merchantsalesreview_six,
                        view_two, view_one, view_three, view_four, view_five,view_six);
                break;
            case R.id.tv_merchantsalesreview_three:
                setView(tv_merchantsalesreview_three, tv_merchantsalesreview_one, tv_merchantsalesreview_two, tv_merchantsalesreview_four, tv_merchantsalesreview_five,tv_merchantsalesreview_six,
                        view_three, view_one, view_two, view_four, view_five,view_six);
                break;
            case R.id.tv_merchantsalesreview_four:
                setView(tv_merchantsalesreview_four, tv_merchantsalesreview_one, tv_merchantsalesreview_two, tv_merchantsalesreview_three, tv_merchantsalesreview_five,tv_merchantsalesreview_six,
                        view_four, view_one, view_two, view_three, view_five,view_six);
                break;
            case R.id.tv_merchantsalesreview_five:
                setView(tv_merchantsalesreview_five, tv_merchantsalesreview_one, tv_merchantsalesreview_two, tv_merchantsalesreview_three, tv_merchantsalesreview_four,tv_merchantsalesreview_six,
                        view_five, view_one, view_two, view_three, view_four,view_six);
                break;
            case R.id.tv_merchantsalesreview_six:
                setView(tv_merchantsalesreview_six,tv_merchantsalesreview_one, tv_merchantsalesreview_two, tv_merchantsalesreview_three, tv_merchantsalesreview_four,tv_merchantsalesreview_five,
                        view_six, view_one, view_two, view_three, view_four,view_five);
                break;
        }
    }
    private void setView(TextView tv1, TextView tv2, TextView tv3, TextView tv4, TextView tv5, TextView tv6,View view1, View view2, View view3,View view4,View view5,View view6) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.tv_china));
        tv3.setTextColor(getResources().getColor(R.color.tv_china));
        tv4.setTextColor(getResources().getColor(R.color.tv_china));
        tv5.setTextColor(getResources().getColor(R.color.tv_china));
        tv6.setTextColor(getResources().getColor(R.color.tv_china));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
        view4.setBackgroundColor(getResources().getColor(R.color.view));
        view5.setBackgroundColor(getResources().getColor(R.color.view));
        view6.setBackgroundColor(getResources().getColor(R.color.view));
    }
}
