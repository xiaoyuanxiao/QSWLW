package com.qs.qswlw.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.okhttp.Iview.ILoginView;
import com.qs.qswlw.okhttp.Moudle.LoginBean;
import com.qs.qswlw.okhttp.Presenter.LoginPresenter;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class LoginActivity extends BaseInfoActivity implements ILoginView {
    LoginPresenter loginPresenter = new LoginPresenter(this);
    private Button btn_login;
    private EditText edt_username,edt_password;
    private TextView tv_newuser_register;


    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_login, null);
        btn_login = (Button) inflate.findViewById(R.id.btn_login);
        edt_username = (EditText) inflate.findViewById(R.id.edt_username);
        edt_password = (EditText) inflate.findViewById(R.id.edt_password);
        tv_newuser_register = (TextView) inflate.findViewById(R.id.tv_newuser_register);
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
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.btn_login:
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                loginPresenter.getLogin(username,password);
                break;
            case R.id.tv_newuser_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }


    @Override
    public void setLogin(LoginBean logininfo) {

    }
}
