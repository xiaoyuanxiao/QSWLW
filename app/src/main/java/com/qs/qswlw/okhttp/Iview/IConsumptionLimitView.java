package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.ConsumptionLimitBean;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public interface IConsumptionLimitView {
    void setdata(ConsumptionLimitBean consumptionLimitBean);
    void isgetDataFaile(String meg);
    void runOnUiThread(Runnable runnable);
    void setTokenFail();
}
