package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.OKhttptUtils;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by 小猴子 on 2017/4/7.
 */

public class TestaMoudle implements ITestaBiz {

    private static TestaMoudle testMoudle;

    public interface OnLoginListener {
        void onSucces(String msg);

        void onFail();
    }

    String url = "http://www.qiansheng.com/api/index/index";

    @Override
    public void login(String mobile, String password, final OnLoginListener onl) {

        HashMap<String, String> a = new HashMap<>();
        a.put("mobile"/**Key*/, mobile);
        a.put("password", password);
        Type type = new TypeToken<BaseBean<AlertBeanRes>>() {
        }.getType();
        OKhttptUtils.httpPost(
                url, a,
                new DataCallBack<BaseBean<AlertBeanRes>>(type) {
                    @Override
                    public void onSuccess(BaseBean<AlertBeanRes> data) {
                        //onl.onSucces(data);
                    }

                    @Override
                    public void onFailure(int code) {
                        onl.onFail();
                    }
                }

        );
    }

    private TestaMoudle() {
    }

    public synchronized static TestaMoudle getInstans() {
        if (testMoudle == null)
            testMoudle = new TestaMoudle();
        return testMoudle;
    }

}
