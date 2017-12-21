package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyBonusBean {

    /**
     * cyzx_set : {"service_not_show_model1":"0","service_not_show_model2":"0","user_id":"175"}
     * gold_count_model1 : [{}]
     * gold_count_model2 : [{"temp1":"0.003","temp2":"0.000"}]
     * list : [{"add_time":"2017-11-28","gold":"0.001","model":"model2","role":"8","temp1":"0.000","temp2":"0.000","user_id":"187"},{"add_time":"2017-11-28","gold":"0.001","model":"model2","role":"9","temp1":"0.000","temp2":"0.000","user_id":"187"},{"add_time":"2017-11-28","gold":"0.003","model":"model2","role":"11","temp1":"0.002","temp2":"0.000","user_id":"187"},{"add_time":"2017-11-28","gold":"0.002","model":"model2","role":"15","temp1":"0.001","temp2":"0.000","user_id":"187"}]
     * model : {"gold":"0.003","taxgold":"0.000"}
     */

    private CyzxSetBean cyzx_set;
    private ModelBean model;
    private List<GoldCountModel1Bean> gold_count_model1;
    private List<GoldCountModel2Bean> gold_count_model2;
    private List<ListBean> list;

    public CyzxSetBean getCyzx_set() {
        return cyzx_set;
    }

    public void setCyzx_set(CyzxSetBean cyzx_set) {
        this.cyzx_set = cyzx_set;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public List<GoldCountModel1Bean> getGold_count_model1() {
        return gold_count_model1;
    }

    public void setGold_count_model1(List<GoldCountModel1Bean> gold_count_model1) {
        this.gold_count_model1 = gold_count_model1;
    }

    public List<GoldCountModel2Bean> getGold_count_model2() {
        return gold_count_model2;
    }

    public void setGold_count_model2(List<GoldCountModel2Bean> gold_count_model2) {
        this.gold_count_model2 = gold_count_model2;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CyzxSetBean {
        /**
         * service_not_show_model1 : 0
         * service_not_show_model2 : 0
         * user_id : 175
         */

        private String service_not_show_model1;
        private String service_not_show_model2;
        private String user_id;

        public String getService_not_show_model1() {
            return service_not_show_model1;
        }

        public void setService_not_show_model1(String service_not_show_model1) {
            this.service_not_show_model1 = service_not_show_model1;
        }

        public String getService_not_show_model2() {
            return service_not_show_model2;
        }

        public void setService_not_show_model2(String service_not_show_model2) {
            this.service_not_show_model2 = service_not_show_model2;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

    public static class ModelBean {
        private String gold;
        private String taxgold;

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getTaxgold() {
            return taxgold;
        }

        public void setTaxgold(String taxgold) {
            this.taxgold = taxgold;
        }
    }

    public static class GoldCountModel1Bean {
        private String temp1;
        private String temp2;

        public String getTemp1() {
            return temp1;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }
    }

    public static class GoldCountModel2Bean {
        /**
         * temp1 : 0.003
         * temp2 : 0.000
         */

        private String temp1;
        private String temp2;

        public String getTemp1() {
            return temp1;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }
    }

    public static class ListBean {
        /**
         * add_time : 2017-11-28
         * gold : 0.001
         * model : model2
         * role : 8
         * temp1 : 0.000
         * temp2 : 0.000
         * user_id : 187
         */

        private String add_time;
        private String gold;
        private String model;
        private String role;
        private String temp1;
        private String temp2;
        private String user_id;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getTemp1() {
            return temp1;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
