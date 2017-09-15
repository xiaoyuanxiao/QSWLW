package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public class MyProfitBean {
    private String count;
    private String sum;
    private List<ListBean> list;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * add_time : 2017-09-13
         * id : 14106
         * is_go : 0
         * money : 10.00
         * nickname : 凯迪威
         * none : 10.00
         * uid : 182
         * user_id : 187
         */

        private String add_time;
        private String id;
        private String is_go;
        private String money;
        private String nickname;
        private String none;
        private String uid;
        private String user_id;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIs_go() {
            return is_go;
        }

        public void setIs_go(String is_go) {
            this.is_go = is_go;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

}
