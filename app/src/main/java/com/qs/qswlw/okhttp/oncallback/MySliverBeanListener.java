package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MySliverBean;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public interface MySliverBeanListener extends BaseOnlistener{
    void onSuccess(MySliverBean mySliverBean);
    void onTokenFail();

}
