package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.WithdrawalsFailedModifyBean;

/**
 * Created by xiaoyu on 2017/9/22.
 */

public interface WithdrawalsFailedModifyListener extends BaseOnlistener{
    void onSuccess(WithdrawalsFailedModifyBean withdrawalsFailedModifyBean);
}
