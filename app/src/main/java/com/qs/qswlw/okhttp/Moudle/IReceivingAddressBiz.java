package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ReceivingAddressListener;

/**
 * Created by xiaoyu on 2017/12/20.
 */

public interface IReceivingAddressBiz {
    void getdata(ReceivingAddressListener receivingAddressListener, String token, int cyzx_id);
}
