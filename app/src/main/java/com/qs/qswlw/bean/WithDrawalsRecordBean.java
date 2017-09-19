package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public class WithDrawalsRecordBean {
    /**
     * money_count : 2000.00
     * list : [{"id":"67762","user_id":"187","money":"1000.00","brokerage":"5.00","status":"0","is_pre":"0","is_fail":"0","is_revoke":"0","create_time":"1505112208","user_up_fail_info":"0"}]
     */

    private String money_count;
    private List<ListBean> list;

    public String getMoney_count() {
        return money_count;
    }

    public void setMoney_count(String money_count) {
        this.money_count = money_count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 67762
         * user_id : 187
         * money : 1000.00
         * brokerage : 5.00
         * status : 0
         * is_pre : 0
         * is_fail : 0
         * is_revoke : 0
         * create_time : 1505112208
         * user_up_fail_info : 0
         */

        private String id;
        private String user_id;
        private String money;
        private String brokerage;
        private String status;
        private String is_pre;
        private String is_fail;
        private String is_revoke;
        private String create_time;
        private String user_up_fail_info;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getBrokerage() {
            return brokerage;
        }

        public void setBrokerage(String brokerage) {
            this.brokerage = brokerage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_pre() {
            return is_pre;
        }

        public void setIs_pre(String is_pre) {
            this.is_pre = is_pre;
        }

        public String getIs_fail() {
            return is_fail;
        }

        public void setIs_fail(String is_fail) {
            this.is_fail = is_fail;
        }

        public String getIs_revoke() {
            return is_revoke;
        }

        public void setIs_revoke(String is_revoke) {
            this.is_revoke = is_revoke;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUser_up_fail_info() {
            return user_up_fail_info;
        }

        public void setUser_up_fail_info(String user_up_fail_info) {
            this.user_up_fail_info = user_up_fail_info;
        }
    }
}
