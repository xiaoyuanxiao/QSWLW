package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.WithdrawalsAddListener;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface IWithdrawalsAddBiz {
    void getData(WithdrawalsAddListener withdrawalsAddListener, String token, int id);
}
