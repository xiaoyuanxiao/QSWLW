package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MyRoleBean {
    /**
     * cyts_id : 178
     * cyzx_address : {"address":"荔新公路"}
     * cyzx_id : 175
     * cyzx_name : {"nickname":"吴泰森"}
     * head_pic : /Uploads/proof/2017-12-19/5a387380100eb.png
     * is_cyts : 0
     * is_cyzx : 0
     * is_qu : 0
     * is_sheng : 0
     * is_shi : 0
     * logs : [{"id":"2400","is_to":"1","nickname":"取消","role_name":"创业总监","up_time":"1508638225","up_to_role":"9","up_yuan_role":"10","user_id":"187","verify_time":"1508638225","verify_user":"xiaoqin","yuan_role_name":"商家"},{"id":"2401","is_to":"1","nickname":"取消","role_name":"创业总监","up_time":"1508638395","up_to_role":"9","up_yuan_role":"0","user_id":"187","verify_time":"1508638395","verify_user":"xiaoqin","yuan_role_name":"消费天使"},{"id":"2402","is_to":"1","nickname":"取消","role_name":"创业总监","up_time":"1508638684","up_to_role":"9","up_yuan_role":"0","user_id":"187","verify_time":"1508638684","verify_user":"xiaoqin","yuan_role_name":"消费天使"},{"id":"2403","is_to":"1","nickname":"取消","role_name":"创业总监","up_time":"1508638767","up_to_role":"9","up_yuan_role":"0","user_id":"187","verify_time":"1508638767","verify_user":"xiaoqin","yuan_role_name":"消费天使"},{"id":"2404","is_to":"1","nickname":"取消","role_name":"创业董事","up_time":"1508638831","up_to_role":"8","up_yuan_role":"9","user_id":"187","verify_time":"1508638831","verify_user":"xiaoqin","yuan_role_name":"创业总监"}]
     * nickname : 取消
     * reg_time : 1491813970
     * role : 8
     * role_count : {"shop_none":0,"shop_num":3,"shop_yj":0,"xfz_num":13}
     * up_grades : {"condition1":"10","condition2":"0","condition3":"100000","id":"1","type":"11","use_money":"288.00","value1":"5","value2":"5"}
     * user_id : 187
     */

    private String cyts_id;
    private CyzxAddressBean cyzx_address;
    private String cyzx_id;
    private CyzxNameBean cyzx_name;
    private String head_pic;
    private String is_cyts;
    private String is_cyzx;
    private String is_qu;
    private String is_sheng;
    private String is_shi;
    private String nickname;
    private String reg_time;
    private String role;
    private RoleCountBean role_count;
    private UpGradesBean up_grades;
    private String user_id;
    private List<LogsBean> logs;

    public String getCyts_id() {
        return cyts_id;
    }

    public void setCyts_id(String cyts_id) {
        this.cyts_id = cyts_id;
    }

    public CyzxAddressBean getCyzx_address() {
        return cyzx_address;
    }

    public void setCyzx_address(CyzxAddressBean cyzx_address) {
        this.cyzx_address = cyzx_address;
    }

    public String getCyzx_id() {
        return cyzx_id;
    }

    public void setCyzx_id(String cyzx_id) {
        this.cyzx_id = cyzx_id;
    }

    public CyzxNameBean getCyzx_name() {
        return cyzx_name;
    }

    public void setCyzx_name(CyzxNameBean cyzx_name) {
        this.cyzx_name = cyzx_name;
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public String getIs_cyts() {
        return is_cyts;
    }

    public void setIs_cyts(String is_cyts) {
        this.is_cyts = is_cyts;
    }

    public String getIs_cyzx() {
        return is_cyzx;
    }

    public void setIs_cyzx(String is_cyzx) {
        this.is_cyzx = is_cyzx;
    }

    public String getIs_qu() {
        return is_qu;
    }

    public void setIs_qu(String is_qu) {
        this.is_qu = is_qu;
    }

    public String getIs_sheng() {
        return is_sheng;
    }

    public void setIs_sheng(String is_sheng) {
        this.is_sheng = is_sheng;
    }

    public String getIs_shi() {
        return is_shi;
    }

    public void setIs_shi(String is_shi) {
        this.is_shi = is_shi;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RoleCountBean getRole_count() {
        return role_count;
    }

    public void setRole_count(RoleCountBean role_count) {
        this.role_count = role_count;
    }

    public UpGradesBean getUp_grades() {
        return up_grades;
    }

    public void setUp_grades(UpGradesBean up_grades) {
        this.up_grades = up_grades;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<LogsBean> getLogs() {
        return logs;
    }

    public void setLogs(List<LogsBean> logs) {
        this.logs = logs;
    }

    public static class CyzxAddressBean {
        /**
         * address : 荔新公路
         */

        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class CyzxNameBean {
        /**
         * nickname : 吴泰森
         */

        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

    public static class RoleCountBean {
        /**
         * shop_none : 0
         * shop_num : 3
         * shop_yj : 0
         * xfz_num : 13
         */

        private int shop_none;
        private int shop_num;
        private int shop_yj;
        private int xfz_num;

        public int getShop_none() {
            return shop_none;
        }

        public void setShop_none(int shop_none) {
            this.shop_none = shop_none;
        }

        public int getShop_num() {
            return shop_num;
        }

        public void setShop_num(int shop_num) {
            this.shop_num = shop_num;
        }

        public int getShop_yj() {
            return shop_yj;
        }

        public void setShop_yj(int shop_yj) {
            this.shop_yj = shop_yj;
        }

        public int getXfz_num() {
            return xfz_num;
        }

        public void setXfz_num(int xfz_num) {
            this.xfz_num = xfz_num;
        }
    }

    public static class UpGradesBean {
        /**
         * condition1 : 10
         * condition2 : 0
         * condition3 : 100000
         * id : 1
         * type : 11
         * use_money : 288.00
         * value1 : 5
         * value2 : 5
         */

        private String condition1;
        private String condition2;
        private String condition3;
        private String id;
        private String type;
        private String use_money;
        private String value1;
        private String value2;

        public String getCondition1() {
            return condition1;
        }

        public void setCondition1(String condition1) {
            this.condition1 = condition1;
        }

        public String getCondition2() {
            return condition2;
        }

        public void setCondition2(String condition2) {
            this.condition2 = condition2;
        }

        public String getCondition3() {
            return condition3;
        }

        public void setCondition3(String condition3) {
            this.condition3 = condition3;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUse_money() {
            return use_money;
        }

        public void setUse_money(String use_money) {
            this.use_money = use_money;
        }

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }
    }

    public static class LogsBean {
        /**
         * id : 2400
         * is_to : 1
         * nickname : 取消
         * role_name : 创业总监
         * up_time : 1508638225
         * up_to_role : 9
         * up_yuan_role : 10
         * user_id : 187
         * verify_time : 1508638225
         * verify_user : xiaoqin
         * yuan_role_name : 商家
         */

        private String id;
        private String is_to;
        private String nickname;
        private String role_name;
        private String up_time;
        private String up_to_role;
        private String up_yuan_role;
        private String user_id;
        private String verify_time;
        private String verify_user;
        private String yuan_role_name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIs_to() {
            return is_to;
        }

        public void setIs_to(String is_to) {
            this.is_to = is_to;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRole_name() {
            return role_name;
        }

        public void setRole_name(String role_name) {
            this.role_name = role_name;
        }

        public String getUp_time() {
            return up_time;
        }

        public void setUp_time(String up_time) {
            this.up_time = up_time;
        }

        public String getUp_to_role() {
            return up_to_role;
        }

        public void setUp_to_role(String up_to_role) {
            this.up_to_role = up_to_role;
        }

        public String getUp_yuan_role() {
            return up_yuan_role;
        }

        public void setUp_yuan_role(String up_yuan_role) {
            this.up_yuan_role = up_yuan_role;
        }

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

        public String getVerify_user() {
            return verify_user;
        }

        public void setVerify_user(String verify_user) {
            this.verify_user = verify_user;
        }

        public String getYuan_role_name() {
            return yuan_role_name;
        }

        public void setYuan_role_name(String yuan_role_name) {
            this.yuan_role_name = yuan_role_name;
        }
    }
}
