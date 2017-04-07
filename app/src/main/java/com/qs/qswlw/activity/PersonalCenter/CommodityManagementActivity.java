package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.adapter.CommodityManagementAdapter;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class CommodityManagementActivity extends BaseActivity {

    private ListView lv_commoditymanagement;
    private RadioButton rb_onSale;
    private RadioButton rb_underTheShelf;

    @Override
    public Object initView() {
        return R.layout.activity_commoditymanagement;
    }

    @Override
    public void initfindviewByid() {
        lv_commoditymanagement = (ListView) findViewById(R.id.lv_commoditymanagement);
        rb_onSale = (RadioButton) findViewById(R.id.rb_onSale);
        rb_underTheShelf = (RadioButton) findViewById(R.id.rb_underTheShelf);
        lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
    }

    @Override
    public void setOnclick() {
        rb_onSale.setOnClickListener(this);
        rb_underTheShelf.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_onSale:
               // lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
                break;
            case R.id.rb_underTheShelf:
               // lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
                break;

        }
    }
}
