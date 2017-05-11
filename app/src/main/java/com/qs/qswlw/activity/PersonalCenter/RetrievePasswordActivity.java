package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/5/10.
 */

public class RetrievePasswordActivity extends BaseInfoActivity {

    private Spinner consume_spinner;
    private ArrayAdapter<CharSequence> classification_adapter;
    private String strClassification;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_retrievepassword, null);
        consume_spinner = (Spinner) inflate.findViewById(R.id.consume_spinner);
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
