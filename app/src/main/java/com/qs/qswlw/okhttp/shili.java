package com.qs.qswlw.okhttp;

/**
 * Created by 小猴子 on 2017/4/7.
 */

public class shili {

    public void a() {
        OKhttptUtils.httpPost(
                "www.xxx.com", "传入字符串",
                new DataCallBack<String[]>() {
                    @Override
                    public void onSuccess(String[] data) {

                    }

                    @Override
                    public void onFailure(int code) {

                    }
                }

        );

    }
}
