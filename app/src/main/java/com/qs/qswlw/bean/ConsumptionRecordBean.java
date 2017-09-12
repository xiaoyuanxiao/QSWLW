package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public class ConsumptionRecordBean {

    /**
     * main_sn : null
     * check_old_user : 187
     * content : 户名：广州市四申九物联网有限公司。
     * rebate_config : {"model1":{"get":"100","back":"0"},"model2":{"get":"20","back":"50"}}
     */

    private String main_sn;
    private String check_old_user;
    private String content;
    private RebateConfigBean rebate_config;

    public String getMain_sn() {
        return main_sn;
    }

    public void setMain_sn(String main_sn) {
        this.main_sn = main_sn;
    }

    public String getCheck_old_user() {
        return check_old_user;
    }

    public void setCheck_old_user(String check_old_user) {
        this.check_old_user = check_old_user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public RebateConfigBean getRebate_config() {
        return rebate_config;
    }

    public void setRebate_config(RebateConfigBean rebate_config) {
        this.rebate_config = rebate_config;
    }

    public static class RebateConfigBean {
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
}
