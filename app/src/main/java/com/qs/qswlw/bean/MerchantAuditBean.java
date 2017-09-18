package com.qs.qswlw.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditBean {

    /**
     * list : [{"id":"7964","user_id":"187","uid":"1","add_time":"2017-05-28","none":"20000.00","money":"132000.00","is_ok":"0"}]
     * today_sum : {"money":"0.00","none":"0.00"}
     * yesterday_sum : {"money":"0.00","none":"0.00"}
     */

    private TodaySumBean today_sum;
    private YesterdaySumBean yesterday_sum;
    private List<ListBean> list;

    public TodaySumBean getToday_sum() {
        return today_sum;
    }

    public void setToday_sum(TodaySumBean today_sum) {
        this.today_sum = today_sum;
    }

    public YesterdaySumBean getYesterday_sum() {
        return yesterday_sum;
    }

    public void setYesterday_sum(YesterdaySumBean yesterday_sum) {
        this.yesterday_sum = yesterday_sum;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class TodaySumBean {
        /**
         * money : 0.00
         * none : 0.00
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

    public static class YesterdaySumBean {
        /**
         * money : 0.00
         * none : 0.00
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

    public static class ListBean  implements Serializable {
        /**
         * id : 7964
         * user_id : 187
         * uid : 1
         * add_time : 2017-05-28
         * none : 20000.00
         * money : 132000.00
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
