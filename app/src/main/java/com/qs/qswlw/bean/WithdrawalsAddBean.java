package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class WithdrawalsAddBean {

    private InfoBean info;
    private List<ClistBean> clist;
    private List<ShiListBean> shi_list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ClistBean> getClist() {
        return clist;
    }

    public void setClist(List<ClistBean> clist) {
        this.clist = clist;
    }

    public List<ShiListBean> getShi_list() {
        return shi_list;
    }

    public void setShi_list(List<ShiListBean> shi_list) {
        this.shi_list = shi_list;
    }

    public static class InfoBean {
        /**
         * id : 5672
         * user_id : 187
         * name : 系统测
         * cardxy : 中国工商银行
         * region : 5060
         * city : 5135
         * card : 南通支行
         * number : 621475368741556867
         * tacitd : 1
         * is_edit : 0
         * is_lock : 1
         * lock_time : 1497689340
         * update_time : null
         */

        private String id;
        private String user_id;
        private String name;
        private String cardxy;
        private String region;
        private String city;
        private String card;
        private String number;
        private String tacitd;
        private String is_edit;
        private String is_lock;
        private String lock_time;
        private Object update_time;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCardxy() {
            return cardxy;
        }

        public void setCardxy(String cardxy) {
            this.cardxy = cardxy;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTacitd() {
            return tacitd;
        }

        public void setTacitd(String tacitd) {
            this.tacitd = tacitd;
        }

        public String getIs_edit() {
            return is_edit;
        }

        public void setIs_edit(String is_edit) {
            this.is_edit = is_edit;
        }

        public String getIs_lock() {
            return is_lock;
        }

        public void setIs_lock(String is_lock) {
            this.is_lock = is_lock;
        }

        public String getLock_time() {
            return lock_time;
        }

        public void setLock_time(String lock_time) {
            this.lock_time = lock_time;
        }

        public Object getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Object update_time) {
            this.update_time = update_time;
        }
    }

    public static class ClistBean {
        /**
         * id : 5060
         * name : 江苏
         * parent_id : 3418
         * sort_order : 255
         * area_id : 1
         * bank_code : 102301000116
         */

        private String id;
        private String name;
        private String parent_id;
        private String sort_order;
        private String area_id;
        private String bank_code;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getBank_code() {
            return bank_code;
        }

        public void setBank_code(String bank_code) {
            this.bank_code = bank_code;
        }
    }

    public static class ShiListBean {
        /**
         * id : 5135
         * name : 南通
         * parent_id : 5060
         * sort_order : 255
         * area_id : 0
         * bank_code :
         */

        private String id;
        private String name;
        private String parent_id;
        private String sort_order;
        private String area_id;
        private String bank_code;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getBank_code() {
            return bank_code;
        }

        public void setBank_code(String bank_code) {
            this.bank_code = bank_code;
        }
    }
}
