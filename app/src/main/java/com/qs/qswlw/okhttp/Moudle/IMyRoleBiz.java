package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MyRoleListener;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public interface IMyRoleBiz {
    void getdata(MyRoleListener myRoleListener,String token);
}
