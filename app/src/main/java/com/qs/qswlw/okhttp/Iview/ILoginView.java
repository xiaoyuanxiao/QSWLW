package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.okhttp.Moudle.LoginBean;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public interface ILoginView {
    void setLogin(LoginBean logininfo);
    void runOnUiThread(Runnable runnable);
}
