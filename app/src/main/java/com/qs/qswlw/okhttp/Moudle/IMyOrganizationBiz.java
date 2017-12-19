package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MyOrganizationListener;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public interface IMyOrganizationBiz {
    void getdata(MyOrganizationListener myOrganizationListener, String token, int user_id);
}
