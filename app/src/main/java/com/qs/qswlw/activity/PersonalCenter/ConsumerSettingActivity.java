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
import android.widget.RelativeLayout;
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
import com.qs.qswlw.utils.RoleJudgeUtil;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.webviewpb.WebviewActivity;


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
    private RelativeLayout rl_setting_consumptionMoney;
    private ImageView iv_setting_news;
    private String shop_order,cash_money,cons_gold,my_shop;
    /**
     * 设置数据
     * @param personalSettingBean
     */
    @Override
    public void setUserInfo(PersonalSettingBean personalSettingBean) {
        PersonalSettingBean.UserInfoBean user_info = personalSettingBean.getUser_info();
        tv_cyzx.setText("创业中心:"+personalSettingBean.getCyzx_info().getNickname());
        tv_recommender.setText("推荐人:"+personalSettingBean.getRe_info().getNickname());
        tv_setting_id.setText("ID:"+user_info.getUser_id());
        tv_setting_name.setText("昵称:"+user_info.getNickname());

        tv_setting_consumptionMoney.setText(personalSettingBean.getNone()+"");
        tv_setting_consumerSilverbeans.setText(user_info.getSilver_total()+"");
        tv_setting_encourage.setText(user_info.getLove_total()+"");
        tv_setting_withdrawals.setText(user_info.getGold_total()+"");
        tv_setting_consumerbeans.setText(user_info.getTaxgold_total()+"");
        tv_setting_paytaxes.setText(user_info.getLoveval_model2_xfz()+"");
        //商城订单
        shop_order = personalSettingBean.getShop_order();
        cash_money  = personalSettingBean.getCash_money();//现金
        cons_gold = personalSettingBean.getCons_gold();//消费金豆
        MyApplication.ID =  user_id = user_info.getUser_id();
        MyApplication.NICKNAME = nickname = user_info.getNickname();
        MyApplication.MOBILE =  mobile =user_info.getMobile();
        MyApplication.CYZXID = user_info.getCyzx_id();
        role = personalSettingBean.getUser_info().getRole();
        MyApplication.QSSHOP = personalSettingBean.getQs_shop();
        MyApplication.QSCAT = personalSettingBean.getQs_cat();
        MyApplication.QSCART = personalSettingBean.getQs_cart();
        MyApplication.QSMINE = personalSettingBean.getQs_mine();
        //会员身份
        role = user_info.getRole();
        tv_role.setText( RoleJudgeUtil.roleJudeg(role));

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
        rl_setting_consumptionMoney = (RelativeLayout) findViewById(R.id.rl_setting_consumptionMoney);


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
        iv_setting_news = (ImageView) findViewById(R.id.iv_setting_news);
        RadioButtonImgUtil.setRadioButtonImg(this,rb_main_qsmall,rb_main_lianmeng,rb_main_funtime,rb_main_luck,rb_main_exit);


    }

    @Override
    public void initData() {
        super.initData();
        rl_setting_consumptionMoney.setVisibility(View.GONE);
        tv_cyzx.setVisibility(View.GONE);
        tv_recommender.setVisibility(View.GONE);
        consumerSettingAdapter = new ConsumerSettingAdapter(this);
        String token = UserManage.getInstance().getUserInfo(ConsumerSettingActivity.this).getToken();
        MyApplication.TOKEN = token;
        personalSettingPresenter.getData(token);
        gv_setting.setAdapter(consumerSettingAdapter);
    }

    @Override
    public void setOnclick() {
        gv_setting.setOnItemClickListener(this);
        rb_main_qsmall.setOnClickListener(this);
        rb_main_lianmeng.setOnClickListener(this);
        rb_main_funtime.setOnClickListener(this);
        rb_main_luck.setOnClickListener(this);
        rb_main_exit.setOnClickListener(this);
        iv_setting_set.setOnClickListener(this);
        iv_setting_news.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rb_main_qsmall:
                intent  = new Intent(ConsumerSettingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("setting", "setting");
                startActivity(intent);
                break;
            case R.id.rb_main_lianmeng:
                intent = new Intent(this, WebviewActivity.class);
                intent.putExtra("qs_shop",MyApplication.QSSHOP+"&token="+MyApplication.TOKEN);
                startActivity(this.intent);
                break;
            case R.id.rb_main_funtime:
                intent = new Intent(this, WebviewActivity.class);
                intent.putExtra("qs_fun",MyApplication.QSFUN+"&token="+MyApplication.TOKEN);
                startActivity(this.intent);
                break;
            case R.id.rb_main_luck:
                intent = new Intent(this, WebviewActivity.class);
                intent.putExtra("qs_lack_draw",MyApplication.QSLACK+"&token="+MyApplication.TOKEN);
                startActivity(this.intent);
                break;
            case R.id.rb_main_exit:
                showDialog();
                break;
            case R.id.iv_setting_set:
                startActivity(new Intent(this,SetModifyActivity.class));
                break;
            case R.id.iv_setting_news:
                startActivity(new Intent(this,SettingNewActivity.class));
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
                Intent intent1 = new Intent(ConsumerSettingActivity.this, ConsumptionRecordActivity1.class);
                startActivity(intent1);
                break;
            case 1:
                intent = new Intent(this,RecommendActivity.class);
                intent.putExtra("userid",user_id);
                intent.putExtra("nickname",nickname);
                intent.putExtra("role",role);
                startActivity(intent);
                break;
            case 2:
                startActivity(new Intent(ConsumerSettingActivity.this, RecordListActivity.class));
                break;
            case 3:
                intent = new Intent(ConsumerSettingActivity.this, WebviewActivity.class);
                intent.putExtra("shop_order",shop_order+"&token="+MyApplication.TOKEN );
                startActivity(this.intent);
                break;
            case 4:
                intent = new Intent(ConsumerSettingActivity.this, WebviewActivity.class);
                intent.putExtra("qs_ziying",MyApplication.QSZY+MyApplication.TOKEN);
                startActivity(this.intent);
                break;
            case 5:
                intent = new Intent(ConsumerSettingActivity.this, WebviewActivity.class);
                intent.putExtra("cash_money",cash_money);
                startActivity(this.intent);
                break;
            case 6:
                intent = new Intent(ConsumerSettingActivity.this, WebviewActivity.class);
                intent.putExtra("cons_gold",cons_gold);
                startActivity(this.intent);
                break;
            case 7:
                startActivity(new Intent(ConsumerSettingActivity.this, ReceivingAddress1Activity.class));
                break;
            case 8:
                startActivity(new Intent(ConsumerSettingActivity.this, MySilverBeanActivity.class));
                break;
            case 9:
                startActivity(new Intent(ConsumerSettingActivity.this, EntrepreneurialSeedActivity.class));
                break;
            case 10:
                startActivity(new Intent(ConsumerSettingActivity.this, VenturegoldBeansActivity.class));
                break;
            case 11:
                startActivity(new Intent(ConsumerSettingActivity.this, MyBonusActivity.class));
                break;
            case 12:
                startActivity(new Intent(ConsumerSettingActivity.this, WithdrawalsActivity.class));
                break;
            case 13:

                break;
            case 14:
                startActivity(new Intent(ConsumerSettingActivity.this, MyRoleActivity.class));
                break;
            case 15:
                intent = new Intent(ConsumerSettingActivity.this, WebviewActivity.class);
                intent.putExtra("qs_comment",MyApplication.QSCOMMENT+"&token="+MyApplication.TOKEN);
                startActivity(this.intent);
                break;
        }
    }


}
