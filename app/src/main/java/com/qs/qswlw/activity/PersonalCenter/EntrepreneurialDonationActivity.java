package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class EntrepreneurialDonationActivity extends BaseInfoActivity {

    private TextView tv_entrepreneurialdonation;
    private RadioGroup rg_entrepreneurialdialog;
    private RadioButton radio_top,radio_bellow;
    private AlertDialog dialog;
    // private static final String[] PLANETS = new String[]{"创业基金", "创新基金"};

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_entrepreneurialdonation, null);
        tv_entrepreneurialdonation = (TextView) inflate.findViewById(R.id.tv_entrepreneurialdonation);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("创业直捐");
        tv_titlebar_right.setText("直捐记录");

    }


    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_entrepreneurialdonation.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_entrepreneurialdonation:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                dialog = builder.create();
                View dialogView = LayoutInflater.from(EntrepreneurialDonationActivity.this).inflate(R.layout.entrepreneurialdialog, null);
                rg_entrepreneurialdialog = (RadioGroup) dialogView.findViewById(R.id.rg_entrepreneurialdialog);
                rg_entrepreneurialdialog.setOnCheckedChangeListener(new CheckedChangeListener());
                radio_top = (RadioButton) dialogView.findViewById(R.id.radio_top);
                radio_bellow = (RadioButton) dialogView.findViewById(R.id.radio_bellow);
                radio_top.setOnClickListener(this);
                radio_bellow.setOnClickListener(this);
                dialog.setView(dialogView);
                dialog.show();
                break;
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this, EntrepreneurialDonationRecordActivity.class));
                break;
        }
    }

    class CheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(i==radio_top.getId()){
                tv_entrepreneurialdonation.setText(radio_top.getText());
                dialog.dismiss();
            }else if(i==radio_bellow.getId()){
                tv_entrepreneurialdonation.setText(radio_bellow.getText());
                dialog.dismiss();
            }
        }
    }



}
