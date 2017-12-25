package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.UserIDSearchListener;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public interface IUserIDSearchBiz {
    void getdata(UserIDSearchListener userIDSearchListener, String token, int uid, int user_id);
}
