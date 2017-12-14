package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public class PopRankingBean {

    /**
     * i : 1
     * list : [{"city":"0","district":"0","nickname":"admin","province":"0","total":"15893870448.28","user_id":"1"},{"city":"11348","district":"11448","nickname":"纪杰","province":"10808","sheng_name":"江苏省","total":"25650792.86","user_id":"87"}]
     * role :
     * time_slot :
     */

    private int i;
    private String role;
    private String time_slot;
    private List<ListBean> list;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * city : 0
         * district : 0
         * nickname : admin
         * province : 0
         * total : 15893870448.28
         * user_id : 1
         * sheng_name : 江苏省
         */

        private String city;
        private String district;
        private String nickname;
        private String province;
        private String total;
        private String user_id;
        private String sheng_name;
        private String head_pic;

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSheng_name() {
            return sheng_name;
        }

        public void setSheng_name(String sheng_name) {
            this.sheng_name = sheng_name;
        }
    }

}
