package com.qs.qswlw.okhttp;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public abstract class DataCallBack<T> {
    public DataCallBack() {
    }

    public void sendMess(final int code, final T data) {
        if (code == OKhttptUtils.HTTPOK) {
            onSuccess(data);
        } else if (code == OKhttptUtils.GSON_ER) {
            //字符串解析异常
            onFailure(code);
        } else if (code == OKhttptUtils.HTTPER) {
            //请求异常
            onFailure(code);
        } else {
            //Http 其他状态码
            onFailure(code);
        }

    }

    public abstract void onSuccess(T data);

    public abstract void onFailure(int code);

    public Type getType() {
        return new TypeToken<T>() {
        }.getType();
    }
}
