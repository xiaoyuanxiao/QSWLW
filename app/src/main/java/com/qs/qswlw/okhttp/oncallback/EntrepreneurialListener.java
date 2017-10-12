package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public interface EntrepreneurialListener extends BaseOnlistener {
    void onSuccess(EntrepreneurialIncentiveBean entrepreneurialIncentiveBean);
    void onTokenFail();
}
