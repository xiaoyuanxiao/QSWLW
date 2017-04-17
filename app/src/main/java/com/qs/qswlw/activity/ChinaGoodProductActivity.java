package com.qs.qswlw.activity;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.adapter.ChinaOrderAmountAdapter;
import com.qs.qswlw.adapter.ChinaOrderQuantityAdapter;
import com.qs.qswlw.adapter.ChinaPraiseRateAdapter;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ChinaGoodProductActivity extends BaseInfoActivity {
    private ChinaPraiseRateAdapter chinaPraiseRateAdapter;
    private ChinaOrderQuantityAdapter chinaOrderQuantityAdapter;
    private ChinaOrderAmountAdapter chinaOrderAmountAdapter;
    private GridView gv_chinagoodproduct;
    private TextView tv_china_praiseRate,tv_china_orderQuantity,tv_china_orderAmount;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_chinagoodproduct, null);
        gv_chinagoodproduct = (GridView) inflate.findViewById(R.id.gv_chinagoodproduct);
        tv_china_praiseRate = (TextView) inflate.findViewById(R.id.tv_china_praiseRate);
        tv_china_orderQuantity = (TextView) inflate.findViewById(R.id.tv_china_orderQuantity);
        tv_china_orderAmount = (TextView) inflate.findViewById(R.id.tv_china_orderAmount);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商家中国好产品");
    }

    @Override
    public void initData() {
        super.initData();
        chinaPraiseRateAdapter = new ChinaPraiseRateAdapter(this);
        chinaOrderQuantityAdapter = new ChinaOrderQuantityAdapter(this);
        chinaOrderAmountAdapter = new ChinaOrderAmountAdapter(this);

        

    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_china_praiseRate.setOnClickListener(this);
        tv_china_orderQuantity.setOnClickListener(this);
        tv_china_orderAmount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_china_praiseRate:
                tv_china_praiseRate.setTextColor(getResources().getColor(R.color.red));
                tv_china_orderQuantity.setTextColor(getResources().getColor(R.color.tv_china));
                tv_china_orderAmount.setTextColor(getResources().getColor(R.color.tv_china));
                findViewById(R.id.view_china_left).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.view_china_center).setBackgroundColor(getResources().getColor(R.color.view));
                findViewById(R.id.view_china_right).setBackgroundColor(getResources().getColor(R.color.view));
                gv_chinagoodproduct.setAdapter(chinaPraiseRateAdapter);
                break;
            case R.id.tv_china_orderQuantity:
                tv_china_orderQuantity.setTextColor(getResources().getColor(R.color.red));
                tv_china_praiseRate.setTextColor(getResources().getColor(R.color.tv_china));
                tv_china_orderAmount.setTextColor(getResources().getColor(R.color.tv_china));
                findViewById(R.id.view_china_center).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.view_china_left).setBackgroundColor(getResources().getColor(R.color.view));
                findViewById(R.id.view_china_right).setBackgroundColor(getResources().getColor(R.color.view));
                gv_chinagoodproduct.setAdapter(chinaOrderQuantityAdapter);
                break;
            case R.id.tv_china_orderAmount:
                tv_china_orderAmount.setTextColor(getResources().getColor(R.color.red));
                tv_china_praiseRate.setTextColor(getResources().getColor(R.color.tv_china));
                tv_china_orderQuantity.setTextColor(getResources().getColor(R.color.tv_china));
                findViewById(R.id.view_china_right).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.view_china_left).setBackgroundColor(getResources().getColor(R.color.view));
                findViewById(R.id.view_china_center).setBackgroundColor(getResources().getColor(R.color.view));
                gv_chinagoodproduct.setAdapter(chinaOrderAmountAdapter);
                break;
        }
    }
}
