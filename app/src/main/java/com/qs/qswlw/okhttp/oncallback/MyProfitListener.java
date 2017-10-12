package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MyProfitBean;
/**
 * Created by xiaoyu on 2017/9/15.
 */

public interface MyProfitListener extends BaseOnlistener {
    void onSuccess(MyProfitBean myProfitBean);
    void onTokenFail();
}
