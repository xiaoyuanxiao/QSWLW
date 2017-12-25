package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public class MyOrganizationBean {

    /**
     * tui_data : [{"nickname":"红酒姐姐 ","role":"0","total":0,"user_id":"41947"},{"nickname":"红酒姐姐 ","role":"0","total":0,"user_id":"41949"},{"nickname":"红酒姐姐 ","role":"0","total":0,"user_id":"41950"},{"nickname":"红酒姐姐 ","role":"0","total":0,"user_id":"41951"},{"nickname":"常乐。","role":"0","total":0,"user_id":"41952"},{"nickname":"Ayia","role":"0","total":0,"user_id":"41962"},{"nickname":"Ayia","role":"0","total":0,"user_id":"41963"},{"nickname":"test1","role":"0","total":0,"user_id":"41976"},{"nickname":"test2","role":"0","total":0,"user_id":"41977"},{"nickname":"Ayia","role":"0","total":0,"user_id":"41989"},{"nickname":"test2","role":"10","total":0,"user_id":"42436"},{"nickname":"Qin02","role":"10","total":0,"user_id":"67449"},{"nickname":"顕纔","role":"0","total":0,"user_id":"72192"},{"nickname":"lin","role":"10","total":0,"user_id":"83891"}]
     * user : {"nickname":"小倩","role":"8","user_id":"187"}
     */

    private UserBean user;
    private List<TuiDataBean> tui_data;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<TuiDataBean> getTui_data() {
        return tui_data;
    }

    public void setTui_data(List<TuiDataBean> tui_data) {
        this.tui_data = tui_data;
    }

    public static class UserBean {
        /**
         * nickname : 小倩
         * role : 8
         * user_id : 187
         */

        private String nickname;
        private String role;
        private String user_id;
        private String head_pic;

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

    public static class TuiDataBean {
        /**
         * nickname : 红酒姐姐
         * role : 0
         * total : 0
         * user_id : 41947
         */

        private String nickname;
        private String role;
        private double total;
        private String user_id;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

}
