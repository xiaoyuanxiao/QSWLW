package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/8/29.
 */

public class LoginBean {
    /**
     * userinfo : {"is_frozen":"0","mobile":"15200000004","nickname":"会员昵称1","reg_time":"1491813970","token":"39edbdf5f6363b870ea9c6b555dc4132","user_id":"187"}
     */

    private UserinfoBean userinfo;

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public static class UserinfoBean {
        /**
         * is_frozen : 0
         * mobile : 15200000004
         * nickname : 会员昵称1
         * reg_time : 1491813970
         * token : 39edbdf5f6363b870ea9c6b555dc4132
         * user_id : 187
         */

        private String is_frozen;
        private String mobile;
        private String nickname;
        private String reg_time;
        private String token;
        private String user_id;
        private String head_pic;
        private String role;


        public String getIs_frozen() {
            return is_frozen;
        }

        public void setIs_frozen(String is_frozen) {
            this.is_frozen = is_frozen;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getReg_time() {
            return reg_time;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

}
