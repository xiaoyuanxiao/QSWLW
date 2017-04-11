package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.okhttp.Moudle.AlertBean;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface MainAlertLisenter extends BaseOnlistener {
    void onSuccess(AlertBean e);
}
