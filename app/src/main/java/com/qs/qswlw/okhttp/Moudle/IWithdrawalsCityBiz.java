package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.WithdrawalsCityListener;

/**
 * Created by xiaoyu on 2017/9/21.
 */

public interface IWithdrawalsCityBiz {
    void getdata(WithdrawalsCityListener withdrawalsCityListener, String token, int pid);
}
