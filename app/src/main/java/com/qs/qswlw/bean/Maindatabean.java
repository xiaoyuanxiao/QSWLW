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
    Notices notice;

    public Notices getNotice() {
        return notice;
    }

    public void setNotice(Notices notice) {
        this.notice = notice;
    }

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

    public class Notices{
        String index_content;
        String index_faburen;
        String index_name;
        String index_time;
        String index_title;

        public String getIndex_content() {
            return index_content;
        }

        public void setIndex_content(String index_content) {
            this.index_content = index_content;
        }

        public String getIndex_faburen() {
            return index_faburen;
        }

        public void setIndex_faburen(String index_faburen) {
            this.index_faburen = index_faburen;
        }

        public String getIndex_name() {
            return index_name;
        }

        public void setIndex_name(String index_name) {
            this.index_name = index_name;
        }

        public String getIndex_time() {
            return index_time;
        }

        public void setIndex_time(String index_time) {
            this.index_time = index_time;
        }

        public String getIndex_title() {
            return index_title;
        }

        public void setIndex_title(String index_title) {
            this.index_title = index_title;
        }
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
        float money;
        double sales_amount;
        int shop;
        String Interaction;
        String witness_url;
        String products;
        String ella;
        String winqs;//赢在钱盛
        String qs_shop;//钱盛商城
        String qs_union;//钱盛联盟
        String qs_fun;
        String qs_lack_draw;
        String qs_ziying_shop;
        String qs_comment;
        String qs_tegong;
        String qs_xianfu;
        String qs_chongzhi;
        String qs_spgl;

        public String getQs_spgl() {
            return qs_spgl;
        }

        public void setQs_spgl(String qs_spgl) {
            this.qs_spgl = qs_spgl;
        }

        public String getQs_tegong() {
            return qs_tegong;
        }

        public void setQs_tegong(String qs_tegong) {
            this.qs_tegong = qs_tegong;
        }

        public String getQs_xianfu() {
            return qs_xianfu;
        }

        public void setQs_xianfu(String qs_xianfu) {
            this.qs_xianfu = qs_xianfu;
        }

        public String getQs_chongzhi() {
            return qs_chongzhi;
        }

        public void setQs_chongzhi(String qs_chongzhi) {
            this.qs_chongzhi = qs_chongzhi;
        }

        public String getQs_comment() {
            return qs_comment;
        }

        public void setQs_comment(String qs_comment) {
            this.qs_comment = qs_comment;
        }

        public String getQs_ziying_shop() {
            return qs_ziying_shop;
        }

        public void setQs_ziying_shop(String qs_ziying_shop) {
            this.qs_ziying_shop = qs_ziying_shop;
        }

        public String getQs_union() {
            return qs_union;
        }

        public void setQs_union(String qs_union) {
            this.qs_union = qs_union;
        }

        public String getWinqs() {
            return winqs;
        }

        public void setWinqs(String winqs) {
            this.winqs = winqs;
        }

        public String getQs_shop() {
            return qs_shop;
        }

        public void setQs_shop(String qs_shop) {
            this.qs_shop = qs_shop;
        }

        public String getQs_fun() {
            return qs_fun;
        }

        public void setQs_fun(String qs_fun) {
            this.qs_fun = qs_fun;
        }

        public String getQs_lack_draw() {
            return qs_lack_draw;
        }

        public void setQs_lack_draw(String qs_lack_draw) {
            this.qs_lack_draw = qs_lack_draw;
        }

        public String getElla() {
            return ella;
        }

        public void setElla(String ella) {
            this.ella = ella;
        }

        public String getProducts() {
            return products;
        }

        public void setProducts(String products) {
            this.products = products;
        }

        public String getWitness_url() {
            return witness_url;
        }

        public void setWitness_url(String witness_url) {
            this.witness_url = witness_url;
        }

        public String getInteraction() {
            return Interaction;
        }

        public void setInteraction(String interaction) {
            Interaction = interaction;
        }

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

        public float getMoney() {
            return money;
        }

        public void setMoney(float money) {
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
