package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/21.
 */

public class WithdrawalsCityBean {

    private List<ClistBean> clist;

    public List<ClistBean> getClist() {
        return clist;
    }

    public void setClist(List<ClistBean> clist) {
        this.clist = clist;
    }

    public static class ClistBean {
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
