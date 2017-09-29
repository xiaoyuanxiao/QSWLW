package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.LoginActivity;
import com.qs.qswlw.activity.MainActivity;
import com.qs.qswlw.adapter.OtherUserSettingAdapter;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.manager.UserManage;
import com.qs.qswlw.okhttp.Iview.IPersonalSettingView;
import com.qs.qswlw.okhttp.Presenter.PersonalSettingPresenter;
import com.qs.qswlw.utils.RadioButtonImgUtil;
import com.qs.qswlw.utils.ToastUtils;

/**
 * Created by xiaoyu on 2017/9/7.
 */

public class OtherUserSettingActivity  extends BaseActivity implements IPersonalSettingView {

    PersonalSettingPresenter personalSettingPresenter = new PersonalSettingPresenter(this);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(OtherUserSettingActivity.this,LoginActivity.class));
            finish();
        }
    };
    private GridView gv_setting;
    private RadioButton rb_main_qsmall,rb_main_lianmeng,rb_main_funtime,rb_main_luck,rb_main_exit;
    private OtherUserSettingAdapter otherUserSettingAdapter;
    private TextView tv_setting_set;
    private TextView tv_setting_consumerSilverbeans,tv_setting_encourage,tv_setting_withdrawals,tv_setting_consumerbeans,tv_setting_paytaxes
            ,tv_cyzx,tv_recommender,tv_setting_id,tv_setting_name,tv_role;
    private TextView setting_one,tv_setting_topcount;
    private String user_id,nickname,role;
    private RelativeLayout rl_setting_consumptionMoney;

    @Override
    public Object initView() {

        return View.inflate(this, R.layout.activity_setting, null);
    }

    @Override
    public void initfindviewByid() {
        rl_setting_consumptionMoney = (RelativeLayout) findViewById(R.id.rl_setting_consumptionMoney);
        tv_setting_topcount = (TextView) findViewById(R.id.tv_setting_topcount);
        gv_setting = (GridView) findViewById(R.id.gv_setting);
        rb_main_qsmall = (RadioButton) findViewById(R.id.rb_main_qsmall);
        rb_main_lianmeng = (RadioButton) findViewById(R.id.rb_main_lianmeng);
        rb_main_funtime = (RadioButton) findViewById(R.id.rb_main_funtime);
        rb_main_luck = (RadioButton) findViewById(R.id.rb_main_luck);
        rb_main_exit = (RadioButton) findViewById(R.id.rb_main_exit);
        tv_setting_set = (TextView) findViewById(R.id.tv_setting_set);


        tv_setting_withdrawals = (TextView) findViewById(R.id.tv_setting_withdrawals);
        tv_setting_consumerSilverbeans = (TextView) findViewById(R.id.tv_setting_consumerSilverbeans);
        tv_setting_encourage = (TextView) findViewById(R.id.tv_setting_encourage);
        tv_setting_consumerbeans = (TextView) findViewById(R.id.tv_setting_consumerbeans);
        tv_setting_paytaxes = (TextView) findViewById(R.id.tv_setting_paytaxes);
        tv_cyzx = (TextView) findViewById(R.id.tv_cyzx);
        tv_recommender = (TextView) findViewById(R.id.tv_recommender);
        tv_setting_id = (TextView) findViewById(R.id.tv_setting_id);
        tv_setting_name = (TextView) findViewById(R.id.tv_setting_name);
        tv_role = (TextView) findViewById(R.id.tv_role);
        setting_one = (TextView) findViewById(R.id.setting_one);

        RadioButtonImgUtil.setRadioButtonImg(this,rb_main_qsmall,rb_main_lianmeng,rb_main_funtime,rb_main_luck,rb_main_exit);
    }

    @Override
    public void initData() {
        super.initData();
        rl_setting_consumptionMoney.setVisibility(View.GONE);
        tv_setting_topcount.setVisibility(View.VISIBLE);
        String token = UserManage.getInstance().getUserInfo(OtherUserSettingActivity.this).getToken();
        MyApplication.TOKEN = token;
        personalSettingPresenter.getData(token);
        otherUserSettingAdapter = new OtherUserSettingAdapter(this);
        gv_setting.setAdapter(otherUserSettingAdapter);
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(new ItemClickListener());
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
                startActivity(new Intent(OtherUserSettingActivity.this, MainActivity.class));
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
                        UserManage.getInstance().clearUserInfo(OtherUserSettingActivity.this);
                        startActivity(new Intent(OtherUserSettingActivity.this, LoginActivity.class));
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
    public void setUserInfo(PersonalSettingBean personalSettingBean) {
        tv_cyzx.setText("创业中心:"+personalSettingBean.getCyzx_info().getNickname());
        tv_recommender.setText("推荐人:"+personalSettingBean.getRe_info().getNickname());
        tv_setting_id.setText("ID:"+personalSettingBean.getUser_info().getUser_id());
        tv_setting_name.setText("昵称:"+personalSettingBean.getUser_info().getNickname());

        tv_setting_consumerSilverbeans.setText(personalSettingBean.getUser_info().getSilver_total()+"");
        tv_setting_encourage.setText(personalSettingBean.getUser_info().getLove_total()+"");
        tv_setting_withdrawals.setText(personalSettingBean.getUser_info().getGold_total()+"");
        tv_setting_consumerbeans.setText(personalSettingBean.getUser_info().getTaxgold_total()+"");
        tv_setting_paytaxes.setText(personalSettingBean.getLast_rebate_date()+"");
        MyApplication.ID =  user_id = personalSettingBean.getUser_info().getUser_id();
        MyApplication.NICKNAME = nickname = personalSettingBean.getUser_info().getNickname();
        //会员身份
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

    class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i){
                case 0:
                    startActivity(new Intent(OtherUserSettingActivity.this,VenturegoldBeansActivity.class));
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
                    Intent intent = new Intent(OtherUserSettingActivity.this,RecommendActivity.class);
                    intent.putExtra("userid",user_id);
                    intent.putExtra("nickname",nickname);
                    intent.putExtra("role",role);
                    startActivity(intent);
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
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
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
            }
        }
    }
}
