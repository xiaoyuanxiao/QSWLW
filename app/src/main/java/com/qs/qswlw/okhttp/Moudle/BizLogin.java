package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.bean.LoginBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.NetUrl;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.okhttp.oncallback.LoginLisenter;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class BizLogin implements ILoginBiz {
    private static BizLogin loginMoudle;

    private BizLogin() {
    }
    public synchronized static BizLogin getInstans() {
        if (loginMoudle == null)
            loginMoudle = new BizLogin();
        return loginMoudle;
    }

    @Override
    public void getLogin(final LoginLisenter loginLisenter,String username,String password) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("username", username);
        stringStringHashMap.put("password", password);
        Type type = new TypeToken<BaseBean<LoginBean>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.LOGINURL, stringStringHashMap,
                new DataCallBack<MainBean<LoginBean>>(type) {
                    @Override
                    public void onSuccess(MainBean<LoginBean> data) {
                        LoginBean result = null;
                        try {
                            result = data.getResult();

                        } catch (Exception e) {

                        }
                        if (result == null)
                            loginLisenter.onFailure("错误信息");
                        else
                            loginLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        loginLisenter.onFailure("错误信息" + code);
                    }
                });
    }
}
