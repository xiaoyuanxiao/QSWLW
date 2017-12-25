package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MyOrganizationBean;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public interface MyOrganizationListener extends BaseOnlistener {
    void onSuccess(MyOrganizationBean myOrganizationBean);
    void onTokenFail();
}
