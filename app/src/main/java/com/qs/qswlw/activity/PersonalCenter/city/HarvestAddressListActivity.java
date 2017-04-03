package com.qs.qswlw.activity.PersonalCenter.city;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;


/**
 * Created by xiaoyu on 2017/3/30.
 */

public class HarvestAddressListActivity extends BaseActivity{

    private ListView lv_harvestaddresslist;
    private Button btn_activity_harvest;


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_activity_harvest:
                startActivity(new Intent(HarvestAddressListActivity.this,CitySelectActivity.class));
                break;
        }
    }

    @Override
    public Object initView() {
        return R.layout.activity_harvestaddresslist;
    }

    @Override
    public void initfindviewByid() {
        lv_harvestaddresslist = (ListView) findViewById(R.id.lv_harvestaddresslist);
        btn_activity_harvest = (Button) findViewById(R.id.btn_activity_harvest);

        lv_harvestaddresslist.setAdapter(new HarvestAddressListAdapter());
    }

    @Override
    public void setOnclick() {
        btn_activity_harvest.setOnClickListener(this);
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
