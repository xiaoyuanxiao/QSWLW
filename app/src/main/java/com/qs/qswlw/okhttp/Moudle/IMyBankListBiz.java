package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MyBankListListener;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface IMyBankListBiz {
    void getdata(MyBankListListener myBankListListener, String token);
}
