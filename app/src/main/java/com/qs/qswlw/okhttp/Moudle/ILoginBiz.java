package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.LoginLisenter;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public interface ILoginBiz {
    void getLogin(LoginLisenter loginLisenter,String username,String password);
}
