package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.MainActivity;
import com.qs.qswlw.activity.MyProductsActivity;
import com.qs.qswlw.activity.PersonalCenter.city.HarvestAddressListActivity;
import com.qs.qswlw.adapter.BusinessSettingAdapter;


/**
 * Created by 小羽 on 2017/3/24.
 */
public class BusinessSettingActivity extends BaseActivity {

    private GridView gv_setting;
    private RadioButton rb_main_mall;
    private RadioButton rb_main_beans;
    private RadioButton rb_main_funtime;
    private RadioButton rb_main_exit;
    private BusinessSettingAdapter businessSettingAdapter;
    private TextView tv_setting_set;


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
        tv_setting_set = (TextView) findViewById(R.id.tv_setting_set);


    }

    @Override
    public void initData() {
        super.initData();
        businessSettingAdapter = new BusinessSettingAdapter(this);
        gv_setting.setAdapter(businessSettingAdapter);
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(new ItemClickListener());
        rb_main_mall.setOnClickListener(this);
        rb_main_exit.setOnClickListener(this);
        tv_setting_set.setOnClickListener(this);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i){
                case 0:
                    startActivity(new Intent(BusinessSettingActivity.this,ImproveDocumentationActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(BusinessSettingActivity.this,EntrepreneurialSeedActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(BusinessSettingActivity.this,MyGoldenBeanActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(BusinessSettingActivity.this,RecommendActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(BusinessSettingActivity.this,SilverBeanActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(BusinessSettingActivity.this,WithdrawalsActivity.class));
                    break;
                case 6:
                    startActivity(new Intent(BusinessSettingActivity.this,MyProfitActivity.class));
                    break;
                case 7:
                    startActivity(new Intent(BusinessSettingActivity.this,BusinessTurnoverActivity.class));
                    break;
                case 8:
                    startActivity(new Intent(BusinessSettingActivity.this,ConsumptionRecordActivity.class));
                    break;
                case 9:
                    startActivity(new Intent(BusinessSettingActivity.this,RecordListActivity.class));
                    break;
                case 10:
                    startActivity(new Intent(BusinessSettingActivity.this,EntrepreneurialDonationActivity.class));
                    break;
                case 11:
                    startActivity(new Intent(BusinessSettingActivity.this,CommodityManagementActivity.class));
                    break;
                case 12:
                    startActivity(new Intent(BusinessSettingActivity.this,PromotionLuckDrawActivity.class));
                    break;
                case 13:
                    startActivity(new Intent(BusinessSettingActivity.this,HarvestAddressListActivity.class));
                    break;
                case 14:
                    startActivity(new Intent(BusinessSettingActivity.this, OldMemberActivity.class));
                    break;
                case 15:
                    startActivity(new Intent(BusinessSettingActivity.this, MyProductsActivity.class));
                    break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_main_mall:
                startActivity(new Intent(BusinessSettingActivity.this, MainActivity.class));
                break;
            case R.id.rb_main_exit:
                showDialog();
                break;
            case R.id.tv_setting_set:
                startActivity(new Intent(this,SetModifyActivity.class));
                break;
        }
    }

    /**
     * 退出登录
     */
    private void showDialog() {
        new AlertDialog.Builder(this).setTitle("确认退出吗？")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                         startActivity(new Intent(BusinessSettingActivity.this,MainActivity.class));

                    }
                })
                .setNegativeButton("返回", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                        finish();
                    }
                }).show();
// super.onBackPressed();
    }

}
