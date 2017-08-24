package com.qs.qswlw.mynet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Burning on 2017/5/31.
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 */


public class FactoryInterceptor {

    public static Interceptor getCYTDinterc() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        };
        return interceptor;
    }
}
