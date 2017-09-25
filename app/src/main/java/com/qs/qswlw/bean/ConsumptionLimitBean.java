package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitBean {

    /**
     * shop : {"business_id":"187","name":"津津食品旗舰店","company_name":"津津食品","tagold":"67040"}
     * list : [{"id":"382","user_id":"187","money":"30.00","none":null,"add_time":"2017-09-12 14:21:22","review_time":null,"pay_type":null,"is_ok":"2","remittance_img":null,"type":"deduction","old_money_count":"67040.00","thing":"taxgold","shop_id":null,"beizhu":null}]
     */

    private ShopBean shop;
    private List<ListBean> list;

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ShopBean {
        /**
         * business_id : 187
         * name : 津津食品旗舰店
         * company_name : 津津食品
         * tagold : 67040
         */

        private String business_id;
        private String name;
        private String company_name;
        private String tagold;

        public String getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(String business_id) {
            this.business_id = business_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getTagold() {
            return tagold;
        }

        public void setTagold(String tagold) {
            this.tagold = tagold;
        }
    }

    public static class ListBean {
        /**
         * id : 382
         * user_id : 187
         * money : 30.00
         * none : null
         * add_time : 2017-09-12 14:21:22
         * review_time : null
         * pay_type : null
         * is_ok : 2
         * remittance_img : null
         * type : deduction
         * old_money_count : 67040.00
         * thing : taxgold
         * shop_id : null
         * beizhu : null
         */

        private String id;
        private String user_id;
        private String money;
        private String none;
        private String add_time;
        private String review_time;
        private String pay_type;
        private String is_ok;
        private String remittance_img;
        private String type;
        private String old_money_count;
        private String thing;
        private String shop_id;
        private String beizhu;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getReview_time() {
            return review_time;
        }

        public void setReview_time(String review_time) {
            this.review_time = review_time;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getIs_ok() {
            return is_ok;
        }

        public void setIs_ok(String is_ok) {
            this.is_ok = is_ok;
        }

        public String getRemittance_img() {
            return remittance_img;
        }

        public void setRemittance_img(String remittance_img) {
            this.remittance_img = remittance_img;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOld_money_count() {
            return old_money_count;
        }

        public void setOld_money_count(String old_money_count) {
            this.old_money_count = old_money_count;
        }

        public String getThing() {
            return thing;
        }

        public void setThing(String thing) {
            this.thing = thing;
        }

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getBeizhu() {
            return beizhu;
        }

        public void setBeizhu(String beizhu) {
            this.beizhu = beizhu;
        }
    }
}
