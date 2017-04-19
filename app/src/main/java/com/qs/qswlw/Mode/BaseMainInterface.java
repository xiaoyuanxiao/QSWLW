package com.qs.qswlw.Mode;

import android.view.View;

/**
 * Created by 小猴子 on 2017/4/19.
 */

public interface BaseMainInterface {
    void notifyDataSetChanged();

    void addFootView(View view);

    void addHeardView(View view);

    void setBackgroundColor(int color);
}
