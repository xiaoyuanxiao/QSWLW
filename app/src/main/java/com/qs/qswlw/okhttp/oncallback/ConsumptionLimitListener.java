package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ConsumptionLimitBean;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public interface ConsumptionLimitListener extends  BaseOnlistener{
    void onSuccess(ConsumptionLimitBean consumptionLimitBean);
}
