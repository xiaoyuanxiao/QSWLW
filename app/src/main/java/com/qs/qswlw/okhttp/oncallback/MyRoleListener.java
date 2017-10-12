package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MyRoleBean;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public interface MyRoleListener extends BaseOnlistener {
    void onSuccess(MyRoleBean myRoleBean);
    void onTokenFail();
}
