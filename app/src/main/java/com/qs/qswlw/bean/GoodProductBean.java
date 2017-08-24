package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public class GoodProductBean {
    List<GoodsAmonut> goods_amonut_list;
    List<GoodsNum> goods_num_list;
    List<GoodsRank> goods_rank_list;

    public List<GoodsAmonut> getGoods_amonut_list() {
        return goods_amonut_list;
    }

    public void setGoods_amonut_list(List<GoodsAmonut> goods_amonut_list) {
        this.goods_amonut_list = goods_amonut_list;
    }

    public List<GoodsRank> getGoods_rank_list() {
        return goods_rank_list;
    }

    public void setGoods_rank_list(List<GoodsRank> goods_rank_list) {
        this.goods_rank_list = goods_rank_list;
    }

    public List<GoodsNum> getGoods_num_list() {
        return goods_num_list;
    }

    public void setGoods_num_list(List<GoodsNum> goods_num_list) {
        this.goods_num_list = goods_num_list;
    }
    public class GoodsAmonut{
        String goods_name;
        String original_img;
        String shop_price;
        String sum_goods_price;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getSum_goods_price() {
            return sum_goods_price;
        }

        public void setSum_goods_price(String sum_goods_price) {
            this.sum_goods_price = sum_goods_price;
        }
    }
    public class GoodsNum{
        String goods_name;
        String goods_num;
        String original_img;
        String shop_price;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }
    }
    public class GoodsRank{
      String  goods_name;
      String  goods_rank;
      String  original_img;
      String  shop_price;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_rank() {
            return goods_rank;
        }

        public void setGoods_rank(String goods_rank) {
            this.goods_rank = goods_rank;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }
    }
}
