package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.MyRoleBean;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public interface IMyRoleView {
    void setMyRoleViewList(MyRoleBean myRoleBean);

    void runOnUiThread(Runnable runnable);
    void setTokenFail();
}
