package com.qs.qswlw.activity;

import android.content.Intent;
import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class MyProductsActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_myproducts, null);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的产品");
        tv_titlebar_right.setText("发布产品");
    }

    @Override
    public void initData() {
        super.initData();


    }

    @Override
    public void setOnclick() {
        super.setOnclick();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,ReleaseProductsActivity.class));
                break;
        }

    }
}
