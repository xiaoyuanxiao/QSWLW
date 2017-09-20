package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.WithdrawalsAddBean;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface WithdrawalsAddListener extends BaseOnlistener{
    void onSuccess(WithdrawalsAddBean withdrawalsAddBean);
}
