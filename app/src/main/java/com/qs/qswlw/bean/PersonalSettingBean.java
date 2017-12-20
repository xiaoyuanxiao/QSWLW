package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/8/30.
 */

public class PersonalSettingBean {

    /**
     * buy_count : 0
     * count_commen : 0
     * cyzx_info : {"nickname":"吴泰森","user_id":"175"}
     * re_info : {"nickname":"吴泰森","user_id":"175"}
     * user_info : {"cyts_id":"175","cyzx_id":"175","gold_total":3148,"love_total":0,"mobile":"13800000004","nickname":"张肖","role":"11","silver_total":636935,"taxgold_total":1344,"uid":"175","user_id":"264"}
     */

    private String buy_count;
    private int count_commen;
    private String count_sum;
    private int none;
    private CyzxInfoBean cyzx_info;
    private ReInfoBean re_info;
    private UserInfoBean user_info;
    private ShopBean shop;
    private String last_rebate_date;
    private String loveval_model2_xfz;
    private String loveval_model2_shop;
    private String cash_money;
    private String cons_gold;
    private String shop_order;

    public String getCash_money() {
        return cash_money;
    }

    public void setCash_money(String cash_money) {
        this.cash_money = cash_money;
    }

    public String getCons_gold() {
        return cons_gold;
    }

    public void setCons_gold(String cons_gold) {
        this.cons_gold = cons_gold;
    }

    public String getShop_order() {
        return shop_order;
    }

    public void setShop_order(String shop_order) {
        this.shop_order = shop_order;
    }

    public String getLoveval_model2_xfz() {
        return loveval_model2_xfz;
    }

    public void setLoveval_model2_xfz(String loveval_model2_xfz) {
        this.loveval_model2_xfz = loveval_model2_xfz;
    }

    public String getLoveval_model2_shop() {
        return loveval_model2_shop;
    }

    public void setLoveval_model2_shop(String loveval_model2_shop) {
        this.loveval_model2_shop = loveval_model2_shop;
    }

    public String getCount_sum() {
        return count_sum;
    }

    public void setCount_sum(String count_sum) {
        this.count_sum = count_sum;
    }

    public int getNone() {
        return none;
    }

    public void setNone(int none) {
        this.none = none;
    }

    public String getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(String buy_count) {
        this.buy_count = buy_count;
    }

    public int getCount_commen() {
        return count_commen;
    }

    public void setCount_commen(int count_commen) {
        this.count_commen = count_commen;
    }

    public CyzxInfoBean getCyzx_info() {
        return cyzx_info;
    }

    public void setCyzx_info(CyzxInfoBean cyzx_info) {
        this.cyzx_info = cyzx_info;
    }

    public ReInfoBean getRe_info() {
        return re_info;
    }

    public void setRe_info(ReInfoBean re_info) {
        this.re_info = re_info;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
    }

    public String getLast_rebate_date() {
        return last_rebate_date;
    }

    public void setLast_rebate_date(String last_rebate_date) {
        this.last_rebate_date = last_rebate_date;
    }

    public static class CyzxInfoBean {
        /**
         * nickname : 吴泰森
         * user_id : 175
         */

        private String nickname;
        private String user_id;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

    public static class ReInfoBean {
        /**
         * nickname : 吴泰森
         * user_id : 175
         */

        private String nickname;
        private String user_id;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

    public static class ShopBean{
        private String company_name;
        private String name;

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class UserInfoBean {
        /**
         * cyts_id : 175
         * cyzx_id : 175
         * gold_total : 3148
         * love_total : 0
         * mobile : 13800000004
         * nickname : 张肖
         * role : 11
         * silver_total : 636935
         * taxgold_total : 1344
         * uid : 175
         * user_id : 264
         */

        private String cyts_id;
        private String cyzx_id;
        private int gold_total;
        private int love_total;
        private String mobile;
        private String nickname;
        private String role;
        private int silver_total;
        private int taxgold_total;
        private String uid;
        private String user_id;
        private String head_pic;

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getCyts_id() {
            return cyts_id;
        }

        public void setCyts_id(String cyts_id) {
            this.cyts_id = cyts_id;
        }

        public String getCyzx_id() {
            return cyzx_id;
        }

        public void setCyzx_id(String cyzx_id) {
            this.cyzx_id = cyzx_id;
        }

        public int getGold_total() {
            return gold_total;
        }

        public void setGold_total(int gold_total) {
            this.gold_total = gold_total;
        }

        public int getLove_total() {
            return love_total;
        }

        public void setLove_total(int love_total) {
            this.love_total = love_total;
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

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getSilver_total() {
            return silver_total;
        }

        public void setSilver_total(int silver_total) {
            this.silver_total = silver_total;
        }

        public int getTaxgold_total() {
            return taxgold_total;
        }

        public void setTaxgold_total(int taxgold_total) {
            this.taxgold_total = taxgold_total;
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
