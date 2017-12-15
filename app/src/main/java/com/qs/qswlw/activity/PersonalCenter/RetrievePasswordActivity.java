package com.qs.qswlw.activity.PersonalCenter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RegisterGetCodeBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
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
                phone = edt_retrieve_phone.getText().toString();
                getCodeData(phone);
                break;
            case R.id.btn_retreve_confirm:

                break;
        }
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
                Log.e("RegisterGetCodeBean", e + "");
            }

            @Override
            public void onNext(MainBean<RegisterGetCodeBean> registerGetCodeBeanMainBean) {
                String message = registerGetCodeBeanMainBean.getMsg();
                ToastUtils.showToast(message);
            }

            @Override
            public Observable<MainBean<RegisterGetCodeBean>> getObservable(MyRetroService retrofit) {
                Observable<MainBean<RegisterGetCodeBean>> codeData = retrofit.getCodeData(number);
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
                consume_spinner.getSelectedItemPosition();
                strClassification = consume_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
