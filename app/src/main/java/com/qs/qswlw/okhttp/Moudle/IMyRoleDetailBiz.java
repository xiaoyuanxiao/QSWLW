package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MyRoleDetailListener;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public interface IMyRoleDetailBiz {
    void getdata(MyRoleDetailListener myRoleDetailListener, String a, String token,int user_id);
}
