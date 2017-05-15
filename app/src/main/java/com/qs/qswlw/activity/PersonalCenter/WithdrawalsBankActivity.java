package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsBankAdapter;

/**
 * Created by xiaoyu on 2017/5/12.
 */

public class WithdrawalsBankActivity extends BaseInfoActivity {
    private ListView lv_withdrawalsbank;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsbank, null);
        lv_withdrawalsbank =  (ListView) inflate.findViewById(R.id.lv_withdrawalsbank);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的银行卡");
        tv_titlebar_right.setText("添加");
        iv_titlebar_right.setVisibility(View.VISIBLE);
        iv_titlebar_right.setImageResource(R.mipmap.goods_add);
    }

    @Override
    public void initData() {
        super.initData();
        lv_withdrawalsbank.setAdapter(new WithdrawalsBankAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ll_titlebar_right:
                startActivity(new Intent(this,WithdrawalsAddActivity.class));

                break;
        }
    }
}
