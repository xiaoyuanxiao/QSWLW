package com.qs.qswlw.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

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

}
