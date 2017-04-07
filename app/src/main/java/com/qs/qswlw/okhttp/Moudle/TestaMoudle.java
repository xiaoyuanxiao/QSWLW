package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.Gson;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.OKhttptUtils;

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

    @Override
    public void login(String mobile, String password, final OnLoginListener onl) {

        HashMap<String, Object> a = new HashMap<>();
        a.put("mobile"/**Key*/, mobile);
        a.put("password", password);
        OKhttptUtils.httpPost(
                "www.xxx登入地址.com", new Gson().toJson(a),
                new DataCallBack<String[]>() {
                    @Override
                    public void onSuccess(String[] data) {
                        if (data[0].equals("200")) {
                            onl.onSucces(data[1]);
                        } else {
                            onl.onSucces(data[0]);
                        }

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
