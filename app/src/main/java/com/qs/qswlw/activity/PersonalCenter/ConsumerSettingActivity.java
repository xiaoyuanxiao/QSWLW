package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.adapter.ConsumerSettingAdapter;


/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ConsumerSettingActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private GridView gv_setting;
    private ConsumerSettingAdapter consumerSettingAdapter;
    @Override
    public Object initView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initfindviewByid() {
        gv_setting = (GridView) findViewById(R.id.gv_setting);



    }

    @Override
    public void initData() {
        super.initData();
        consumerSettingAdapter = new ConsumerSettingAdapter(this);
        gv_setting.setAdapter(consumerSettingAdapter);
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                startActivity(new Intent(this,VenturegoldBeansActivity.class));
                break;
            case 1:
                startActivity(new Intent(this,VenturegoldBeansActivity.class));
                break;
            case 2:
                startActivity(new Intent(this,ConsumerSilverBeanActivity.class));
                break;
            case 3:
                startActivity(new Intent(this,MyGoldActivity.class));
                break;
            case 4:
                startActivity(new Intent(this,MyInvestActivity.class));
                break;
            case 5:
                startActivity(new Intent(this,ConsumerEntrepreneurialSeedActivity.class));
                break;
            case 6:
                startActivity(new Intent(this,RecommendActivity.class));
                break;
            case 7:
                startActivity(new Intent(this,ConsumeWithdrawalsActivity.class));
                break;
            case 8:
                startActivity(new Intent(this,MallOrdersActivity.class));
                break;
            case 9:
                startActivity(new Intent(this,EntrepreneurialDonationActivity.class));
                break;
            case 10:
                startActivity(new Intent(this,DonationActivity.class));
                break;
            case 11:
                startActivity(new Intent(this,PromotionalLotteryActivity.class));
                break;
            case 12:
                startActivity(new Intent(this,ReceivingAddressActivity.class));
                break;
        }
    }
}
