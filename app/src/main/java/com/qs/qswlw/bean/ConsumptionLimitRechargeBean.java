package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitRechargeBean {
    /**
     * goods_num : [{"original_img":"/Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg","goods_id":"256"},{"original_img":"/Public/upload/goods/2017/07-20/59700e7546ede.jpg","goods_id":"273"},{"original_img":"/Public/upload/goods/2017/07-19/596f1110082f2.jpg","goods_id":"257"}]
     * recharge_type : taxgold
     */

    private String recharge_type;
    private List<GoodsNumBean> goods_num;

    public String getRecharge_type() {
        return recharge_type;
    }

    public void setRecharge_type(String recharge_type) {
        this.recharge_type = recharge_type;
    }

    public List<GoodsNumBean> getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(List<GoodsNumBean> goods_num) {
        this.goods_num = goods_num;
    }

    public static class GoodsNumBean {
        /**
         * original_img : /Public/upload/goods/2017/07-19/596f0ef5da3e1.jpg
         * goods_id : 256
         */

        private String original_img;
        private String goods_id;

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }
    }
}
