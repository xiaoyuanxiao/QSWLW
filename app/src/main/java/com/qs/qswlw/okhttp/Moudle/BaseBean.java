package com.qs.qswlw.okhttp.Moudle;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class BaseBean<T> {


    /**
     * msg : 获取成功
     * result : {"alert":{"index_content":"热烈庆祝--大家期待已久的《钱盛物联网》正式上线运营，请各位联盟商家和消费天使积极上线注册，新张期间，注册就送10个金豆，祝大家在钱盛平台上携手共进，互惠互利，大展宏图，生意兴隆、财源滚滚!","index_name":"钱盛物联网","index_time":"2017-04-09","index_title":"喜讯"}}
     * status : 1
     */

    private String msg;
    private ResultBean<T> result;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean<T> getResult() {
        return result;
    }

    public void setResult(ResultBean<T> result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
