package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditClickBean {

    /**
     * model : {"model1":{"get":"100","back":"0"},"model2":{"get":"20","back":"50"}}
     * old_list : {"id":"7964","user_id":"187","uid":"1","add_time":"2017-05-28","money":"132000.00","none":"20000.00","is_ok":"0","model":"model1","img":"","remittance_img":"","pay_type":"otherbankpay","pay_name":"倩茜","pay_time":"1495900800","goods_num":15}
     * user_info : {"nickname":"admin"}
     * goods_id : 259
     */

    private ModelBean model;
    private OldListBean old_list;
    private UserInfoBean user_info;
    private String goods_id;

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public OldListBean getOld_list() {
        return old_list;
    }

    public void setOld_list(OldListBean old_list) {
        this.old_list = old_list;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public static class ModelBean {
        /**
         * model1 : {"get":"100","back":"0"}
         * model2 : {"get":"20","back":"50"}
         */

        private Model1Bean model1;
        private Model2Bean model2;

        public Model1Bean getModel1() {
            return model1;
        }

        public void setModel1(Model1Bean model1) {
            this.model1 = model1;
        }

        public Model2Bean getModel2() {
            return model2;
        }

        public void setModel2(Model2Bean model2) {
            this.model2 = model2;
        }

        public static class Model1Bean {
            /**
             * get : 100
             * back : 0
             */

            private String get;
            private String back;

            public String getGet() {
                return get;
            }

            public void setGet(String get) {
                this.get = get;
            }

            public String getBack() {
                return back;
            }

            public void setBack(String back) {
                this.back = back;
            }
        }

        public static class Model2Bean {
            /**
             * get : 20
             * back : 50
             */

            private String get;
            private String back;

            public String getGet() {
                return get;
            }

            public void setGet(String get) {
                this.get = get;
            }

            public String getBack() {
                return back;
            }

            public void setBack(String back) {
                this.back = back;
            }
        }
    }

    public static class OldListBean {
        /**
         * id : 7964
         * user_id : 187
         * uid : 1
         * add_time : 2017-05-28
         * money : 132000.00
         * none : 20000.00
         * is_ok : 0
         * model : model1
         * img :
         * remittance_img :
         * pay_type : otherbankpay
         * pay_name : 倩茜
         * pay_time : 1495900800
         * goods_num : 15
         */

        private String id;
        private String user_id;
        private String uid;
        private String add_time;
        private String money;
        private String none;
        private String is_ok;
        private String model;
        private String img;
        private String remittance_img;
        private String pay_type;
        private String pay_name;
        private String pay_time;
        private int goods_num;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNone() {
            return none;
        }

        public void setNone(String none) {
            this.none = none;
        }

        public String getIs_ok() {
            return is_ok;
        }

        public void setIs_ok(String is_ok) {
            this.is_ok = is_ok;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getRemittance_img() {
            return remittance_img;
        }

        public void setRemittance_img(String remittance_img) {
            this.remittance_img = remittance_img;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public int getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(int goods_num) {
            this.goods_num = goods_num;
        }
    }

    public static class UserInfoBean {
        /**
         * nickname : admin
         */

        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
