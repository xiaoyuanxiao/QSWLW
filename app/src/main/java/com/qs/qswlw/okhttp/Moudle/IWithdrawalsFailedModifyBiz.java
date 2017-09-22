package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.WithdrawalsFailedModifyListener;

/**
 * Created by xiaoyu on 2017/9/22.
 */

public interface IWithdrawalsFailedModifyBiz {
    void getdata(WithdrawalsFailedModifyListener withdrawalsFailedModifyListener, String token,int id);
}
