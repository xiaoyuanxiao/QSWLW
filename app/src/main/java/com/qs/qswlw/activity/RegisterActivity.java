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

public class RegisterActivity extends BaseInfoActivity {
    private Spinner consume_spinner;
    private ArrayAdapter<CharSequence> consume_adapter;
    private String strConsume;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_register, null);
        consume_spinner = (Spinner) inflate.findViewById(R.id.consume_spinner);
        loadSpinner();
        return inflate;
    }

    private void loadSpinner() {

        consume_adapter = ArrayAdapter.createFromResource(this, R.array.consume_item, android.R.layout.simple_spinner_item);
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
}
