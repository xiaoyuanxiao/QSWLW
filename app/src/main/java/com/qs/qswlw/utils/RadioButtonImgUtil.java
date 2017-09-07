package com.qs.qswlw.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.RadioButton;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/9/7.
 */

public class RadioButtonImgUtil {
    private static void setCompoun(RadioButton button, Drawable drawable) {
        button.setCompoundDrawables(null, drawable, null, null);//只放上面
    }

    private static Drawable getResouDrawable(Context context, int id) {
        Drawable drawable = context.getResources().getDrawable(id);
        drawable.setBounds(0, 0, 45, 45);
        return drawable;
    }

    public static void setRadioButtonImg(Context context,
                                         RadioButton... radioButton) {
        int[] ids = {R.mipmap.gouwuche, R.mipmap.gouwudai, R.mipmap.happygame01, R.mipmap.luckgame01, R.mipmap.out};
        for (int i = 0; i < radioButton.length; i++) {
            setCompoun(radioButton[i], getResouDrawable(context, ids[i]));

        }
    }
}
