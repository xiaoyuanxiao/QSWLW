package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class test {

    /**
     * status : 1
     * succ : 1
     * msg : 成功！
     * result : {"silver_count":{"silver":"0.00","total":"120800.00"},"single_log":[{"ctime":"2017-06-18","silver":"0.00","total":"120000.00","bean":null,"relic":null,"give_id":"0","add_time":"2017-06-18","singleid":"11018","sp_name":"江苏省无锡市南禅寺妙光街134号A景悦珠宝","company_name":"景悦珠宝","goods_img":"/Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg","goods_id":"256"}]}
     */

    private int status;
    private int succ;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSucc() {
        return succ;
    }

    public void setSucc(int succ) {
        this.succ = succ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * silver_count : {"silver":"0.00","total":"120800.00"}
         * single_log : [{"ctime":"2017-06-18","silver":"0.00","total":"120000.00","bean":null,"relic":null,"give_id":"0","add_time":"2017-06-18","singleid":"11018","sp_name":"江苏省无锡市南禅寺妙光街134号A景悦珠宝","company_name":"景悦珠宝","goods_img":"/Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg","goods_id":"256"}]
         */

        private SilverCountBean silver_count;
        private List<SingleLogBean> single_log;

        public SilverCountBean getSilver_count() {
            return silver_count;
        }

        public void setSilver_count(SilverCountBean silver_count) {
            this.silver_count = silver_count;
        }

        public List<SingleLogBean> getSingle_log() {
            return single_log;
        }

        public void setSingle_log(List<SingleLogBean> single_log) {
            this.single_log = single_log;
        }

        public static class SilverCountBean {
            /**
             * silver : 0.00
             * total : 120800.00
             */

            private String silver;
            private String total;

            public String getSilver() {
                return silver;
            }

            public void setSilver(String silver) {
                this.silver = silver;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }
        }

        public static class SingleLogBean {
            /**
             * ctime : 2017-06-18
             * silver : 0.00
             * total : 120000.00
             * bean : null
             * relic : null
             * give_id : 0
             * add_time : 2017-06-18
             * singleid : 11018
             * sp_name : 江苏省无锡市南禅寺妙光街134号A景悦珠宝
             * company_name : 景悦珠宝
             * goods_img : /Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg
             * goods_id : 256
             */

            private String ctime;
            private String silver;
            private String total;
            private Object bean;
            private Object relic;
            private String give_id;
            private String add_time;
            private String singleid;
            private String sp_name;
            private String company_name;
            private String goods_img;
            private String goods_id;

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

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public Object getBean() {
                return bean;
            }

            public void setBean(Object bean) {
                this.bean = bean;
            }

            public Object getRelic() {
                return relic;
            }

            public void setRelic(Object relic) {
                this.relic = relic;
            }

            public String getGive_id() {
                return give_id;
            }

            public void setGive_id(String give_id) {
                this.give_id = give_id;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getSingleid() {
                return singleid;
            }

            public void setSingleid(String singleid) {
                this.singleid = singleid;
            }

            public String getSp_name() {
                return sp_name;
            }

            public void setSp_name(String sp_name) {
                this.sp_name = sp_name;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }
        }
    }
}
