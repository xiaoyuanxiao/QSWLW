package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/9/12.
 */

public class ConsumptionConfirmBean {
    /**
     * status : 1
     * succ : 1
     * msg : 成功！
     * result : null
     */

    private int status;
    private int succ;
    private String msg;
    private Object result;


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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
