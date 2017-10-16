package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class EntrepreneurialDonationActivity extends BaseInfoActivity {

    private TextView tv_entrepreneurialdonation;

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
                showDidlog();
                break;
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this, EntrepreneurialDonationRecordActivity.class));
                break;
        }
    }

    private void showDidlog() {

        final String[] items = {"创新基金","创业基金"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);//内部使用构建者的设计模式

        builder.setSingleChoiceItems(items, -1,new DialogInterface.OnClickListener() {//第二个参数是设置默认选中哪一项-1代表默认都不选


            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv_entrepreneurialdonation.setText(items[which]);
                dialog.dismiss();
            }
        });
        builder.create().setCanceledOnTouchOutside(true);
        builder.setCancelable(true);//设置dialog只能通过点击Dialog上的按钮退出，不能通过回退按钮退出关闭Dialog
        builder.create().show();//创建对象
    }

}
