package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
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
import com.qs.qswlw.adapter.ConsumerSettingAdapter;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.manager.UserManage;
import com.qs.qswlw.okhttp.Iview.IPersonalSettingView;
import com.qs.qswlw.okhttp.Presenter.PersonalSettingPresenter;
import com.qs.qswlw.utils.RadioButtonImgUtil;
import com.qs.qswlw.utils.ToastUtils;


/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ConsumerSettingActivity extends BaseActivity implements AdapterView.OnItemClickListener, IPersonalSettingView {
    PersonalSettingPresenter personalSettingPresenter = new PersonalSettingPresenter(this);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(ConsumerSettingActivity.this,LoginActivity.class));
            finish();
        }
    };
    private GridView gv_setting;
    private ImageView iv_setting_set;
    private ConsumerSettingAdapter consumerSettingAdapter;
    private RadioButton rb_main_qsmall,rb_main_lianmeng,rb_main_funtime,rb_main_luck,rb_main_exit;
    private TextView tv_setting_consumptionMoney,tv_setting_consumerSilverbeans,tv_setting_encourage,tv_setting_withdrawals,tv_setting_consumerbeans,
            tv_setting_paytaxes,tv_cyzx,tv_recommender,tv_setting_id,tv_setting_name,tv_role;
    private TextView setting_one;
    private String user_id,nickname,role,mobile;
    private Intent intent;

    /**
     * 设置数据
     * @param personalSettingBean
     */
    @Override
    public void setUserInfo(PersonalSettingBean personalSettingBean) {
        tv_cyzx.setText("创业中心:"+personalSettingBean.getCyzx_info().getNickname());
        tv_recommender.setText("推荐人:"+personalSettingBean.getRe_info().getNickname());
        tv_setting_id.setText("ID:"+personalSettingBean.getUser_info().getUser_id());
        tv_setting_name.setText("昵称:"+personalSettingBean.getUser_info().getNickname());

        tv_setting_consumptionMoney.setText(personalSettingBean.getNone()+"");
        tv_setting_consumerSilverbeans.setText(personalSettingBean.getUser_info().getSilver_total()+"");
        tv_setting_encourage.setText(personalSettingBean.getUser_info().getLove_total()+"");
        tv_setting_withdrawals.setText(personalSettingBean.getUser_info().getGold_total()+"");
        tv_setting_consumerbeans.setText(personalSettingBean.getUser_info().getTaxgold_total()+"");
        tv_setting_paytaxes.setText(personalSettingBean.getLast_rebate_date()+"");

        MyApplication.ID =  user_id = personalSettingBean.getUser_info().getUser_id();
        MyApplication.NICKNAME = nickname = personalSettingBean.getUser_info().getNickname();
        MyApplication.MOBILE =  mobile = personalSettingBean.getUser_info().getMobile();
        role = personalSettingBean.getUser_info().getRole();
        if(role.equals("0")){
            tv_role.setText("消费天使");
            MyApplication.USERROLE = "消费天使";
        }else if(role.equals("10")){
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
        iv_setting_set = (ImageView) findViewById(R.id.iv_setting_set);
        rb_main_qsmall = (RadioButton) findViewById(R.id.rb_main_qsmall);
        rb_main_lianmeng = (RadioButton) findViewById(R.id.rb_main_lianmeng);
        rb_main_funtime = (RadioButton) findViewById(R.id.rb_main_funtime);
        rb_main_luck = (RadioButton) findViewById(R.id.rb_main_luck);
        rb_main_exit = (RadioButton) findViewById(R.id.rb_main_exit);


        tv_setting_withdrawals = (TextView) findViewById(R.id.tv_setting_withdrawals);
        tv_setting_consumptionMoney = (TextView) findViewById(R.id.tv_setting_consumptionMoney);
        tv_setting_consumerSilverbeans = (TextView) findViewById(R.id.tv_setting_consumerSilverbeans);
        tv_setting_encourage = (TextView) findViewById(R.id.tv_setting_encourage);
        tv_setting_consumerbeans = (TextView) findViewById(R.id.tv_setting_consumerbeans);
        tv_setting_paytaxes = (TextView) findViewById(R.id.tv_setting_paytaxes);
        setting_one = (TextView) findViewById(R.id.setting_one);
        tv_role = (TextView) findViewById(R.id.tv_role);

        tv_cyzx = (TextView) findViewById(R.id.tv_cyzx);
        tv_recommender = (TextView) findViewById(R.id.tv_recommender);
        tv_setting_id = (TextView) findViewById(R.id.tv_setting_id);
        tv_setting_name = (TextView) findViewById(R.id.tv_setting_name);
        RadioButtonImgUtil.setRadioButtonImg(this,rb_main_qsmall,rb_main_lianmeng,rb_main_funtime,rb_main_luck,rb_main_exit);


    }

    @Override
    public void initData() {
        super.initData();// 这些你不用管 是下面gridview的  你不用每个看 能不懂了嘛
        consumerSettingAdapter = new ConsumerSettingAdapter(this);
        String token = UserManage.getInstance().getUserInfo(ConsumerSettingActivity.this).getToken();
        MyApplication.TOKEN = token;
        personalSettingPresenter.getData(token);
        gv_setting.setAdapter(consumerSettingAdapter);
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(this);
        iv_setting_set.setOnClickListener(this);
        rb_main_qsmall.setOnClickListener(this);
        rb_main_lianmeng.setOnClickListener(this);
        rb_main_funtime.setOnClickListener(this);
        rb_main_luck.setOnClickListener(this);
        rb_main_exit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rb_main_qsmall:
                startActivity(new Intent(ConsumerSettingActivity.this, MainActivity.class));
                break;
            case R.id.rb_main_lianmeng:
                showDialog();
                break;
            case R.id.rb_main_funtime:
                startActivity(new Intent(this,SetModifyActivity.class));
                break;
            case R.id.rb_main_luck:
                showDialog();
                break;
            case R.id.rb_main_exit:
                showDialog();
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
                        UserManage.getInstance().clearUserInfo(ConsumerSettingActivity.this);
                        startActivity(new Intent(ConsumerSettingActivity.this, LoginActivity.class));
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                intent = new Intent(this,RecommendActivity.class);
                intent.putExtra("userid",user_id);
                intent.putExtra("nickname",nickname);
                intent.putExtra("role",role);
                startActivity(intent);
                break;
            case 1:

                break;
            case 2:
                break;
            case 3:

                break;
            case 4:
                startActivity(new Intent(this,ScanCodeRecordActivity.class));
                break;
            case 5:

                break;
            case 6:
                startActivity(new Intent(this,MySpendingLimitActivity.class));
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
                break;
            case 13:

                break;
            case 14:
                startActivity(new Intent(this,MySilverBeanActivity.class));
                break;
            case 15:
                startActivity(new Intent(this,EntrepreneurialSeedActivity.class));
                break;
            case 16:
                startActivity(new Intent(this,VenturegoldBeansActivity.class));
                break;
            case 17:
                startActivity(new Intent(this,WithdrawalsActivity.class));
                break;
            case 18:

                break;
            case 19:

                break;
            case 20:

                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                startActivity(new Intent(this,OldMemberActivity.class));
                break;
            case 24:
                startActivity(new Intent(this,MyRoleActivity.class));
                break;
        }
    }


}
