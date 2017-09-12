package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ConsumptionRecordListener;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public interface IConsumptionRecordBiz {
    void getConsumptionRecordData(ConsumptionRecordListener consumptionRecordListener,String token);
}
