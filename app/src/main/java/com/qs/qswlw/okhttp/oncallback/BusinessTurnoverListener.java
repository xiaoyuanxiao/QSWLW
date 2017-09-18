package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.BusinessTurnoverBean;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface BusinessTurnoverListener extends BaseOnlistener {
    void onSuccess(BusinessTurnoverBean businessTurnoverBean);
}
