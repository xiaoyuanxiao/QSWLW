package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.utils.DialogUtils;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class MyInvestActivity extends BaseInfoActivity {

    private TextView tv_myinvest_choice;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_myinvest, null);
        tv_myinvest_choice = (TextView) inflate.findViewById(R.id.tv_myinvest_choice);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的投资");
        tv_titlebar_right.setText("投资记录");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
        tv_myinvest_choice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,InvestRecordActivity.class));
                break;
            case R.id.tv_myinvest_choice:
                DialogUtils.showDidlog(this,new String[]{"中国好物产"},tv_myinvest_choice);
                break;
        }
    }
}
