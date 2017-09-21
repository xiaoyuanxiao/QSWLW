package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.WithdrawalsCityBean;

/**
 * Created by xiaoyu on 2017/9/21.
 */

public interface WithdrawalsCityListener extends BaseOnlistener {
    void onSuccess(WithdrawalsCityBean withdrawalsCityBean);
}
