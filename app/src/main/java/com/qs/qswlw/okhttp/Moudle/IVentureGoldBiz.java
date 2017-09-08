package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.VenturegoldBeanListener;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public interface IVentureGoldBiz {
    void getdata(VenturegoldBeanListener venturegoldBeanListener, String token, int p, String model, String gold_type,String type);
}
