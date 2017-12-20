package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ReceivingAddressBean;

/**
 * Created by xiaoyu on 2017/12/20.
 */

public interface ReceivingAddressListener extends BaseOnlistener {
    void OnSuccess(ReceivingAddressBean receivingAddressBean);
    void onTokenFail();
}
