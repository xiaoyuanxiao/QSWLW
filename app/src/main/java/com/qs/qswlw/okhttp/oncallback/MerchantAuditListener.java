package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MerchantAuditBean;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public interface MerchantAuditListener extends BaseOnlistener {
    void onSuccess(MerchantAuditBean merchantAuditBean);
    void onTokenFail();
}
