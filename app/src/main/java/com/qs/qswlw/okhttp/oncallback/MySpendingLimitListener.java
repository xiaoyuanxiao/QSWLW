package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MySpendingLimitBean;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public interface MySpendingLimitListener extends BaseOnlistener {
    void onSuccess(MySpendingLimitBean mySpendingLimitBean);
}
