package com.qs.qswlw.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class PopupWindowUtils {

    public static void showPW(View view,PopupWindow popupWindow, Context context, int lay,int location,int x,int y) {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(
                lay, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(view, location,x,y);


    }
}
