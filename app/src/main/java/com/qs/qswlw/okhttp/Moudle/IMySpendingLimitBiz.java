package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MySpendingLimitListener;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public interface IMySpendingLimitBiz {
    void getdata(MySpendingLimitListener mySpendingLimitListener, String token, int p, int tab_status);
}
