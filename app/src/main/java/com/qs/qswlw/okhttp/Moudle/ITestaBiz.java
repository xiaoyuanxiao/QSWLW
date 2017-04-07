package com.qs.qswlw.okhttp.Moudle;

/**
 * Created by 小猴子 on 2017/4/7.
 */

public interface ITestaBiz {

    void login(String mobile, String password, TestaMoudle.OnLoginListener onl);
}
