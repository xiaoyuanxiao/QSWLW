package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ConsumptionLimitListener;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public interface IConsumptionLimitBiz {
    void getdata(ConsumptionLimitListener consumptionLimitListener, String token,int p);
}
