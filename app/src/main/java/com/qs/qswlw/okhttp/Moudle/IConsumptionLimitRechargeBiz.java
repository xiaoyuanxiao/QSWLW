package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ConsumptionLimitRechargeListener;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public interface IConsumptionLimitRechargeBiz {
    void getdata(ConsumptionLimitRechargeListener consumptionLimitRechargeListener, String token, String recharge_type);
}
