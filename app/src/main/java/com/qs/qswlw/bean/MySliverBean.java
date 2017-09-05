package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MySliverBean {





    /**
     * silver_count : {"silver":"338294.00","total":"704780.00"}
     * single_log : [{"add_time":"2017-05-21","company_name":"安琪儿婴","ctime":"2017-05-21","give_id":"0","goods_id":"256","goods_img":"/Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg","silver":"210182.00","singleid":"7496","sp_name":"安琪儿婴童装","total":"437880.00"},{"add_time":"2017-05-09","company_name":"安琪儿婴","ctime":"2017-05-09","give_id":"0","goods_id":"273","goods_img":"/Public/upload/goods/2017/07-20/59700e7546ede.jpg","silver":"56400.00","singleid":"2612","sp_name":"安琪儿婴童装","total":"117500.00"},{"add_time":"2017-05-02","company_name":"安琪儿婴","ctime":"2017-05-07","give_id":"0","goods_id":"257","goods_img":"/Public/upload/goods/2017/07-19/596f1110082f2.jpg","silver":"14304.00","singleid":"377","sp_name":"安琪儿婴童装","total":"29800.00"},{"add_time":"2017-04-29","company_name":"安琪儿婴","ctime":"2017-04-29","give_id":"0","goods_id":"236","goods_img":"/Public/upload/goods/2017-07-01/595743409c55a.jpg","silver":"17280.00","singleid":"255","sp_name":"安琪儿婴童装","total":"36000.00"},{"add_time":"2017-04-25","company_name":"安琪儿婴","ctime":"2017-04-28","give_id":"0","goods_id":"440","goods_img":"/Public/upload/goods/2017-08-21/599a757d31e30.jpg","silver":"13104.00","singleid":"200","sp_name":"安琪儿婴童装","total":"27300.00"},{"add_time":"2017-04-24","company_name":"安琪儿婴","ctime":"2017-04-24","give_id":"0","goods_id":"276","goods_img":"/Public/upload/goods/2017-07-20/59704f4f76530.PNG","silver":"12624.00","singleid":"158","sp_name":"安琪儿婴童装","total":"26300.00"},{"add_time":"2017-04-14","company_name":"安琪儿婴","ctime":"2017-04-14","give_id":"0","goods_id":"226","goods_img":"/Public/upload/goods/2017-06-24/594e6880aa3ef.jpg","silver":"14400.00","singleid":"93","sp_name":"安琪儿婴童装","total":"30000.00"}]
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
         * silver : 338294.00
         * total : 704780.00
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
         * add_time : 2017-05-21
         * company_name : 安琪儿婴
         * ctime : 2017-05-21
         * give_id : 0
         * goods_id : 256
         * goods_img : /Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg
         * silver : 210182.00
         * singleid : 7496
         * sp_name : 安琪儿婴童装
         * total : 437880.00
         */

        private String add_time;
        private String company_name;
        private String ctime;
        private String give_id;
        private String goods_id;
        private String goods_img;
        private String silver;
        private String singleid;
        private String sp_name;
        private String total;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getGive_id() {
            return give_id;
        }

        public void setGive_id(String give_id) {
            this.give_id = give_id;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getSilver() {
            return silver;
        }

        public void setSilver(String silver) {
            this.silver = silver;
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

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}
