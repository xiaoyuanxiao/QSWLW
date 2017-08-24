package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.GoodProductBean;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public interface ProductBaseListener extends BaseOnlistener {
    void onSuccess(GoodProductBean list);
}
