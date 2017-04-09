package com.qs.qswlw.okhttp.Moudle;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class AlertBeanRes {
    /**
     * alert : {"index_content":"热烈庆祝--大家期待已久的《钱盛物联网》正式上线运营，请各位联盟商家和消费天使积极上线注册，新张期间，注册就送10个金豆，祝大家在钱盛平台上携手共进，互惠互利，大展宏图，生意兴隆、财源滚滚!","index_name":"钱盛物联网","index_time":"2017-04-09","index_title":"喜讯"}
     */

    private AlertBean alert;

    public AlertBean getAlert() {
        return alert;
    }

    public void setAlert(AlertBean alert) {
        this.alert = alert;
    }

    public static class AlertBean {
        /**
         * index_content : 热烈庆祝--大家期待已久的《钱盛物联网》正式上线运营，请各位联盟商家和消费天使积极上线注册，新张期间，注册就送10个金豆，祝大家在钱盛平台上携手共进，互惠互利，大展宏图，生意兴隆、财源滚滚!
         * index_name : 钱盛物联网
         * index_time : 2017-04-09
         * index_title : 喜讯
         */

        private String index_content;
        private String index_name;
        private String index_time;
        private String index_title;

        public String getIndex_content() {
            return index_content;
        }

        public void setIndex_content(String index_content) {
            this.index_content = index_content;
        }

        public String getIndex_name() {
            return index_name;
        }

        public void setIndex_name(String index_name) {
            this.index_name = index_name;
        }

        public String getIndex_time() {
            return index_time;
        }

        public void setIndex_time(String index_time) {
            this.index_time = index_time;
        }

        public String getIndex_title() {
            return index_title;
        }

        public void setIndex_title(String index_title) {
            this.index_title = index_title;
        }
    }
}
