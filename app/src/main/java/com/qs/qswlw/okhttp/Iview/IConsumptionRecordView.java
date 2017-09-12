package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.ConsumptionRecordBean;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public interface IConsumptionRecordView {
    void setConsumptionRecordData(ConsumptionRecordBean consumptionRecordBean);
    void runOnUiThread(Runnable runnable);

}
