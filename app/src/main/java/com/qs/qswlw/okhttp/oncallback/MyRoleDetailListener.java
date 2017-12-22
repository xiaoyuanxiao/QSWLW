package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MyRoleDatailBean;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public interface MyRoleDetailListener extends BaseOnlistener {
    void onSuccess(MyRoleDatailBean myRoleDatailBean);
    void onTokenFail();
}
