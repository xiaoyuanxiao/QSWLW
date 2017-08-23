package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/4/11.
 */

public class MainBean<T> {
    private T result;
    private String msg;


    private int status;
    private int succ;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSucc() {
        return succ;
    }

    public void setSucc(int succ) {
        this.succ = succ;
    }
}
