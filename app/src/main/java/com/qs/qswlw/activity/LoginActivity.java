package com.qs.qswlw.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.activity.PersonalCenter.BusinessSettingActivity;
import com.qs.qswlw.activity.PersonalCenter.ConsumerSettingActivity;
import com.qs.qswlw.bean.LoginBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.manager.UserManage;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.ToastUtils;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class LoginActivity extends BaseInfoActivity {
    private Button btn_login;
    private EditText edt_username,edt_password;
    private TextView tv_newuser_register,tv_forgetPassword;
    private RelativeLayout rl_login;
    private CheckBox cb_login;
    private SharedPreferences sp = null;



    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_login, null);
        sp = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        btn_login = (Button) inflate.findViewById(R.id.btn_login);
        edt_username = (EditText) inflate.findViewById(R.id.edt_username);
        edt_password = (EditText) inflate.findViewById(R.id.edt_password);
        rl_login = (RelativeLayout) inflate.findViewById(R.id.rl_login);
        tv_newuser_register = (TextView) inflate.findViewById(R.id.tv_newuser_register);
        tv_forgetPassword = (TextView) inflate.findViewById(R.id.tv_forgetPassword);
        cb_login = (CheckBox) inflate.findViewById(R.id.cb_login);
        return inflate;
    }


    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("登录");
        tv_titlebar_center.setTextColor(this.getResources().getColor(R.color.white));
        title.setBackgroundColor(this.getResources().getColor(R.color.red));
    }

    @Override
    public void initData() {
        super.initData();
        if (sp.getBoolean("checkboxBoolean", false))
        {
            edt_username.setText(sp.getString("uname", null));
            edt_password.setText(sp.getString("upswd", null));
            cb_login.setChecked(true);

        }
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_login.setOnClickListener(this);
        tv_newuser_register.setOnClickListener(this);
        tv_forgetPassword.setOnClickListener(this);
        rl_login.setOnClickListener(this);
        cb_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.btn_login:
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                boolean CheckBoxLogin = cb_login.isChecked();
                if (CheckBoxLogin)
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("uname", username);
                    editor.putString("upswd", password);
                    editor.putBoolean("checkboxBoolean", true);
                    editor.commit();
                }
                else
                {
                    SharedPreferences.Editor editor = sp.edit();
                 //   editor.putString("uname", null);
                    editor.putString("upswd", null);
                    editor.putBoolean("checkboxBoolean", false);
                    editor.commit();
                }
                getLogin(username,password);
                break;
            case R.id.tv_newuser_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.tv_forgetPassword:
                startActivity(new Intent(this,ForgetPasswordActivity.class));
                break;
            case R.id.rl_login:
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                break;
            case R.id.cb_login:
                break;
        }
    }


    /**
     * 登录接口
     * @param username
     * @param password
     */
    private void getLogin(final String username, final String password) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<LoginBean>>() {


            @Override
            public Observable<MainBean<LoginBean>> getObservable(MyRetroService retrofit) {
                return retrofit.postLogin(username,password);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("login", e + "");
            }

            @Override
            public void onNext(MainBean<LoginBean> loginBeen) {
                if(loginBeen.getSucc()!=1){
                    ToastUtils.showToast(loginBeen.getMsg());
                }
                /**
                 * 保存用户登录信息
                 */
                LoginBean.UserinfoBean userinfo = loginBeen.getResult().getUserinfo();
                UserManage.getInstance().saveUserInfo(LoginActivity.this,userinfo);
                String role = UserManage.getInstance().getUserInfo(LoginActivity.this).getRole();
                String token = userinfo.getToken();
                MyApplication.ID = userinfo.getUser_id();
                //请求个人中心接口
                Intent intent = new Intent();
            //    intent.putExtra("token",token);
                if (role.equals("0")) {
                    intent.setClass(LoginActivity.this,ConsumerSettingActivity.class);
                    startActivity(intent);
                } else {
                    intent.setClass(LoginActivity.this,BusinessSettingActivity.class);
                    startActivity(intent);
                }
                finish();

            }

        });
    }

//
//    @Override
//    public void setLogin(LoginBean logininfo) {
//        Toast.makeText(this,"1111",Toast.LENGTH_LONG).show();
//    }
}
