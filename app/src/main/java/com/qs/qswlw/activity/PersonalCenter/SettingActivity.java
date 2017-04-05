package com.qs.qswlw.activity.PersonalCenter;

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
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.MainActivity;
import com.qs.qswlw.activity.PersonalCenter.city.HarvestAddressListActivity;


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
                    startActivity(new Intent(SettingActivity.this,ImproveDocumentationActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(SettingActivity.this,EntrepreneurialSeedActivity.class));
                    break;
                case 2:
                    break;
                case 3:
                    startActivity(new Intent(SettingActivity.this,RecommendActivity.class));
                    break;
                case 4:
                    break;
                case 5:
                    startActivity(new Intent(SettingActivity.this,WithdrawalsActivity.class));
                    break;
                case 6:
                    break;
                case 7:
                    startActivity(new Intent(SettingActivity.this,BusinessTurnoverActivity.class));
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
                    //startActivity(new Intent(SettingActivity.this,HarvestAddressListActivity.class));
                    break;
                case 13:
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

        public int[] ids = {R.mipmap.bianji, R.mipmap.cyzz, R.mipmap.beans,
                R.mipmap.wytj, R.mipmap.xfyd, R.mipmap.tx, R.mipmap.user_11,
                R.mipmap.yye,R.mipmap.user_09,R.mipmap.jilu,R.mipmap.cyzz,
                R.mipmap.cpgl,R.mipmap.cj,R.mipmap.user_address};
        public String[] contents = {"商家完善资料", "创业种子", "我的金豆", "我要推荐",
                "消费银豆", "我要提现", "我的让利", "商家营业额","消费录单",
                "录单记录","创业直捐","商品管理","促销抽奖记录","收获地址"};

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
