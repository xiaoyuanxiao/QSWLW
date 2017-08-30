package com.qs.qswlw.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RegisterBean;
import com.qs.qswlw.bean.RegisterCheckIdBean;
import com.qs.qswlw.bean.RegisterGetCodeBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.ToastUtils;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class RegisterActivity extends BaseInfoActivity {
    private Spinner consume_spinner;
    private ArrayAdapter<CharSequence> consume_adapter;
    private String strConsume;
    private EditText edt_register_code, edt_register_myphone, edt_register_id, edt_register_phone, edt_register_username, edt_register_password, edt_register_name, edt_register_confirmPassword;
    private Button register_getcode, btn_register;
    private TimeCount time;
    /**
     * 返回信息
     *
     * @return
     */
    String nickname;
    String role;
    String mobile;
    int succ;
    private CheckBox cbx_register;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_register, null);
        edt_register_code = (EditText) inflate.findViewById(R.id.edt_register_code);
        edt_register_myphone = (EditText) inflate.findViewById(R.id.edt_register_myphone);
        edt_register_phone = (EditText) inflate.findViewById(R.id.edt_register_phone);
        edt_register_username = (EditText) inflate.findViewById(R.id.edt_register_username);
        edt_register_password = (EditText) inflate.findViewById(R.id.edt_register_password);
        edt_register_name = (EditText) inflate.findViewById(R.id.edt_register_name);
        edt_register_id = (EditText) inflate.findViewById(R.id.edt_register_id);
        edt_register_confirmPassword = (EditText) inflate.findViewById(R.id.edt_register_confirmPassword);
        consume_spinner = (Spinner) inflate.findViewById(R.id.consume_spinner);
        register_getcode = (Button) inflate.findViewById(R.id.register_getcode);
        btn_register = (Button) inflate.findViewById(R.id.btn_register);
        cbx_register = (CheckBox) inflate.findViewById(R.id.cbx_register);
        loadSpinner(R.array.consume_item);
        return inflate;
    }

    private void loadSpinner(int consume_item) {
        consume_adapter = ArrayAdapter.createFromResource(this, consume_item, android.R.layout.simple_spinner_item);
        consume_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        consume_spinner.setAdapter(consume_adapter);
        consume_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                consume_spinner.getSelectedItemPosition();
                strConsume = consume_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("用户注册");
    }

    @Override
    public void initData() {
        super.initData();
        time = new TimeCount(60000,1000);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        edt_register_myphone.setOnClickListener(this);
        register_getcode.setOnClickListener(this);
        edt_register_name.setFocusable(false);//让EditText失去焦点，然后获取点击事件
        edt_register_phone.setFocusable(false);//让EditText失去焦点，然后获取点击事件
        edt_register_name.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.edt_register_myphone:
                break;
            case R.id.register_getcode:
                time.start();
                getCodeData(edt_register_myphone.getText().toString());
                break;
            case R.id.edt_register_name:
                PostCheckID(Integer.parseInt(edt_register_id.getText().toString()));
                break;
            case R.id.btn_register:
                if (edt_register_myphone.getText().toString().trim().equals("")) {
                    ToastUtils.showToast(this, "手机号码不能为空");
                } else if (edt_register_username.getText().toString().trim().equals("")) {
                    ToastUtils.showToast(this, "用户名不能为空");
                } else if (!cbx_register.isChecked()) {
                    ToastUtils.showToast(this, "请同意钱盛物联网注册协议");
                } else {
                    if (succ == 1) {
                        PostRegister(edt_register_myphone.getText().toString(), Integer.parseInt(edt_register_id.getText().toString()), edt_register_username.getText().toString(),
                                edt_register_password.getText().toString(), edt_register_confirmPassword.getText().toString(), Integer.parseInt(role), edt_register_code.getText().toString());

                    } else {
                        ToastUtils.showToast(this, "该推荐人无效");
                    }

                }
                break;
        }
    }


    /**
     * 检查推荐人id
     *
     * @param a
     */
    private void PostCheckID(final int a) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RegisterCheckIdBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("11111111111111111111", e + "");
            }

            @Override
            public void onNext(MainBean<RegisterCheckIdBean> IdBean) {
                String msg = IdBean.getMsg();
                if(!msg.equals("获取成功")){
                    edt_register_name.setText("暂未查到联系人");
                }else{
                    nickname = IdBean.getResult().getNickname();
                    role = IdBean.getResult().getRole();
                    mobile = IdBean.getResult().getMobile();
                    succ = IdBean.getSucc();
                    edt_register_name.setText(nickname);
                    edt_register_phone.setText(mobile);
                    if (Integer.parseInt(role) >= 11) {
                        loadSpinner(R.array.business_item);
                    } else {
                        loadSpinner(R.array.consume_item);
                    }
                }

            }

            @Override
            public Observable<MainBean<RegisterCheckIdBean>> getObservable(MyRetroService retrofit) {
                Observable<MainBean<RegisterCheckIdBean>> registerIdData = retrofit.getIdData(a);
                return registerIdData;
            }
        });


    }

    /**
     * 注册接口
     *
     * @param number
     * @param id
     * @param nickname
     * @param password
     * @param repassword
     * @param role
     * @param post_code
     */
    public void PostRegister(final String number, final int id, final String nickname, final String password, final String repassword, final int role, final String post_code) {
        /**
         * httpRequest为异步请求
         */
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RegisterBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("register", e + "");
                String message = e.getMessage();
                ToastUtils.showToast(RegisterActivity.this, message);
            }

            @Override
            public void onNext(MainBean<RegisterBean> regisetbean) {
                final String msg = regisetbean.getMsg();
                if (!msg.equals("注册成功")) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Looper.prepare();
                            ToastUtils.showToast(RegisterActivity.this, msg);
                            Looper.loop();
                        }
                    }).start();

                } else {
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
            }

            @Override
            public Observable<MainBean<RegisterBean>> getObservable(MyRetroService retrofit) {
                return retrofit.postRgisterData(number, id, nickname, password, repassword, role, post_code);
            }
        });

    }

    /**
     * 获取验证码
     *
     * @param number
     */
    public void getCodeData(final String number) {
        /**
         * httpRequest为异步请求
         */
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RegisterGetCodeBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("RegisterGetCodeBean",e+"");
            }

            @Override
            public void onNext(MainBean<RegisterGetCodeBean> registerGetCodeBeanMainBean) {
                String message = registerGetCodeBeanMainBean.getMsg();
                if(!message.equals("成功！")){
                    ToastUtils.showToast(RegisterActivity.this,message);
                }
                Log.i("TAG",registerGetCodeBeanMainBean.toString());
            }

            @Override
            public Observable<MainBean<RegisterGetCodeBean>> getObservable(MyRetroService retrofit) {
                Observable<MainBean<RegisterGetCodeBean>> codeData = retrofit.getCodeData(number);
                Log.e("Tag",codeData+"");
                return codeData;
            }
        });
    }

    /**
     * 验证码60秒倒计时
     */
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            register_getcode.setBackgroundResource(R.drawable.corner_code_btn_click);
            register_getcode.setClickable(false);
            register_getcode.setText("("+millisUntilFinished / 1000 +") 秒后可重新发送");
        }

        @Override
        public void onFinish() {
            register_getcode.setText("重新获取验证码");
            register_getcode.setClickable(true);
            register_getcode.setBackgroundResource(R.drawable.corner_code_btn);

        }
    }
}
