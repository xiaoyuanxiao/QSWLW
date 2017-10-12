package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MerchantAuditClickBean;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public interface MerchantAuditClickListener extends BaseOnlistener {
    void onSuccess(MerchantAuditClickBean merchantAuditClickBean);
    void onTokenFail();
}
