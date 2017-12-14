package com.qs.qswlw.utils;

import android.content.Context;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/12/14.
 */

public class TextcolorUtil {
    public static void setTextColor(Context context, int index, TextView... textViews) {
        for (int i = 0; i < textViews.length; i++) {
            if (i == index) {
                textViews[i].setTextColor(context.getResources().getColor(R.color.white));
            } else {
                textViews[i].setTextColor(context.getResources().getColor(R.color.tv_ranking));
            }
        }
    }
}