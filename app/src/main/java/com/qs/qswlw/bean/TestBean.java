package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by burning on 2017/8/24.
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * -------------------------//┏┓　　　┏┓
 * -------------------------//┏┛┻━━━┛┻┓
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　━　　　┃
 * -------------------------//┃　┳┛　┗┳　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　┻　　　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┗━┓　　　┏━┛
 * -------------------------//┃　　　┃  神兽保佑
 * -------------------------//┃　　　┃  代码无BUG！
 * -------------------------//┃　　　┗━━━┓
 * -------------------------//┃　　　　　　　┣┓
 * -------------------------//┃　　　　　　　┏┛
 * -------------------------//┗┓┓┏━┳┓┏┛
 * -------------------------// ┃┫┫　┃┫┫
 * -------------------------// ┗┻┛　┗┻┛
 */

public class TestBean {

    /**
     * status : 1
     * succ : 1
     * msg : 成功！
     * result : {"shop_ranking":[{"user_id":"8895","store_name":null,"sum_money":"11039330.00"},{"user_id":"3709","store_name":"常熟市古里镇恒洁卫浴经营部","sum_money":"10750544.00"},{"user_id":"4926","store_name":"金勺山茶油","sum_money":"9827740.00"},{"user_id":"2558","store_name":"格莱美陶瓷","sum_money":"8469120.00"},{"user_id":"7046","store_name":"方圆老酒店","sum_money":"7440352.00"},{"user_id":"3509","store_name":"养生保健咨询","sum_money":"6838000.00"}],"salema_ranking":[{"nickname":"凯迪威","none":"877984.80","total":"4389924.00"},{"nickname":"纪杰","none":"586798.40","total":"2925992.00"},{"nickname":"许金丽","none":"553429.75","total":"2767206.75"},{"nickname":"凌金华","none":"508223.21","total":"2541116.05"},{"nickname":"吴静雯","none":"398513.60","total":"1996388.80"},{"nickname":"褚敬东","none":"380507.00","total":"1902535.00"}],"goods_sale_ranking":[{"number":"101","goods_id":"24","goods_name":"北欧布艺沙发大小户型三人组合简约现代家具日式可拆洗转角布沙发"},{"number":"87","goods_id":"23","goods_name":"办公沙发 西皮三人位沙发茶几组合 现代简约商务办公室会客沙发"},{"number":"83","goods_id":"7","goods_name":"52度剑南春浓香型白酒500ml*6瓶 原箱酒厂直供 "},{"number":"74","goods_id":"9","goods_name":"52度锦上添花醇品级500ml六瓶白酒整箱"},{"number":"62","goods_id":"10","goods_name":"后视镜导航行车记录仪带电子狗前后双镜头高清夜视倒车影像一体机"},{"number":"52","goods_id":"2","goods_name":"化妆品 诺曼姿弹力紧致三件套 清爽控油补水滋润面部化妆品套装女"}],"area_ranking":[{"total":"460115895.53","user_id":"198","city":null,"province":"江苏省"},{"total":"36304417.83","user_id":"2001","city":"镇江市","province":"江苏省"},{"total":"24407900.20","user_id":"1788","city":"扬州市","province":"江苏省"},{"total":"18608118.61","user_id":"1734","city":"苏州市","province":"江苏省"},{"total":"9347858.40","user_id":"187","city":"市辖区","province":"上海"},{"total":"7383621.00","user_id":"2657","city":"无锡市","province":"江苏省"}],"current_sales":{"model1":"1157003.20","model2":"0.00","loveval_model1_xfz":"0.000","loveval_model1_shop":"1.887","loveval_model2_xfz":"1.450","loveval_model2_shop":"1.887","createtime":"2017-08-23","sales_amount":1157003.2,"count":36525,"shop":16261,"money":1809935415}}
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
         * shop_ranking : [{"user_id":"8895","store_name":null,"sum_money":"11039330.00"},{"user_id":"3709","store_name":"常熟市古里镇恒洁卫浴经营部","sum_money":"10750544.00"},{"user_id":"4926","store_name":"金勺山茶油","sum_money":"9827740.00"},{"user_id":"2558","store_name":"格莱美陶瓷","sum_money":"8469120.00"},{"user_id":"7046","store_name":"方圆老酒店","sum_money":"7440352.00"},{"user_id":"3509","store_name":"养生保健咨询","sum_money":"6838000.00"}]
         * salema_ranking : [{"nickname":"凯迪威","none":"877984.80","total":"4389924.00"},{"nickname":"纪杰","none":"586798.40","total":"2925992.00"},{"nickname":"许金丽","none":"553429.75","total":"2767206.75"},{"nickname":"凌金华","none":"508223.21","total":"2541116.05"},{"nickname":"吴静雯","none":"398513.60","total":"1996388.80"},{"nickname":"褚敬东","none":"380507.00","total":"1902535.00"}]
         * goods_sale_ranking : [{"number":"101","goods_id":"24","goods_name":"北欧布艺沙发大小户型三人组合简约现代家具日式可拆洗转角布沙发"},{"number":"87","goods_id":"23","goods_name":"办公沙发 西皮三人位沙发茶几组合 现代简约商务办公室会客沙发"},{"number":"83","goods_id":"7","goods_name":"52度剑南春浓香型白酒500ml*6瓶 原箱酒厂直供 "},{"number":"74","goods_id":"9","goods_name":"52度锦上添花醇品级500ml六瓶白酒整箱"},{"number":"62","goods_id":"10","goods_name":"后视镜导航行车记录仪带电子狗前后双镜头高清夜视倒车影像一体机"},{"number":"52","goods_id":"2","goods_name":"化妆品 诺曼姿弹力紧致三件套 清爽控油补水滋润面部化妆品套装女"}]
         * area_ranking : [{"total":"460115895.53","user_id":"198","city":null,"province":"江苏省"},{"total":"36304417.83","user_id":"2001","city":"镇江市","province":"江苏省"},{"total":"24407900.20","user_id":"1788","city":"扬州市","province":"江苏省"},{"total":"18608118.61","user_id":"1734","city":"苏州市","province":"江苏省"},{"total":"9347858.40","user_id":"187","city":"市辖区","province":"上海"},{"total":"7383621.00","user_id":"2657","city":"无锡市","province":"江苏省"}]
         * current_sales : {"model1":"1157003.20","model2":"0.00","loveval_model1_xfz":"0.000","loveval_model1_shop":"1.887","loveval_model2_xfz":"1.450","loveval_model2_shop":"1.887","createtime":"2017-08-23","sales_amount":1157003.2,"count":36525,"shop":16261,"money":1809935415}
         */

        private CurrentSalesBean current_sales;
        private List<ShopRankingBean> shop_ranking;
        private List<SalemaRankingBean> salema_ranking;
        private List<GoodsSaleRankingBean> goods_sale_ranking;
        private List<AreaRankingBean> area_ranking;

        public CurrentSalesBean getCurrent_sales() {
            return current_sales;
        }

        public void setCurrent_sales(CurrentSalesBean current_sales) {
            this.current_sales = current_sales;
        }

        public List<ShopRankingBean> getShop_ranking() {
            return shop_ranking;
        }

        public void setShop_ranking(List<ShopRankingBean> shop_ranking) {
            this.shop_ranking = shop_ranking;
        }

        public List<SalemaRankingBean> getSalema_ranking() {
            return salema_ranking;
        }

        public void setSalema_ranking(List<SalemaRankingBean> salema_ranking) {
            this.salema_ranking = salema_ranking;
        }

        public List<GoodsSaleRankingBean> getGoods_sale_ranking() {
            return goods_sale_ranking;
        }

        public void setGoods_sale_ranking(List<GoodsSaleRankingBean> goods_sale_ranking) {
            this.goods_sale_ranking = goods_sale_ranking;
        }

        public List<AreaRankingBean> getArea_ranking() {
            return area_ranking;
        }

        public void setArea_ranking(List<AreaRankingBean> area_ranking) {
            this.area_ranking = area_ranking;
        }

        public static class CurrentSalesBean {
            /**
             * model1 : 1157003.20
             * model2 : 0.00
             * loveval_model1_xfz : 0.000
             * loveval_model1_shop : 1.887
             * loveval_model2_xfz : 1.450
             * loveval_model2_shop : 1.887
             * createtime : 2017-08-23
             * sales_amount : 1157003.2
             * count : 36525
             * shop : 16261
             * money : 1809935415
             */

            private String model1;
            private String model2;
            private String loveval_model1_xfz;
            private String loveval_model1_shop;
            private String loveval_model2_xfz;
            private String loveval_model2_shop;
            private String createtime;
            private double sales_amount;
            private int count;
            private int shop;
            private int money;

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

            public String getLoveval_model1_xfz() {
                return loveval_model1_xfz;
            }

            public void setLoveval_model1_xfz(String loveval_model1_xfz) {
                this.loveval_model1_xfz = loveval_model1_xfz;
            }

            public String getLoveval_model1_shop() {
                return loveval_model1_shop;
            }

            public void setLoveval_model1_shop(String loveval_model1_shop) {
                this.loveval_model1_shop = loveval_model1_shop;
            }

            public String getLoveval_model2_xfz() {
                return loveval_model2_xfz;
            }

            public void setLoveval_model2_xfz(String loveval_model2_xfz) {
                this.loveval_model2_xfz = loveval_model2_xfz;
            }

            public String getLoveval_model2_shop() {
                return loveval_model2_shop;
            }

            public void setLoveval_model2_shop(String loveval_model2_shop) {
                this.loveval_model2_shop = loveval_model2_shop;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public double getSales_amount() {
                return sales_amount;
            }

            public void setSales_amount(double sales_amount) {
                this.sales_amount = sales_amount;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getShop() {
                return shop;
            }

            public void setShop(int shop) {
                this.shop = shop;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }
        }

        public static class ShopRankingBean {
            /**
             * user_id : 8895
             * store_name : null
             * sum_money : 11039330.00
             */

            private String user_id;
            private Object store_name;
            private String sum_money;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public Object getStore_name() {
                return store_name;
            }

            public void setStore_name(Object store_name) {
                this.store_name = store_name;
            }

            public String getSum_money() {
                return sum_money;
            }

            public void setSum_money(String sum_money) {
                this.sum_money = sum_money;
            }
        }

        public static class SalemaRankingBean {
            /**
             * nickname : 凯迪威
             * none : 877984.80
             * total : 4389924.00
             */

            private String nickname;
            private String none;
            private String total;

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

        public static class GoodsSaleRankingBean {
            /**
             * number : 101
             * goods_id : 24
             * goods_name : 北欧布艺沙发大小户型三人组合简约现代家具日式可拆洗转角布沙发
             */

            private String number;
            private String goods_id;
            private String goods_name;

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
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
        }

        public static class AreaRankingBean {
            /**
             * total : 460115895.53
             * user_id : 198
             * city : null
             * province : 江苏省
             */

            private String total;
            private String user_id;
            private Object city;
            private String province;

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

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }
    }
}
