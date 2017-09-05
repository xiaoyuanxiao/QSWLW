package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MyRoleBean {

    /**
     * user_id : 187
     * nickname : 倩茜
     * role : 10
     * head_pic : null
     * reg_time : 1491813970
     * cyzx_id : 175
     * cyts_id : 178
     * is_cyzx : 0
     * is_cyts : 0
     * is_qu : 0
     * is_shi : 0
     * is_sheng : 0
     * cyzx_name : {"nickname":"吴泰森"}
     * cyzx_address : {"address":"钱盛国际3楼"}
     * shop : {"company_name":"津津食品"}
     */

    private String user_id;
    private String nickname;
    private String role;
    private Object head_pic;
    private String reg_time;
    private String cyzx_id;
    private String cyts_id;
    private String is_cyzx;
    private String is_cyts;
    private String is_qu;
    private String is_shi;
    private String is_sheng;
    private CyzxNameBean cyzx_name;
    private CyzxAddressBean cyzx_address;
    private ShopBean shop;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public Object getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(Object head_pic) {
        this.head_pic = head_pic;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public String getCyzx_id() {
        return cyzx_id;
    }

    public void setCyzx_id(String cyzx_id) {
        this.cyzx_id = cyzx_id;
    }

    public String getCyts_id() {
        return cyts_id;
    }

    public void setCyts_id(String cyts_id) {
        this.cyts_id = cyts_id;
    }

    public String getIs_cyzx() {
        return is_cyzx;
    }

    public void setIs_cyzx(String is_cyzx) {
        this.is_cyzx = is_cyzx;
    }

    public String getIs_cyts() {
        return is_cyts;
    }

    public void setIs_cyts(String is_cyts) {
        this.is_cyts = is_cyts;
    }

    public String getIs_qu() {
        return is_qu;
    }

    public void setIs_qu(String is_qu) {
        this.is_qu = is_qu;
    }

    public String getIs_shi() {
        return is_shi;
    }

    public void setIs_shi(String is_shi) {
        this.is_shi = is_shi;
    }

    public String getIs_sheng() {
        return is_sheng;
    }

    public void setIs_sheng(String is_sheng) {
        this.is_sheng = is_sheng;
    }

    public CyzxNameBean getCyzx_name() {
        return cyzx_name;
    }

    public void setCyzx_name(CyzxNameBean cyzx_name) {
        this.cyzx_name = cyzx_name;
    }

    public CyzxAddressBean getCyzx_address() {
        return cyzx_address;
    }

    public void setCyzx_address(CyzxAddressBean cyzx_address) {
        this.cyzx_address = cyzx_address;
    }

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
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

    public static class CyzxAddressBean {
        /**
         * address : 钱盛国际3楼
         */

        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class ShopBean {
        /**
         * company_name : 津津食品
         */

        private String company_name;

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }
    }
}
