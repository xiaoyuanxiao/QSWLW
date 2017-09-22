package com.qs.qswlw.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.*;
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
   // LoginPresenter loginPresenter = new LoginPresenter(this);
    private Button btn_login;
    private EditText edt_username,edt_password;
    private TextView tv_newuser_register,tv_forgetPassword;


    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_login, null);
        btn_login = (Button) inflate.findViewById(R.id.btn_login);
        edt_username = (EditText) inflate.findViewById(R.id.edt_username);
        edt_password = (EditText) inflate.findViewById(R.id.edt_password);
        tv_newuser_register = (TextView) inflate.findViewById(R.id.tv_newuser_register);
        tv_forgetPassword = (TextView) inflate.findViewById(R.id.tv_forgetPassword);
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

    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_login.setOnClickListener(this);
        tv_newuser_register.setOnClickListener(this);
        tv_forgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.btn_login:
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
              //  loginPresenter.getLogin(username,password);
                getLogin(username,password);
                break;
            case R.id.tv_newuser_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;

            case R.id.tv_forgetPassword:
                startActivity(new Intent(this,ForgetPasswordActivity.class));
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
                //请求个人中心接口
                Intent intent = new Intent();
                intent.putExtra("token",token);
                if (role.equals("0")) {
                    intent.setClass(LoginActivity.this,ConsumerSettingActivity.class);
                    startActivity(intent);
                } else if (role.equals("10")) {
                    intent.setClass(LoginActivity.this,BusinessSettingActivity.class);
                    startActivity(intent);
                } else {
                    //其他页面
                    intent.setClass(LoginActivity.this, OtherUserSettingActivity.class);
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
