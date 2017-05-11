package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/5/11.
 */

public class AddProductActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_addproduct, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("添加商品");
    }
}
