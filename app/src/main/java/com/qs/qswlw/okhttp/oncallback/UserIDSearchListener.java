package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.UserIDSearchBean;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public interface UserIDSearchListener extends BaseOnlistener {
    void onSuccess(UserIDSearchBean userIDSearchBean);
}
