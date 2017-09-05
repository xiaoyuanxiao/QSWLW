package com.qs.qswlw.utils;

import android.content.Context;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;

/**
 * Created by dashen10 on 2015/8/11.
 */
public class ToastUtils {
    public static void showToast(Context context, int strID) {
        Toast.makeText(context, context.getString(strID), Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String message) {
        Toast.makeText(MyApplication.getApplication(), message, Toast.LENGTH_SHORT).show();
    }
}
