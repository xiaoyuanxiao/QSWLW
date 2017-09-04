package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public class RankUnionBean {

    /**
     * 联盟商家销售额排行榜
     */

    private int i;
    private List<SingleLogBean> single_log;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public List<SingleLogBean> getSingle_log() {
        return single_log;
    }

    public void setSingle_log(List<SingleLogBean> single_log) {
        this.single_log = single_log;
    }

    public static class SingleLogBean {
        /**
         * sum_money : 11039330.00
         * user_id : 8895
         * photo : /Uploads/proof/2017-08-16/5993f0941f66f.jpg
         * store_name : 常熟市古里镇恒洁卫浴经营部
         */

        private String sum_money;
        private String user_id;
        private String photo;
        private String store_name;

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
    }
}
