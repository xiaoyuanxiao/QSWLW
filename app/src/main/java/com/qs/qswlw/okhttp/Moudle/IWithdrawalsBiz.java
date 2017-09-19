package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.WithdrawalsListener;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public interface IWithdrawalsBiz {
    void getdata(WithdrawalsListener withdrawalsListener,String token);
}
