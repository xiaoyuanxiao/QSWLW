package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.WithdrawalsBean;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public interface WithdrawalsListener extends BaseOnlistener {
    void onSuccess(WithdrawalsBean withdrawalsBean);
    void onTokenFail();
}
