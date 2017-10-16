package com.qs.qswlw.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public class DialogUtils {
    public static void showDialog(Context context,View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog dialog = builder.create();
         View alertview =view ;
        dialog.setView(alertview);
        dialog.show();
    }

    public static void showDidlog(Context context,final String[] items, final TextView tv ) {

        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);//内部使用构建者的设计模式

        builder.setSingleChoiceItems(items, -1,new DialogInterface.OnClickListener() {//第二个参数是设置默认选中哪一项-1代表默认都不选


            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText(items[which]);
                dialog.dismiss();
            }
        });
        builder.create().setCanceledOnTouchOutside(true);
        builder.setCancelable(true);
        builder.create().show();
    }
}
