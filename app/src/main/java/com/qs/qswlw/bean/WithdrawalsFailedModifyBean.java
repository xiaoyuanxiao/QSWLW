package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/22.
 */

public class WithdrawalsFailedModifyBean {

    /**
     * clist : [{"id":"5060","name":"江苏","parent_id":"3418","sort_order":"255","area_id":"1","bank_code":"102301000116"}]
     * shi_list : [{"id":"5135","name":"南通","parent_id":"5060","sort_order":"255","area_id":"0","bank_code":""}]
     * list : {"id":"62462","user_id":"187","cardholder":"系统测","to_bank":"中国工商银行","region":"5060","city":"5135","branch":"南通支行","bank_card":"621475368741556867"}
     */

    private ListBean list;
    private List<ClistBean> clist;
    private List<ShiListBean> shi_list;

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
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

    public static class ListBean {
        /**
         * id : 62462
         * user_id : 187
         * cardholder : 系统测
         * to_bank : 中国工商银行
         * region : 5060
         * city : 5135
         * branch : 南通支行
         * bank_card : 621475368741556867
         */

        private String id;
        private String user_id;
        private String cardholder;
        private String to_bank;
        private String region;
        private String city;
        private String branch;
        private String bank_card;

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

        public String getCardholder() {
            return cardholder;
        }

        public void setCardholder(String cardholder) {
            this.cardholder = cardholder;
        }

        public String getTo_bank() {
            return to_bank;
        }

        public void setTo_bank(String to_bank) {
            this.to_bank = to_bank;
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

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBank_card() {
            return bank_card;
        }

        public void setBank_card(String bank_card) {
            this.bank_card = bank_card;
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
