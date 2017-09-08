package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class MyGoldBean {
    /**
     * list : [{"logid":"165001","user_id":"187","dellove":"0","total":null,"none":"0.00","loveval_model":"1.87","model":"model2","gold":"6.79","add_time":"2017-06-30","mark":"0","role":"10","sid":"0","temp1":"4.753","temp2":"2.037","give_id":"0","consume_quota":"0.000"}]
     * temp1_count : 40124.660
     * temp2_count : 55.140
     * config : {"return_model1_get":100,"return_model2_get":20}
     * tjjd : {"gold":null,"taxgold":null}
     * model : {"gold":"40128.377","taxgold":"56.733"}
     * give_gold : {"gold":"20.000","taxgold":"0.000"}
     */

    private String temp1_count;
    private String temp2_count;
    private ConfigBean config;
    private TjjdBean tjjd;
    private ModelBean model;
    private GiveGoldBean give_gold;
    private List<ListBean> list;

    public String getTemp1_count() {
        return temp1_count;
    }

    public void setTemp1_count(String temp1_count) {
        this.temp1_count = temp1_count;
    }

    public String getTemp2_count() {
        return temp2_count;
    }

    public void setTemp2_count(String temp2_count) {
        this.temp2_count = temp2_count;
    }

    public ConfigBean getConfig() {
        return config;
    }

    public void setConfig(ConfigBean config) {
        this.config = config;
    }

    public TjjdBean getTjjd() {
        return tjjd;
    }

    public void setTjjd(TjjdBean tjjd) {
        this.tjjd = tjjd;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public GiveGoldBean getGive_gold() {
        return give_gold;
    }

    public void setGive_gold(GiveGoldBean give_gold) {
        this.give_gold = give_gold;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ConfigBean {
        /**
         * return_model1_get : 100
         * return_model2_get : 20
         */

        private int return_model1_get;
        private int return_model2_get;

        public int getReturn_model1_get() {
            return return_model1_get;
        }

        public void setReturn_model1_get(int return_model1_get) {
            this.return_model1_get = return_model1_get;
        }

        public int getReturn_model2_get() {
            return return_model2_get;
        }

        public void setReturn_model2_get(int return_model2_get) {
            this.return_model2_get = return_model2_get;
        }
    }

    public static class TjjdBean {
        /**
         * gold : null
         * taxgold : null
         */

        private Object gold;
        private Object taxgold;

        public Object getGold() {
            return gold;
        }

        public void setGold(Object gold) {
            this.gold = gold;
        }

        public Object getTaxgold() {
            return taxgold;
        }

        public void setTaxgold(Object taxgold) {
            this.taxgold = taxgold;
        }
    }

    public static class ModelBean {
        /**
         * gold : 40128.377
         * taxgold : 56.733
         */

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

    public static class GiveGoldBean {
        /**
         * gold : 20.000
         * taxgold : 0.000
         */

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

    public static class ListBean {
        /**
         * logid : 165001
         * user_id : 187
         * dellove : 0
         * total : null
         * none : 0.00
         * loveval_model : 1.87
         * model : model2
         * gold : 6.79
         * add_time : 2017-06-30
         * mark : 0
         * role : 10
         * sid : 0
         * temp1 : 4.753
         * temp2 : 2.037
         * give_id : 0
         * consume_quota : 0.000
         */

        private String logid;
        private String user_id;
        private String dellove;
        private Object total;
        private String none;
        private String loveval_model;
        private String model;
        private String gold;
        private String add_time;
        private String mark;
        private String role;
        private String sid;
        private String temp1;
        private String temp2;
        private String give_id;
        private String consume_quota;

        public String getLogid() {
            return logid;
        }

        public void setLogid(String logid) {
            this.logid = logid;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getDellove() {
            return dellove;
        }

        public void setDellove(String dellove) {
            this.dellove = dellove;
        }

        public Object getTotal() {
            return total;
        }

        public void setTotal(Object total) {
            this.total = total;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getLoveval_model() {
            return loveval_model;
        }

        public void setLoveval_model(String loveval_model) {
            this.loveval_model = loveval_model;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
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

        public String getGive_id() {
            return give_id;
        }

        public void setGive_id(String give_id) {
            this.give_id = give_id;
        }

        public String getConsume_quota() {
            return consume_quota;
        }

        public void setConsume_quota(String consume_quota) {
            this.consume_quota = consume_quota;
        }
    }
}
