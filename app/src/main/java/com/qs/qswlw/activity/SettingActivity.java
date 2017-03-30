package com.qs.qswlw.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.city.HarvestAddressListActivity;


/**
 * Created by 小羽 on 2017/3/24.
 */
public class SettingActivity extends BaseActivity {

    private GridView gv_setting;
    private RadioButton rb_main_mall;
    private RadioButton rb_main_beans;
    private RadioButton rb_main_funtime;
    private RadioButton rb_main_exit;

    @Override
    public Object initView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initfindviewByid() {
        gv_setting = (GridView) findViewById(R.id.gv_setting);
        rb_main_mall = (RadioButton) findViewById(R.id.rb_main_mall);
        rb_main_beans = (RadioButton) findViewById(R.id.rb_main_beans);
        rb_main_funtime = (RadioButton) findViewById(R.id.rb_main_funtime);
        rb_main_exit = (RadioButton) findViewById(R.id.rb_main_exit);
        gv_setting.setAdapter(new MysettingAdapter());

    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(new ItemClickListener());
        rb_main_mall.setOnClickListener(this);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    startActivity(new Intent(SettingActivity.this,HarvestAddressListActivity.class));
                    break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_main_mall:
                startActivity(new Intent(SettingActivity.this, MainActivity.class));
                break;
        }
    }


    /**
     * 设置中心的adapter
     */
    private class MysettingAdapter extends BaseAdapter {

        public int[] ids = {R.mipmap.cyjd, R.mipmap.xfjd, R.mipmap.xfyd,
                R.mipmap.wdjb, R.mipmap.tz, R.mipmap.cyzz, R.mipmap.wytj,
                R.mipmap.tx,R.mipmap.scdd,R.mipmap.cyzz,R.mipmap.zz,
                R.mipmap.cj,R.mipmap.user_address};
        public String[] contents = {"创业金豆", "消费金豆", "消费银豆", "我的金币",
                "我的投资", "创业种子", "我要推荐", "我要提现","商城订单",
                "创业直捐","我要转赠","促销抽奖记录","收货地址"};

        @Override
        public int getCount() {
            return contents.length;
        }

        @Override
        public Object getItem(int i) {
            return ids[ i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(SettingActivity.this,R.layout.item_setting,null);
            ImageView iv_item_setting = (ImageView) view.findViewById(R.id.iv_item_setting);
            TextView tv_item_setting = (TextView) view.findViewById(R.id.tv_item_setting);
            iv_item_setting.setImageResource(ids[i]);
            tv_item_setting.setText(contents[i]);
            return view;
        }
    }
}
