package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.bean.MainBean;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public interface IConsumptionRecordView {
    void setConsumptionRecordData(MainBean<ConsumptionRecordBean> consumptionRecordBean);
    void runOnUiThread(Runnable runnable);
    void setTokenFail();
}
