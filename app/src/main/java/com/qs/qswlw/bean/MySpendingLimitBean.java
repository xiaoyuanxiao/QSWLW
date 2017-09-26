package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class MySpendingLimitBean {
    /**
     * add_quota_list : [{"add_time":"2017-09-23","consume_quota":"10.450","logid":"265471","temp1":"104.503"},{"add_time":"2017-09-22","consume_quota":"10.489","logid":"264973","temp1":"104.895"},{"add_time":"2017-09-21","consume_quota":"10.529","logid":"264756","temp1":"105.294"},{"add_time":"2017-09-20","consume_quota":"10.569","logid":"264551","temp1":"105.693"},{"add_time":"2017-09-19","consume_quota":"10.609","logid":"264350","temp1":"106.092"},{"add_time":"2017-09-16","consume_quota":"10.649","logid":"263937","temp1":"106.498"},{"add_time":"2017-09-15","consume_quota":"10.690","logid":"263722","temp1":"106.904"},{"add_time":"2017-09-14","consume_quota":"10.731","logid":"263510","temp1":"107.310"},{"add_time":"2017-09-13","consume_quota":"5.202","logid":"263299","temp1":"52.024"},{"add_time":"2017-09-12","consume_quota":"5.222","logid":"263089","temp1":"52.227"},{"add_time":"2017-09-09","consume_quota":"0.866","logid":"262884","temp1":"8.666"},{"add_time":"2017-09-08","consume_quota":"0.870","logid":"262666","temp1":"8.701"},{"add_time":"2017-09-07","consume_quota":"0.608","logid":"262465","temp1":"6.083"},{"add_time":"2017-09-02","consume_quota":"0.371","logid":"261968","temp1":"3.717"},{"add_time":"2017-05-24","consume_quota":"0.469","logid":"63811","temp1":"4.683"},{"add_time":"2017-05-23","consume_quota":"0.471","logid":"60716","temp1":"4.704"}]
     * consume_count : 98.795
     * temp1_count : 987.994
     */

    private String consume_count;
    private String count_money;
    private String temp1_count;
    private List<AddQuotaListBean> add_quota_list;
    private List<DelQuotaListBean> del_quota_list;

    public String getCount_money() {
        return count_money;
    }

    public void setCount_money(String count_money) {
        this.count_money = count_money;
    }

    public String getConsume_count() {
        return consume_count;
    }

    public void setConsume_count(String consume_count) {
        this.consume_count = consume_count;
    }

    public String getTemp1_count() {
        return temp1_count;
    }

    public void setTemp1_count(String temp1_count) {
        this.temp1_count = temp1_count;
    }

    public List<AddQuotaListBean> getAdd_quota_list() {
        return add_quota_list;
    }

    public void setAdd_quota_list(List<AddQuotaListBean> add_quota_list) {
        this.add_quota_list = add_quota_list;
    }

    public List<DelQuotaListBean> getDel_quota_list() {
        return del_quota_list;
    }

    public void setDel_quota_list(List<DelQuotaListBean> del_quota_list) {
        this.del_quota_list = del_quota_list;
    }

    public static class AddQuotaListBean {

        /**
         * add_time : 2017-09-23
         * consume_quota : 10.450
         * logid : 265471
         * temp1 : 104.503
         */

        private String add_time;
        private String consume_quota;
        private String logid;
        private String temp1;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getConsume_quota() {
            return consume_quota;
        }

        public void setConsume_quota(String consume_quota) {
            this.consume_quota = consume_quota;
        }

        public String getLogid() {
            return logid;
        }

        public void setLogid(String logid) {
            this.logid = logid;
        }

        public String getTemp1() {
            return temp1;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }
    }
    public static class DelQuotaListBean {

        /**
         * add_time : 2017-05-11
         * beat_quota : 5.00
         * id : 3810
         * money : 5.00
         * none : 1.00
         * user_id : 187
         */

        private String add_time;
        private String beat_quota;
        private String id;
        private String money;
        private String none;
        private String user_id;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getBeat_quota() {
            return beat_quota;
        }

        public void setBeat_quota(String beat_quota) {
            this.beat_quota = beat_quota;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
