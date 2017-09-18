package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MerchantAuditClickListener;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public interface IMerchantAuditClickBiz {
    void getdata(MerchantAuditClickListener merchantAuditClickListener,String token,int id);
}
