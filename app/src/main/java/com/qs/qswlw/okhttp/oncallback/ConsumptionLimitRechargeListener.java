package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ConsumptionLimitRechargeBean;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public interface ConsumptionLimitRechargeListener extends BaseOnlistener {
    void onSuccess(ConsumptionLimitRechargeBean consumptionLimitRechargeBean);
}
