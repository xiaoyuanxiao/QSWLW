package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ConsumerSliverBeanSeedlogAdapter;
import com.qs.qswlw.adapter.ConsumerSliverBeanUsedAdapter;
import com.qs.qswlw.adapter.MallOrdersPayAdapter;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class ConsumerSilverBeanActivity extends BaseInfoActivity {

    private TextView tv_customer_pay, tv_customer_use, tv_customer_alllog, tv_customer_seedlog;
    private ListView lv_consumersliverbean;
    private LinearLayout ll_sliverbean;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumersilverbean, null);
        tv_customer_pay = (TextView) inflate.findViewById(R.id.tv_customer_pay);
        tv_customer_use = (TextView) inflate.findViewById(R.id.tv_customer_use);
        tv_customer_alllog = (TextView) inflate.findViewById(R.id.tv_customer_alllog);
        tv_customer_seedlog = (TextView) inflate.findViewById(R.id.tv_customer_seedlog);
        lv_consumersliverbean = (ListView) inflate.findViewById(R.id.lv_consumersliverbean);
        ll_sliverbean = (LinearLayout) inflate.findViewById(R.id.ll_sliverbean);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("消费银豆");
    }

    @Override
    public void initData() {
        super.initData();
        lv_consumersliverbean.setAdapter(new MallOrdersPayAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_customer_pay.setOnClickListener(this);
        tv_customer_use.setOnClickListener(this);
        tv_customer_alllog.setOnClickListener(this);
        tv_customer_seedlog.setOnClickListener(this);
        ll_sliverbean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_customer_pay:
                tv_customer_pay.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_customer_use.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_alllog.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_seedlog.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_pay.setTextColor(getResources().getColor(R.color.white));
                tv_customer_use.setTextColor(getResources().getColor(R.color.black));
                tv_customer_alllog.setTextColor(getResources().getColor(R.color.black));
                tv_customer_seedlog.setTextColor(getResources().getColor(R.color.black));
                lv_consumersliverbean.setAdapter(new MallOrdersPayAdapter(this));
                break;
            case R.id.tv_customer_use:
                tv_customer_use.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_customer_pay.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_alllog.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_seedlog.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_use.setTextColor(getResources().getColor(R.color.white));
                tv_customer_pay.setTextColor(getResources().getColor(R.color.black));
                tv_customer_alllog.setTextColor(getResources().getColor(R.color.black));
                tv_customer_seedlog.setTextColor(getResources().getColor(R.color.black));
                lv_consumersliverbean.setAdapter(new ConsumerSliverBeanUsedAdapter(this));
                break;
            case R.id.tv_customer_alllog:
                tv_customer_alllog.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_customer_use.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_pay.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_seedlog.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_alllog.setTextColor(getResources().getColor(R.color.white));
                tv_customer_use.setTextColor(getResources().getColor(R.color.black));
                tv_customer_pay.setTextColor(getResources().getColor(R.color.black));
                tv_customer_seedlog.setTextColor(getResources().getColor(R.color.black));
                lv_consumersliverbean.setAdapter(new ConsumerSliverBeanUsedAdapter(this));
                break;
            case R.id.tv_customer_seedlog:
                tv_customer_seedlog.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_customer_use.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_alllog.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_pay.setBackgroundColor(getResources().getColor(R.color.white));
                tv_customer_seedlog.setTextColor(getResources().getColor(R.color.white));
                tv_customer_use.setTextColor(getResources().getColor(R.color.black));
                tv_customer_alllog.setTextColor(getResources().getColor(R.color.black));
                tv_customer_pay.setTextColor(getResources().getColor(R.color.black));
                lv_consumersliverbean.setAdapter(new ConsumerSliverBeanSeedlogAdapter(this));
                break;
            case R.id.ll_sliverbean:
                showDilog();


                break;
        }

    }

    private void showDilog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View dialogview = LayoutInflater.from(this).inflate(R.layout.dialog_sliverbeantoseed, null);
        ImageView iv_close = (ImageView) dialogview.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.setView(dialogview);
        dialog.show();
    }

}