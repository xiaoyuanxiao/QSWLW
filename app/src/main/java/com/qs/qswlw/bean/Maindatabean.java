package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/23.
 */

public class Maindatabean {

    List<Area> area_ranking;
    List<Goods> goods_sale_ranking;
    List<Salema> salema_ranking;
    List<Shop> shop_ranking;
    Current_sales current_sales;

    public Current_sales getCurrent_sales() {
        return current_sales;
    }

    public void setCurrent_sales(Current_sales current_sales) {
        this.current_sales = current_sales;
    }

    public List<Area> getArea_ranking() {
        return area_ranking;
    }

    public void setArea_ranking(List<Area> area_ranking) {
        this.area_ranking = area_ranking;
    }

    public List<Goods> getGoods_sale_ranking() {
        return goods_sale_ranking;
    }

    public void setGoods_sale_ranking(List<Goods> goods_sale_ranking) {
        this.goods_sale_ranking = goods_sale_ranking;
    }

    public List<Salema> getSalema_ranking() {
        return salema_ranking;
    }

    public void setSalema_ranking(List<Salema> salema_ranking) {
        this.salema_ranking = salema_ranking;
    }

    public List<Shop> getShop_ranking() {
        return shop_ranking;
    }

    public void setShop_ranking(List<Shop> shop_ranking) {
        this.shop_ranking = shop_ranking;
    }

    public class Current_sales{
        int count;
        String createtime;
        String loveval_model1_shop;
        String loveval_model1_xfz;
        String loveval_model2_shop;
        String loveval_model2_xfz;
        String model1;
        String model2;
        int money;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getLoveval_model1_shop() {
            return loveval_model1_shop;
        }

        public void setLoveval_model1_shop(String loveval_model1_shop) {
            this.loveval_model1_shop = loveval_model1_shop;
        }

        public String getLoveval_model1_xfz() {
            return loveval_model1_xfz;
        }

        public void setLoveval_model1_xfz(String loveval_model1_xfz) {
            this.loveval_model1_xfz = loveval_model1_xfz;
        }

        public String getLoveval_model2_shop() {
            return loveval_model2_shop;
        }

        public void setLoveval_model2_shop(String loveval_model2_shop) {
            this.loveval_model2_shop = loveval_model2_shop;
        }

        public String getLoveval_model2_xfz() {
            return loveval_model2_xfz;
        }

        public void setLoveval_model2_xfz(String loveval_model2_xfz) {
            this.loveval_model2_xfz = loveval_model2_xfz;
        }

        public String getModel1() {
            return model1;
        }

        public void setModel1(String model1) {
            this.model1 = model1;
        }

        public String getModel2() {
            return model2;
        }

        public void setModel2(String model2) {
            this.model2 = model2;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public double getSales_amount() {
            return sales_amount;
        }

        public void setSales_amount(double sales_amount) {
            this.sales_amount = sales_amount;
        }

        public int getShop() {
            return shop;
        }

        public void setShop(int shop) {
            this.shop = shop;
        }

        double sales_amount;
        int shop;

    }

    //全联盟让利金额排行榜
   public class Area{
        String province;
        String total;
        String user_id;
        String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
    //中国好产品排行榜
   public class Goods{
        String goods_id;
        String goods_name;
        String number;

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }
    }
    //创业天使排行榜
    public class Salema{
        String nickname;
        String none;
        String total;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
    //联盟商家排名榜
    public class Shop{
        String sum_money;
        String user_id;
        String store_name;

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSum_money() {
            return sum_money;
        }

        public void setSum_money(String sum_money) {
            this.sum_money = sum_money;
        }
    }
}
