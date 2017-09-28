package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class ComplimentaryMerchandiseRecordBean {
    private List<GoodsInfoBean> goodsInfo;

    public List<GoodsInfoBean> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<GoodsInfoBean> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public static class GoodsInfoBean {
        /**
         * id : 71
         * add_time : 1503392363
         * review_time : 1503452058
         * top_time : null
         * shop_id : 187
         * shop_name : 津津食品
         * goods_id : 276
         * goods_name : 钱盛雪碧
         * is_review : 1
         * sales_sum : 8
         */

        private String id;
        private String add_time;
        private String review_time;
        private Object top_time;
        private String shop_id;
        private String shop_name;
        private String goods_id;
        private String goods_name;
        private String is_review;
        private String sales_sum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public Object getTop_time() {
            return top_time;
        }

        public void setTop_time(Object top_time) {
            this.top_time = top_time;
        }

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getIs_review() {
            return is_review;
        }

        public void setIs_review(String is_review) {
            this.is_review = is_review;
        }

        public String getSales_sum() {
            return sales_sum;
        }

        public void setSales_sum(String sales_sum) {
            this.sales_sum = sales_sum;
        }
    }
}
