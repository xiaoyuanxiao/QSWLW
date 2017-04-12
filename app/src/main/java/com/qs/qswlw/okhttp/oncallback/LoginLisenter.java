package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.okhttp.Moudle.LoginBean;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface LoginLisenter extends BaseOnlistener {
    void onSuccess(LoginBean e);
}
