package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public class RankingBean {

    private int i;
    private String time_slot;
    private List<SingleLogBean> single_log;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    public List<SingleLogBean> getSingle_log() {
        return single_log;
    }

    public void setSingle_log(List<SingleLogBean> single_log) {
        this.single_log = single_log;
    }

    public static class SingleLogBean {
        /**
         * photo : /Uploads/proof/2017-05-11/5914144f75a00.jpg
         * store_name : 方圆老酒店
         * sum_money : 336000.00
         * user_id : 7046
         */

        private String photo;
        private String store_name;
        private String sum_money;
        private String user_id;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getSum_money() {
            return sum_money;
        }

        public void setSum_money(String sum_money) {
            this.sum_money = sum_money;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
