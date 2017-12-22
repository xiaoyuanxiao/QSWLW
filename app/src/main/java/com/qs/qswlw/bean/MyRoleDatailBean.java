package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class MyRoleDatailBean {
    /**
     * user_list : []
     * count_num : 0
     * role_name : 创业主任
     */

    private int count_num;
    private String role_name;
    private List<UserListBean> user_list;

    public int getCount_num() {
        return count_num;
    }

    public void setCount_num(int count_num) {
        this.count_num = count_num;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<UserListBean> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<UserListBean> user_list) {
        this.user_list = user_list;
    }

    public class UserListBean{
        String user_id;
        String nickname;
        String role;
        String verify_time;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getVerify_time() {
            return verify_time;
        }

        public void setVerify_time(String verify_time) {
            this.verify_time = verify_time;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

}
