package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class MyGoldActivity extends BaseInfoActivity {

    private RelativeLayout rl_pay_mygold, rl_bean_mygold;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mygold, null);
        rl_pay_mygold = (RelativeLayout) inflate.findViewById(R.id.rl_pay_mygold);
        rl_bean_mygold = (RelativeLayout) inflate.findViewById(R.id.rl_bean_mygold);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的金币");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        rl_pay_mygold.setOnClickListener(this);
        rl_bean_mygold.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.rl_pay_mygold:
                startActivity(new Intent(this,PurchaseDestinationActivity.class));
                break;
            case R.id.rl_bean_mygold:
                startActivity(new Intent(this,GoldWhereaboutsActivity.class));
                break;
        }
    }
}
