package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MallOrdersAllAdapter;
import com.qs.qswlw.adapter.MallOrdersPayAdapter;
import com.qs.qswlw.adapter.MallOrdersReceiptAdapter;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class MallOrdersActivity extends BaseInfoActivity {

    private ListView lv_mallorders;
    private TextView tv_mallorder_pendingPayment,tv_mallorder_receivingGoods,tv_mallorder_allOrder;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mallorders, null);
        lv_mallorders = (ListView) inflate.findViewById(R.id.lv_mallorders);
        tv_mallorder_pendingPayment = (TextView) inflate.findViewById(R.id.tv_mallorder_pendingPayment);
        tv_mallorder_receivingGoods = (TextView) inflate.findViewById(R.id.tv_mallorder_receivingGoods);
        tv_mallorder_allOrder = (TextView) inflate.findViewById(R.id.tv_mallorder_allOrder);
        return inflate;
    }


    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商城订单");
    }

    @Override
    public void initData() {
        super.initData();
        lv_mallorders.setAdapter(new MallOrdersPayAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_mallorder_pendingPayment.setOnClickListener(this);
        tv_mallorder_receivingGoods.setOnClickListener(this);
        tv_mallorder_allOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_mallorder_pendingPayment:
                tv_mallorder_pendingPayment.setTextColor(getResources().getColor(R.color.white));
                tv_mallorder_pendingPayment.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_mallorder_receivingGoods.setTextColor(getResources().getColor(R.color.black));
                tv_mallorder_receivingGoods.setBackgroundColor(getResources().getColor(R.color.white));
                tv_mallorder_allOrder.setTextColor(getResources().getColor(R.color.black));
                tv_mallorder_allOrder.setBackgroundColor(getResources().getColor(R.color.white));
                lv_mallorders.setAdapter(new MallOrdersPayAdapter(this));
                break;
            case R.id.tv_mallorder_receivingGoods:
                tv_mallorder_receivingGoods.setTextColor(getResources().getColor(R.color.white));
                tv_mallorder_receivingGoods.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_mallorder_pendingPayment.setTextColor(getResources().getColor(R.color.black));
                tv_mallorder_pendingPayment.setBackgroundColor(getResources().getColor(R.color.white));
                tv_mallorder_allOrder.setTextColor(getResources().getColor(R.color.black));
                tv_mallorder_allOrder.setBackgroundColor(getResources().getColor(R.color.white));
                lv_mallorders.setAdapter(new MallOrdersReceiptAdapter(this));
                break;
            case R.id.tv_mallorder_allOrder:
                tv_mallorder_allOrder.setTextColor(getResources().getColor(R.color.white));
                tv_mallorder_allOrder.setBackgroundColor(getResources().getColor(R.color.mallorders));
                tv_mallorder_pendingPayment.setTextColor(getResources().getColor(R.color.black));
                tv_mallorder_pendingPayment.setBackgroundColor(getResources().getColor(R.color.white));
                tv_mallorder_receivingGoods.setTextColor(getResources().getColor(R.color.black));
                tv_mallorder_receivingGoods.setBackgroundColor(getResources().getColor(R.color.white));
                lv_mallorders.setAdapter(new MallOrdersAllAdapter(this));
                break;
        }
    }
}
