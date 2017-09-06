package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public class EntrepreneurialIncentiveBean {

    /**
     * exchange_love : 500
     * allow_silver : 100000
     * allow_silver_model2 : 100012
     * model1 : 0
     * model2 : 0
     * love : 4
     * love2 : 0
     * silver : 98000
     * silver2 : 100012
     * config : {"return_model1_get":"100","return_model2_get":"20"}
     * list_model1 : [{"ctime":"2017-05-28","silver":"132000.00","bean":null,"add_time":"2017-05-28","total":"132000.00","model":"model1"}]
     * list_model2 : [{"ctime":"2017-05-28","silver":"132000.00","bean":null,"add_time":"2017-05-28","total":"132000.00","model":"model1"}]
     */

    private String exchange_love;
    private String allow_silver;
    private String allow_silver_model2;
    private int model1;
    private int model2;
    private int love;
    private int love2;
    private int silver;
    private int silver2;
    private ConfigBean config;
    private List<ListModel1Bean> list_model1;
    private List<ListModel2Bean> list_model2;

    public String getExchange_love() {
        return exchange_love;
    }

    public void setExchange_love(String exchange_love) {
        this.exchange_love = exchange_love;
    }

    public String getAllow_silver() {
        return allow_silver;
    }

    public void setAllow_silver(String allow_silver) {
        this.allow_silver = allow_silver;
    }

    public String getAllow_silver_model2() {
        return allow_silver_model2;
    }

    public void setAllow_silver_model2(String allow_silver_model2) {
        this.allow_silver_model2 = allow_silver_model2;
    }

    public int getModel1() {
        return model1;
    }

    public void setModel1(int model1) {
        this.model1 = model1;
    }

    public int getModel2() {
        return model2;
    }

    public void setModel2(int model2) {
        this.model2 = model2;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getLove2() {
        return love2;
    }

    public void setLove2(int love2) {
        this.love2 = love2;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getSilver2() {
        return silver2;
    }

    public void setSilver2(int silver2) {
        this.silver2 = silver2;
    }

    public ConfigBean getConfig() {
        return config;
    }

    public void setConfig(ConfigBean config) {
        this.config = config;
    }

    public List<ListModel1Bean> getList_model1() {
        return list_model1;
    }

    public void setList_model1(List<ListModel1Bean> list_model1) {
        this.list_model1 = list_model1;
    }

    public List<ListModel2Bean> getList_model2() {
        return list_model2;
    }

    public void setList_model2(List<ListModel2Bean> list_model2) {
        this.list_model2 = list_model2;
    }

    public static class ConfigBean {
        /**
         * return_model1_get : 100
         * return_model2_get : 20
         */

        private String return_model1_get;
        private String return_model2_get;

        public String getReturn_model1_get() {
            return return_model1_get;
        }

        public void setReturn_model1_get(String return_model1_get) {
            this.return_model1_get = return_model1_get;
        }

        public String getReturn_model2_get() {
            return return_model2_get;
        }

        public void setReturn_model2_get(String return_model2_get) {
            this.return_model2_get = return_model2_get;
        }
    }

    public static class ListModel1Bean {
        /**
         * ctime : 2017-05-28
         * silver : 132000.00
         * bean : null
         * add_time : 2017-05-28
         * total : 132000.00
         * model : model1
         */

        private String ctime;
        private String silver;
        private Object bean;
        private String add_time;
        private String total;
        private String model;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getSilver() {
            return silver;
        }

        public void setSilver(String silver) {
            this.silver = silver;
        }

        public Object getBean() {
            return bean;
        }

        public void setBean(Object bean) {
            this.bean = bean;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

    public static class ListModel2Bean {
        /**
         * ctime : 2017-05-28
         * silver : 132000.00
         * bean : null
         * add_time : 2017-05-28
         * total : 132000.00
         * model : model1
         */

        private String ctime;
        private String silver;
        private Object bean;
        private String add_time;
        private String total;
        private String model;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getSilver() {
            return silver;
        }

        public void setSilver(String silver) {
            this.silver = silver;
        }

        public Object getBean() {
            return bean;
        }

        public void setBean(Object bean) {
            this.bean = bean;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

}
