package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ConsumptionRecordBean;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public interface ConsumptionRecordListener extends BaseOnlistener {
    void onSuccess(ConsumptionRecordBean consumptionRecordBean);
}
