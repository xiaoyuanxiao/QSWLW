package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.VenturegoldBean;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public interface VenturegoldBeanListener {
    void onSuccess(VenturegoldBean venturegoldBean);
    void onTokenFail();
}
