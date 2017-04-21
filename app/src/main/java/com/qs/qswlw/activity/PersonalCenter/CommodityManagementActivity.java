package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.CommodityManagementAdapter;

import static com.qs.qswlw.R.color.view;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class CommodityManagementActivity extends BaseInfoActivity {

    private ListView lv_commoditymanagement;
    private RadioButton rb_onSale;
    private RadioButton rb_underTheShelf;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_commoditymanagement, null);
        lv_commoditymanagement = (ListView) inflate.findViewById(R.id.lv_commoditymanagement);
        rb_onSale = (RadioButton) inflate.findViewById(R.id.rb_onSale);
        rb_underTheShelf = (RadioButton) inflate.findViewById(R.id.rb_underTheShelf);
        lv_commoditymanagement.setAdapter(new CommodityManagementAdapter(this));
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商品管理");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        rb_onSale.setOnClickListener(this);
        rb_underTheShelf.setOnClickListener(this);
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
        }
        }

}
