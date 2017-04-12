package com.qs.qswlw.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class ForgetPasswordActivity extends BaseInfoActivity {
    private Spinner forgetpw_spinner;
    private ArrayAdapter<CharSequence> forgetpw_adapter;
    private String strForgetpw;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_forgetpassword, null);
        forgetpw_spinner = (Spinner) inflate.findViewById(R.id.forgetpw_spinner);
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
}
