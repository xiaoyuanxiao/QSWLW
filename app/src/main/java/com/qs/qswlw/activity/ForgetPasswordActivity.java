package com.qs.qswlw.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.bean.ForgetPassWordBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RegisterGetCodeBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.ToastUtils;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class ForgetPasswordActivity extends BaseInfoActivity {
    private Spinner forgetpw_spinner;
    private ArrayAdapter<CharSequence> forgetpw_adapter;
    private String strForgetpw;
    private EditText edt_forgetpw_myphone,edt_register_code,edt_register_password,edt_register_confirmPassword;
    private Button btn_forgetpw_getcode,btn_confirm;
    private int roles;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_forgetpassword, null);
        forgetpw_spinner = (Spinner) inflate.findViewById(R.id.forgetpw_spinner);
        edt_forgetpw_myphone = (EditText) inflate.findViewById(R.id.edt_forgetpw_myphone);
        edt_register_code = (EditText) inflate.findViewById(R.id.edt_register_code);
        edt_register_password = (EditText) inflate.findViewById(R.id.edt_register_password);
        edt_register_confirmPassword = (EditText) inflate.findViewById(R.id.edt_register_confirmPassword);
        btn_forgetpw_getcode = (Button) inflate.findViewById(R.id.btn_forgetpw_getcode);
        btn_confirm = (Button) inflate.findViewById(R.id.btn_confirm);
        loadSpinner();
        return inflate;
    }

    private void loadSpinner() {
        forgetpw_adapter = ArrayAdapter.createFromResource(this, R.array.forgetpw_item, android.R.layout.simple_spinner_item);
        forgetpw_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        forgetpw_spinner.setAdapter(forgetpw_adapter);
        forgetpw_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                forgetpw_spinner.getSelectedItemPosition();
                strForgetpw = forgetpw_spinner.getSelectedItem().toString();
                switch (i){
                    case 1:
                        roles = 0;
                        break;
                    case 2:
                        roles = 10;
                        break;
                    case 3:
                        roles = 11;
                        break;
                    case 4:
                        roles = 12;
                        break;
                    case 5:
                        roles = 13;
                        break;
                    case 6:
                        roles = 14;
                        break;
                    case 7:
                        roles = 15;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("找回密码");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_forgetpw_getcode.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_forgetpw_getcode:
                getCodeData(edt_forgetpw_myphone.getText().toString().trim(),2);
                break;
            case R.id.btn_confirm:
                ConfirmData(edt_forgetpw_myphone.getText().toString().trim(),roles,edt_register_password.getText().toString(),
                        edt_register_confirmPassword.getText().toString(),"1",edt_register_code.getText().toString());
                break;
        }
    }

    /**
     * 修改密码
     */
    private void ConfirmData(final String mobile, final int roles, final String pass, final String repass, final String type, final String code) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ForgetPassWordBean>>(){

            @Override
            public void onError(Throwable e) {
                Log.e("ConfirmData", e + "");
            }

            @Override
            public void onNext(MainBean<ForgetPassWordBean> forgetPassWordBeanMainBean) {
                String message = forgetPassWordBeanMainBean.getMsg();
                    ToastUtils.showToast(ForgetPasswordActivity.this, message);
                if(message.equals("修改成功！")){
                    startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                }
                Log.i("TAG", forgetPassWordBeanMainBean.toString());
            }

            @Override
            public Observable<MainBean<ForgetPassWordBean>> getObservable(MyRetroService retrofit) {
                return retrofit.postForgetPWData(mobile,roles,pass,repass,type,code);
            }
        });

    }

    /**
     * 获取验证码
     *
     * @param number
     */
    private void getCodeData(final String number,final int type) {
        /**
         * httpRequest为异步请求
         */
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RegisterGetCodeBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("RegisterGetCodeBean", e + "");
            }

            @Override
            public void onNext(MainBean<RegisterGetCodeBean> registerGetCodeBeanMainBean) {
                String message = registerGetCodeBeanMainBean.getMsg();
                if (!message.equals("成功！")) {
                    ToastUtils.showToast(ForgetPasswordActivity.this, message);
                }
                Log.i("TAG", registerGetCodeBeanMainBean.toString());
            }

            @Override
            public Observable<MainBean<RegisterGetCodeBean>> getObservable(MyRetroService retrofit) {
                Observable<MainBean<RegisterGetCodeBean>> codeData = retrofit.getForgetPwCodeData(number,type);
                Log.e("Tag", codeData + "");
                return codeData;
            }
        });
    }
}
