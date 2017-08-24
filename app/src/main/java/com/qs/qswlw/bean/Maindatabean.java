package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/23.
 */

public class Maindatabean {

    List<area> area_ranking;
    List<goods> goods_sale_ranking;
    List<salema> salema_ranking;
    List<shop> shop_ranking;

    public List<area> getArea_ranking() {
        return area_ranking;
    }

    public void setArea_ranking(List<area> area_ranking) {
        this.area_ranking = area_ranking;
    }

    public List<goods> getGoods_sale_ranking() {
        return goods_sale_ranking;
    }

    public void setGoods_sale_ranking(List<goods> goods_sale_ranking) {
        this.goods_sale_ranking = goods_sale_ranking;
    }

    public List<salema> getSalema_ranking() {
        return salema_ranking;
    }

    public void setSalema_ranking(List<salema> salema_ranking) {
        this.salema_ranking = salema_ranking;
    }

    public List<shop> getShop_ranking() {
        return shop_ranking;
    }

    public void setShop_ranking(List<shop> shop_ranking) {
        this.shop_ranking = shop_ranking;
    }

    public class current_sales{
        int count;
        String createtime;
        String loveval_model1_shop;
        String loveval_model1_xfz;
        String loveval_model2_shop;
        String loveval_model2_xfz;
        String model1;
        String model2;
        int money;
        double sales_amount;
        int shop;

    }

    //全联盟让利金额排行榜
   public class area{
        String province;
        String total;
        String user_id;
    }
    //中国好产品排行榜
   public class goods{
        String goods_id;
        String goods_name;
        String number;
    }
    //创业天使排行榜
    public class salema{
        String nickname;
        String none;
        String total;
    }
    //联盟商家排名榜
    public class shop{
        String sum_money;
        String user_id;
    }
}
