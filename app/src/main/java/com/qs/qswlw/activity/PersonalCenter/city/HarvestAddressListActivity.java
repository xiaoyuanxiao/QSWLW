package com.qs.qswlw.activity.PersonalCenter.city;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;


/**
 * Created by xiaoyu on 2017/3/30.
 */

public class HarvestAddressListActivity extends BaseInfoActivity{

    private ListView lv_harvestaddresslist;
    private Button btn_activity_harvest;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_harvestaddresslist, null);
        lv_harvestaddresslist = (ListView) inflate.findViewById(R.id.lv_harvestaddresslist);
        btn_activity_harvest = (Button) inflate.findViewById(R.id.btn_activity_harvest);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("收获地址");
    }

    @Override
    public void initData() {
        super.initData();
        lv_harvestaddresslist.setAdapter(new HarvestAddressListAdapter());
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_activity_harvest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_activity_harvest:
                startActivity(new Intent(HarvestAddressListActivity.this,CitySelectActivity.class));
                break;
        }
    }

    private class HarvestAddressListAdapter extends BaseAdapter {
        private String[] names = {"你好","hia","多多","shim","何姑娘","哈杰","玩家"};


        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return names[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(HarvestAddressListActivity.this,R.layout.item_harvestaddresslist,null);
            TextView tv_name_harvestaddresslist = (TextView) view.findViewById(R.id.tv_name_harvestaddresslist);
            // iv_item_setting.setImageResoure(R.mipmap.);
            tv_name_harvestaddresslist.setText(names[i]);

            return view;
        }
    }
}
