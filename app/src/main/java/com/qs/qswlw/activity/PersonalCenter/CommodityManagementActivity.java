package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.CommodityManagementAdapter;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class CommodityManagementActivity extends BaseInfoActivity {

    private ListView lv_commoditymanagement;
    private RadioButton rb_onSale;
    private RadioButton rb_underTheShelf;
    private TextView tv_add;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_commoditymanagement, null);
        lv_commoditymanagement = (ListView) inflate.findViewById(R.id.lv_commoditymanagement);
        rb_onSale = (RadioButton) inflate.findViewById(R.id.rb_onSale);
        rb_underTheShelf = (RadioButton) inflate.findViewById(R.id.rb_underTheShelf);
        tv_add = (TextView) inflate.findViewById(R.id.tv_add);


        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商品管理");
    }

    @Override
    public void initData() {
        super.initData();
        lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        rb_onSale.setOnClickListener(this);
        rb_underTheShelf.setOnClickListener(this);
        tv_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rb_onSale:
                // lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
                break;
            case R.id.rb_underTheShelf:
                // lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
                break;
            case R.id.tv_add:
                Intent intent = new Intent(this,AddProductActivity.class);
                startActivity(intent);

                break;
        }

    }

}
