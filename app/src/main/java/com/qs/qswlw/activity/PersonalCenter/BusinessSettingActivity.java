package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.LoginActivity;
import com.qs.qswlw.activity.MainActivity;
import com.qs.qswlw.activity.mall.QSMallActivity;
import com.qs.qswlw.adapter.BusinessSettingAdapter;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.manager.UserManage;
import com.qs.qswlw.okhttp.Iview.IPersonalSettingView;
import com.qs.qswlw.okhttp.Presenter.PersonalSettingPresenter;
import com.qs.qswlw.utils.RadioButtonImgUtil;
import com.qs.qswlw.utils.ToastUtils;


/**
 * Created by 小羽 on 2017/3/24.
 */
public class BusinessSettingActivity extends BaseActivity implements IPersonalSettingView {

    PersonalSettingPresenter personalSettingPresenter = new PersonalSettingPresenter(this);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(BusinessSettingActivity.this, LoginActivity.class));
            finish();
        }
    };
    private GridView gv_setting;
    private RadioButton rb_main_qsmall, rb_main_lianmeng, rb_main_funtime, rb_main_luck, rb_main_exit;
    private BusinessSettingAdapter businessSettingAdapter;
    private ImageView iv_setting_set;
    private TextView tv_setting_consumptionMoney, tv_setting_consumerSilverbeans, tv_setting_encourage, tv_setting_withdrawals, tv_setting_consumerbeans, tv_setting_paytaxes, tv_cyzx, tv_recommender, tv_setting_id, tv_setting_name, tv_setting_shopname, tv_role;
    private TextView setting_one;
    private String user_id, nickname, role;
    private String mobile;
    private String shopName;

    @Override
    public void setUserInfo(PersonalSettingBean personalSettingBean) {
        // tv_cyzx.setText("创业中心:"+personalSettingBean.getCyzx_info().getNickname());
        tv_recommender.setText("推荐人:" + personalSettingBean.getRe_info().getNickname());
        tv_setting_id.setText("ID:" + personalSettingBean.getUser_info().getUser_id());
        tv_setting_name.setText("昵称:" + personalSettingBean.getUser_info().getNickname());
   //     shopName = personalSettingBean.getShop().getName();
//        tv_setting_shopname.setText("店铺名称:" + shopName);

        tv_setting_consumptionMoney.setText("0");
        tv_setting_consumerSilverbeans.setText(personalSettingBean.getUser_info().getSilver_total() + "");
        tv_setting_encourage.setText(personalSettingBean.getUser_info().getLove_total() + "");
        tv_setting_withdrawals.setText(personalSettingBean.getUser_info().getGold_total() + "");
        tv_setting_consumerbeans.setText(personalSettingBean.getUser_info().getTaxgold_total() + "");
        tv_setting_paytaxes.setText(personalSettingBean.getLoveval_model2_shop() + "");
        MyApplication.MOBILE = mobile = personalSettingBean.getUser_info().getMobile();
        MyApplication.ID = user_id = personalSettingBean.getUser_info().getUser_id();
        MyApplication.NICKNAME = nickname = personalSettingBean.getUser_info().getNickname();
        //会员身份
        role = personalSettingBean.getUser_info().getRole();
        if (role.equals("0")) {
            tv_role.setText("消费天使");
            MyApplication.USERROLE = "消费天使";
        } else if (role.equals("8")) {
            tv_role.setText("创业董事");
            MyApplication.USERROLE = "创业董事";
        }else if (role.equals("10")) {
            tv_role.setText("商家");
            MyApplication.USERROLE = "商家";
        }else if(role.equals("11")){
            tv_role.setText("创业天使");
            MyApplication.USERROLE = "创业天使";
        }else if(role.equals("12")){
            tv_role.setText("省代");
            MyApplication.USERROLE = "省代";
        }else if(role.equals("13")){
            tv_role.setText("市代");
            MyApplication.USERROLE = "市代";
        }else if(role.equals("14")){
            tv_role.setText("区代");
            MyApplication.USERROLE = "区代";
        }else if(role.equals("15")){
            tv_role.setText("创业中心");
            MyApplication.USERROLE = "创业中心";
        }else if(role.equals("25")){
            tv_role.setText("平台");
            MyApplication.USERROLE = "平台";
        }


    }

    @Override
    public void setTokenFail() {
        ToastUtils.showToast("token失效请重新登录");
        new Handler().postDelayed(runnable, 2000);
    }

    @Override
    public Object initView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initfindviewByid() {
        gv_setting = (GridView) findViewById(R.id.gv_setting);
        rb_main_qsmall = (RadioButton) findViewById(R.id.rb_main_qsmall);
        rb_main_lianmeng = (RadioButton) findViewById(R.id.rb_main_lianmeng);
        rb_main_funtime = (RadioButton) findViewById(R.id.rb_main_funtime);
        rb_main_luck = (RadioButton) findViewById(R.id.rb_main_luck);
        rb_main_exit = (RadioButton) findViewById(R.id.rb_main_exit);
        iv_setting_set = (ImageView) findViewById(R.id.iv_setting_set);
        tv_setting_withdrawals = (TextView) findViewById(R.id.tv_setting_withdrawals);
        tv_setting_consumptionMoney = (TextView) findViewById(R.id.tv_setting_consumptionMoney);
        tv_setting_consumerSilverbeans = (TextView) findViewById(R.id.tv_setting_consumerSilverbeans);
        tv_setting_encourage = (TextView) findViewById(R.id.tv_setting_encourage);
        tv_setting_consumerbeans = (TextView) findViewById(R.id.tv_setting_consumerbeans);
        tv_setting_paytaxes = (TextView) findViewById(R.id.tv_setting_paytaxes);
        tv_cyzx = (TextView) findViewById(R.id.tv_cyzx);
        tv_recommender = (TextView) findViewById(R.id.tv_recommender);
        tv_setting_id = (TextView) findViewById(R.id.tv_setting_id);
        tv_setting_name = (TextView) findViewById(R.id.tv_setting_name);
        tv_setting_shopname = (TextView) findViewById(R.id.tv_setting_shopname);
        tv_role = (TextView) findViewById(R.id.tv_role);
        setting_one = (TextView) findViewById(R.id.setting_one);
        RadioButtonImgUtil.setRadioButtonImg(this, rb_main_qsmall, rb_main_lianmeng, rb_main_funtime, rb_main_luck, rb_main_exit);

    }

    @Override
    public void initData() {
        super.initData();
        tv_setting_shopname.setVisibility(View.VISIBLE);
        String token = UserManage.getInstance().getUserInfo(BusinessSettingActivity.this).getToken();
        MyApplication.TOKEN = token;
        Log.e("token",token);
        personalSettingPresenter.getData(token);
        businessSettingAdapter = new BusinessSettingAdapter(this);
        gv_setting.setAdapter(businessSettingAdapter);
        setting_one.setText("代缴让利");
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(new ItemClickListener());
        rb_main_qsmall.setOnClickListener(this);
        rb_main_lianmeng.setOnClickListener(this);
        rb_main_funtime.setOnClickListener(this);
        rb_main_luck.setOnClickListener(this);
        rb_main_exit.setOnClickListener(this);
        iv_setting_set.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_main_qsmall:
                Intent intent = new Intent(BusinessSettingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("setting", "setting");
                startActivity(intent);
                break;
            case R.id.rb_main_lianmeng:
                startActivity(new Intent(this, QSMallActivity.class));
                break;
            case R.id.rb_main_funtime:
                startActivity(new Intent(this, SetModifyActivity.class));
                break;
            case R.id.rb_main_luck:
                showDialog();
                break;
            case R.id.rb_main_exit:
                showDialog();
                break;
            case R.id.iv_setting_set:
                startActivity(new Intent(this,SetModifyActivity.class));
                break;
        }
    }

    /**
     * 退出登录
     */
    private void showDialog() {
        new AlertDialog.Builder(this).setTitle("确认退出吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserManage.getInstance().clearUserInfo(BusinessSettingActivity.this);
                        startActivity(new Intent(BusinessSettingActivity.this, LoginActivity.class));
                        finish();

                    }
                })
                .setNegativeButton("返回", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 103) {
            if (requestCode == 102) {
                String msg = data.getStringExtra("msg");
                //设置结果显示框的显示数值
                //   ToastUtils.showToast(this,msg);
                //进入新界面
                Intent intent = new Intent(BusinessSettingActivity.this, ConsumptionDialogActivity.class);
                intent.putExtra("dialog", msg);
                startActivity(intent);
            }
        }
    }

    class ItemClickListener implements AdapterView.OnItemClickListener {

        private Intent intent;

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 0:
                    intent = new Intent(BusinessSettingActivity.this, RecommendActivity.class);
                    intent.putExtra("userid", user_id);
                    intent.putExtra("nickname", nickname);
                    intent.putExtra("shopname", shopName);
                    intent.putExtra("role", role);
                    intent.putExtra("position", "position");
                    startActivity(intent);
                    break;
                case 1:
                    startActivity(new Intent(BusinessSettingActivity.this, ScanCodeRecordActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(BusinessSettingActivity.this, MerchantAuditActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(BusinessSettingActivity.this, MerchantSalesReviewActivity.class));
                    break;
                case 4:
                    intent = new Intent(BusinessSettingActivity.this, RecommendActivity.class);
                    intent.putExtra("userid", user_id);
                    intent.putExtra("nickname", nickname);
                    intent.putExtra("role", role);
                    startActivity(intent);
                    break;
                case 5:
                    Intent intent1 = new Intent(BusinessSettingActivity.this, ConsumptionRecordActivity.class);
                    startActivityForResult(intent1, 102);
                    break;
                case 6:
                    startActivity(new Intent(BusinessSettingActivity.this, RecordListActivity.class));
                    break;
                case 7:
                    startActivity(new Intent(BusinessSettingActivity.this, MyProfitActivity.class));
                    break;
                case 8:
                    startActivity(new Intent(BusinessSettingActivity.this, ImproveDocumentationActivity.class));
                    break;
                case 9:
                    startActivity(new Intent(BusinessSettingActivity.this, CommodityManagementActivity.class));
                    break;
                case 10:
                    startActivity(new Intent(BusinessSettingActivity.this, ConsumptionLimitActivity.class));
                    break;
                case 11:
                    startActivity(new Intent(BusinessSettingActivity.this, MyMallActivity.class));
                    break;
                case 12:
                    startActivity(new Intent(BusinessSettingActivity.this, BusinessTurnoverActivity.class));
                    break;
                case 13:
                    startActivity(new Intent(BusinessSettingActivity.this, ComplimentaryMerchandiseRecordActivity.class));
                    break;
                case 14:
                    startActivity(new Intent(BusinessSettingActivity.this, MySilverBeanActivity.class));
                    break;
                case 15:
                    startActivity(new Intent(BusinessSettingActivity.this, EntrepreneurialSeedActivity.class));
                    break;
                case 16:
                    startActivity(new Intent(BusinessSettingActivity.this, VenturegoldBeansActivity.class));
                    break;
                case 17:
                    startActivity(new Intent(BusinessSettingActivity.this, WithdrawalsActivity.class));
                    break;
                case 18:
                    startActivity(new Intent(BusinessSettingActivity.this, MyShoppingActivity.class));
                    break;
                case 19:
                    //  startActivity(new Intent(BusinessSettingActivity.this, ReceivingAddressActivity.class));
                    startActivity(new Intent(BusinessSettingActivity.this, ReceivingAddress1Activity.class));
                    break;
                case 20:
                    startActivity(new Intent(BusinessSettingActivity.this, NoConsumptionBeansActivity.class));
                    break;
                case 21:
                    startActivity(new Intent(BusinessSettingActivity.this, NoConsumptionBeansActivity.class));
                    break;
                case 22:
                    startActivity(new Intent(BusinessSettingActivity.this, MySpendingLimitActivity.class));
                    break;
                case 23:
                    startActivity(new Intent(BusinessSettingActivity.this, MyMallSettingActivity.class));
                    break;
                case 24:
                    startActivity(new Intent(BusinessSettingActivity.this, DonationActivity.class));
                    break;
                case 25:
                    // startActivity(new Intent(BusinessSettingActivity.this, HarvestAddressListActivity.class));
                    break;
                case 26:
                    // startActivity(new Intent(BusinessSettingActivity.this, ScanCodeRecordActivity.class));
                    break;
                case 27:
                    startActivity(new Intent(BusinessSettingActivity.this, EntrepreneurialDonationActivity.class));
                    break;
                case 28:
                    startActivity(new Intent(BusinessSettingActivity.this, OldMemberActivity.class));
                    break;
                case 29:
                    startActivity(new Intent(BusinessSettingActivity.this, MyRoleActivity.class));
                    break;
                case 30:
                    startActivity(new Intent(BusinessSettingActivity.this, MyInvestActivity.class));
                    break;
                case 31:
                    //    startActivity(new Intent(BusinessSettingActivity.this, MySpendingLimitActivity.class));
                    break;
                case 32:
                    startActivity(new Intent(BusinessSettingActivity.this, PromotionLuckDrawActivity.class));
                    break;
                case 33:
                    //    startActivity(new Intent(BusinessSettingActivity.this, MySpendingLimitActivity.class));
                    break;
            }
        }
    }
}
