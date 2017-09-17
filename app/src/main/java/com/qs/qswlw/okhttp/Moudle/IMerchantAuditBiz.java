package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MerchantAuditListener;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public interface IMerchantAuditBiz {
    void getdata(MerchantAuditListener merchantAuditListener, String token, int p, int is_ok);
}
