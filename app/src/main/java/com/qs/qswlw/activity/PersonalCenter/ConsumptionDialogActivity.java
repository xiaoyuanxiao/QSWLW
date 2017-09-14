package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/9/14.
 */

public class ConsumptionDialogActivity extends BaseInfoActivity{

    private String dialog;

    @Override
    public View setConetnView() {
        return View.inflate(this, R.layout.activity_dialog_consumption,null);
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        dialog = intent.getStringExtra("dialog");
        showDialog();
    }

    /**
     * 退出登录
     */
    private void showDialog() {
        new AlertDialog.Builder(this)
                .setMessage(dialog)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作

                    }
                })
                .setNegativeButton("查看", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ConsumptionDialogActivity.this, ImproveDocumentationActivity.class));
                        finish();
                    }
                }).show();
// super.onBackPressed();
    }
}
