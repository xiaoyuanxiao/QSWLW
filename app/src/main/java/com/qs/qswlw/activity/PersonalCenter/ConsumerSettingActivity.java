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
import com.qs.qswlw.adapter.ConsumerSettingAdapter;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.okhttp.Iview.IPersonalSettingView;
import com.qs.qswlw.okhttp.Presenter.PersonalSettingPresenter;


/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ConsumerSettingActivity extends BaseActivity implements AdapterView.OnItemClickListener, IPersonalSettingView {
    private GridView gv_setting;
    private TextView tv_setting_set;
    private ConsumerSettingAdapter consumerSettingAdapter;
    private RadioButton rb_setting_exit, rb_setting_partner, rb_setting_beans, rb_setting_mall;
    PersonalSettingPresenter personalSettingPresenter = new PersonalSettingPresenter(this);
    private TextView tv_setting_consumptionMoney,tv_setting_consumerSilverbeans,tv_setting_encourage,tv_setting_withdrawals,tv_setting_consumerbeans,tv_setting_paytaxes
            ;

    /**
     * 设置数据
     * @param personalSettingBean
     */
    @Override
    public void setUserInfo(PersonalSettingBean personalSettingBean) {
        tv_setting_consumptionMoney.setText(personalSettingBean.getUser_info().getTaxgold_total()+"");
        tv_setting_consumerSilverbeans.setText(personalSettingBean.getUser_info().getSilver_total()+"");
        tv_setting_encourage.setText(personalSettingBean.getUser_info().getLove_total()+"");
        tv_setting_withdrawals.setText(personalSettingBean.getUser_info().getGold_total()+"");
        tv_setting_consumerbeans.setText(personalSettingBean.getUser_info().getGold_total()+"");
        tv_setting_paytaxes.setText(personalSettingBean.getLast_rebate_date()+"");

    }


    @Override
    public Object initView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initfindviewByid() {
        gv_setting = (GridView) findViewById(R.id.gv_setting);
        tv_setting_set = (TextView) findViewById(R.id.tv_setting_set);
        rb_setting_exit = (RadioButton) findViewById(R.id.rb_main_exit);
        rb_setting_partner = (RadioButton) findViewById(R.id.rb_main_funtime);
        rb_setting_beans = (RadioButton) findViewById(R.id.rb_main_beans);
        rb_setting_mall = (RadioButton) findViewById(R.id.rb_main_mall);


        tv_setting_withdrawals = (TextView) findViewById(R.id.tv_setting_withdrawals);
        tv_setting_consumptionMoney = (TextView) findViewById(R.id.tv_setting_consumptionMoney);
        tv_setting_consumerSilverbeans = (TextView) findViewById(R.id.tv_setting_consumerSilverbeans);
        tv_setting_encourage = (TextView) findViewById(R.id.tv_setting_encourage);
        tv_setting_consumerbeans = (TextView) findViewById(R.id.tv_setting_consumerbeans);
        tv_setting_paytaxes = (TextView) findViewById(R.id.tv_setting_paytaxes);


    }

    @Override
    public void initData() {
        super.initData();// 这些你不用管 是下面gridview的  你不用每个看 能不懂了嘛
        consumerSettingAdapter = new ConsumerSettingAdapter(this);
        //wuyu
        Intent intent = getIntent();
        String token = intent.getStringExtra("token");
        personalSettingPresenter.getData(token);
        gv_setting.setAdapter(consumerSettingAdapter);
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(this);
        tv_setting_set.setOnClickListener(this);
        rb_setting_exit.setOnClickListener(this);
        rb_setting_beans.setOnClickListener(this);
        rb_setting_partner.setOnClickListener(this);
        rb_setting_mall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_setting_set:
                startActivity(new Intent(this, SetModifyActivity.class));
                break;
            case R.id.rb_main_exit:
                showDialog();
                break;
            case R.id.rb_main_beans:
                startActivity(new Intent(this, VenturegoldBeansActivity.class));
                break;
            case R.id.rb_main_funtime:
                startActivity(new Intent(this, MyPartnerActivity.class));
                break;
            case R.id.rb_main_mall:
                startActivity(new Intent(this, MainActivity.class));
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
                        startActivity(new Intent(ConsumerSettingActivity.this, MainActivity.class));

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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(new Intent(this, VenturegoldBeansActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, VenturegoldBeansActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, ConsumerSilverBeanActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, MyGoldActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, MyInvestActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, ConsumerEntrepreneurialSeedActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, RecommendActivity.class));
                break;
            case 7:
                startActivity(new Intent(this, ConsumeWithdrawalsActivity.class));
                break;
            case 8:
                startActivity(new Intent(this, MallOrdersActivity.class));
                break;
            case 9:
                startActivity(new Intent(this, EntrepreneurialDonationActivity.class));
                break;
            case 10:
                startActivity(new Intent(this, DonationActivity.class));
                break;
            case 11:
                startActivity(new Intent(this, PromotionalLotteryActivity.class));
                break;
            case 12:
                startActivity(new Intent(this, ReceivingAddressActivity.class));
                break;
        }
    }


}
