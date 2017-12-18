package com.qs.qswlw.activity.PersonalCenter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RegisterGetCodeBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.utils.ToastUtils;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/5/10.
 */

public class RetrievePasswordActivity extends BaseInfoActivity {

    private Spinner consume_spinner;
    private ArrayAdapter<CharSequence> classification_adapter;
    private String strClassification;
    private EditText edt_retrieve_phone, edt_retrieve_code, edt_retrieve_password, edt_retrieve_confirmPassword;
    private Button btn_retrieve_getcode, btn_retreve_confirm;
    private String phone;
    private String code,pass,confirmpass;
    private int role;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_retrievepassword, null);
        consume_spinner = (Spinner) inflate.findViewById(R.id.consume_spinner);
        edt_retrieve_phone = (EditText) inflate.findViewById(R.id.edt_retrieve_phone);
        edt_retrieve_code = (EditText) inflate.findViewById(R.id.edt_retrieve_code);
        btn_retrieve_getcode = (Button) inflate.findViewById(R.id.btn_retrieve_getcode);
        btn_retreve_confirm = (Button) inflate.findViewById(R.id.btn_retreve_confirm);
        edt_retrieve_password = (EditText) inflate.findViewById(R.id.edt_retrieve_password);
        edt_retrieve_confirmPassword = (EditText) inflate.findViewById(R.id.edt_retrieve_confirmPassword);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("找回二级密码");
    }

    @Override
    public void initData() {
        super.initData();
        loadSpinner();
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_retreve_confirm.setOnClickListener(this);
        btn_retrieve_getcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_retrieve_getcode:
                phone = edt_retrieve_phone.getText().toString().trim();
                getCodeData(phone,2);
                break;
            case R.id.btn_retreve_confirm:
                code = edt_retrieve_code.getText().toString().trim();
                pass = edt_retrieve_password.getText().toString();
                confirmpass = edt_retrieve_confirmPassword.getText().toString();
                if(!pass.equals(confirmpass)){
                    ToastUtils.showToast("两次密码不一致");
                }
                if(phone==null){
                    ToastUtils.showToast("手机号不能为空");
                }
                if(code==null){
                    ToastUtils.showToast("验证码不能为空");
                }
                /**
                 * 提交找回密码信息
                 */
                PostRetrievePass(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID),phone,code,role,pass,confirmpass);
                break;
        }
    }

    private void PostRetrievePass(final String token, final int user_id, final String mobile, final String mobile_code,
                                  final int role, final String pass, final String repass) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("e",e+"");
            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());
                /**
                 * token失效
                 */
                if(mainBean.getStatus()==1){
                    finish();
                }else if(mainBean.getStatus()==-3||mainBean.getStatus()==-4){
                   ActivityManagerUtils.getInstance().tokenfailfg(RetrievePasswordActivity.this);
                   finish();
               }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.getRetrievePassData(token,user_id,mobile,mobile_code,role,pass,repass);
            }
        });
    }


    /**
     * 获取验证码
     *
     * @param number
     */
    public void getCodeData(final String number,final int type) {
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
                ToastUtils.showToast(message);
            }

            @Override
            public Observable<MainBean<RegisterGetCodeBean>> getObservable(MyRetroService retrofit) {
                Observable<MainBean<RegisterGetCodeBean>> codeData = retrofit.getCodeData(number,type);
                Log.e("Tag", codeData + "");
                return codeData;
            }
        });
    }



    /**
     * 经营分类spinner
     */
    private void loadSpinner() {
        classification_adapter = ArrayAdapter.createFromResource(this, R.array.forgetpw_item, android.R.layout.simple_spinner_item);
        classification_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        consume_spinner.setAdapter(classification_adapter);
        consume_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedItemPosition = consume_spinner.getSelectedItemPosition();
                //i是选择的第几个，从0开始算起
                switch (i) {
                    case 1:
                        role = 0;
                        break;
                    case 2:
                        role = 10;
                        break;
                    case 3:
                        role = 11;
                        break;
                    case 4:
                        role = 15;
                        break;
                    case 5:
                        role = 9;
                        break;
                    case 6:
                        role = 8;
                        break;

                }
                strClassification = consume_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
