package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class ScanCodeRecordBean {
    /**
     * list : [{"id":"14026","user_id":"41953","uid":"187","add_time":"2017-08-12","none":"24691.00","money":"123456.00","is_ok":"0"}]
     * sum_data : {"money":"1481478.00","none":"296295.00"}
     */

    private SumDataBean sum_data;
    private List<ListBean> list;

    public SumDataBean getSum_data() {
        return sum_data;
    }

    public void setSum_data(SumDataBean sum_data) {
        this.sum_data = sum_data;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class SumDataBean {
        /**
         * money : 1481478.00
         * none : 296295.00
         */

        private String money;
        private String none;

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
    }

    public static class ListBean {
        /**
         * id : 14026
         * user_id : 41953
         * uid : 187
         * add_time : 2017-08-12
         * none : 24691.00
         * money : 123456.00
         * is_ok : 0
         */

        private String id;
        private String user_id;
        private String uid;
        private String add_time;
        private String none;
        private String money;
        private String is_ok;

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

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getIs_ok() {
            return is_ok;
        }

        public void setIs_ok(String is_ok) {
            this.is_ok = is_ok;
        }
    }
}
