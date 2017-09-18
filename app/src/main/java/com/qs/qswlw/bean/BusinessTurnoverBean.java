package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class BusinessTurnoverBean {
    /**
     * count_money : 652180.00
     * count_none : 124036.00
     * list : [{"user_id":"187","uid":"1","add_time":"2017-05-28","money":"132000.00","none":"20000.00","user_name":{"nickname":"admin"}}]
     */

    private String count_money;
    private String count_none;
    private List<ListBean> list;

    public String getCount_money() {
        return count_money;
    }

    public void setCount_money(String count_money) {
        this.count_money = count_money;
    }

    public String getCount_none() {
        return count_none;
    }

    public void setCount_none(String count_none) {
        this.count_none = count_none;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * user_id : 187
         * uid : 1
         * add_time : 2017-05-28
         * money : 132000.00
         * none : 20000.00
         * user_name : {"nickname":"admin"}
         */

        private String user_id;
        private String uid;
        private String add_time;
        private String money;
        private String none;
        private UserNameBean user_name;

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

        public UserNameBean getUser_name() {
            return user_name;
        }

        public void setUser_name(UserNameBean user_name) {
            this.user_name = user_name;
        }

        public static class UserNameBean {
            /**
             * nickname : admin
             */

            private String nickname;

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }
        }
    }
}
