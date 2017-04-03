package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.view.View;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class TwentyPercentMode extends BaseMode {
    public TwentyPercentMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.twenty_mode, null);
        return inflate;
    }
}
