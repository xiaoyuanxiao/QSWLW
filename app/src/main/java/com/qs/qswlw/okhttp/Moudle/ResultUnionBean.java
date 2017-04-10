package com.qs.qswlw.okhttp.Moudle;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class ResultUnionBean<T> {
    private T union;

    public T getUnion() {
        return union;
    }

    public void setUnion(T union) {
        this.union = union;
    }
}
