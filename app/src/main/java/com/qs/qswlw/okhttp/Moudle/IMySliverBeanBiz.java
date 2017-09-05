package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MySliverBeanListener;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public interface IMySliverBeanBiz {
    void getdata(MySliverBeanListener mySliverBeanListener, String token, int p);
}
