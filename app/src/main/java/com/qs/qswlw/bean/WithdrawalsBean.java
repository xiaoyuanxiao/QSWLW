package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public class WithdrawalsBean {

    /**
     * user_count : 8200.00
     * user_count_two : 600.00
     * rawals_count : 542.00
     * rawals_count_two : 61.00
     * total_count_cash : 9403
     * check : {"fail_num":"15"}
     * with : 1000
     * high : 1000
     * with2 : 1000
     * high2 : 1000
     * beishu : 100
     * content : 提现请
     * bank : {"id":"5672","user_id":"187","cardxy":"中国工商银行","number":"621475368741556867"}
     * user : {"gold":"46.000","gold2":"103978.450","taxgold":"370.000","taxgold2":"1770.050"}
     */

    private String user_count;
    private String user_count_two;
    private String rawals_count;
    private String rawals_count_two;
    private int total_count_cash;
    private List<CheckBean> check;
    private String with;
    private String high;
    private String with2;
    private String high2;
    private String beishu;
    private String content;
    private BankBean bank;
    private UserBean user;

    public String getUser_count() {
        return user_count;
    }

    public void setUser_count(String user_count) {
        this.user_count = user_count;
    }

    public String getUser_count_two() {
        return user_count_two;
    }

    public void setUser_count_two(String user_count_two) {
        this.user_count_two = user_count_two;
    }

    public String getRawals_count() {
        return rawals_count;
    }

    public void setRawals_count(String rawals_count) {
        this.rawals_count = rawals_count;
    }

    public String getRawals_count_two() {
        return rawals_count_two;
    }

    public void setRawals_count_two(String rawals_count_two) {
        this.rawals_count_two = rawals_count_two;
    }

    public int getTotal_count_cash() {
        return total_count_cash;
    }

    public void setTotal_count_cash(int total_count_cash) {
        this.total_count_cash = total_count_cash;
    }

    public List<CheckBean> getCheck() {
        return check;
    }

    public void setCheck(List<CheckBean> check) {
        this.check = check;
    }

    public String getWith() {
        return with;
    }

    public void setWith(String with) {
        this.with = with;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getWith2() {
        return with2;
    }

    public void setWith2(String with2) {
        this.with2 = with2;
    }

    public String getHigh2() {
        return high2;
    }

    public void setHigh2(String high2) {
        this.high2 = high2;
    }

    public String getBeishu() {
        return beishu;
    }

    public void setBeishu(String beishu) {
        this.beishu = beishu;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BankBean getBank() {
        return bank;
    }

    public void setBank(BankBean bank) {
        this.bank = bank;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class CheckBean {

        /**
         * fail_num : 15
         */

        private String fail_num;

        public String getFail_num() {
            return fail_num;
        }

        public void setFail_num(String fail_num) {
            this.fail_num = fail_num;
        }
    }

    public static class BankBean {
        /**
         * id : 5672
         * user_id : 187
         * cardxy : 中国工商银行
         * number : 621475368741556867
         */

        private String id;
        private String user_id;
        private String cardxy;
        private String number;

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

        public String getCardxy() {
            return cardxy;
        }

        public void setCardxy(String cardxy) {
            this.cardxy = cardxy;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    public static class UserBean {
        /**
         * gold : 46.000
         * gold2 : 103978.450
         * taxgold : 370.000
         * taxgold2 : 1770.050
         */

        private String gold;
        private String gold2;
        private String taxgold;
        private String taxgold2;

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getGold2() {
            return gold2;
        }

        public void setGold2(String gold2) {
            this.gold2 = gold2;
        }

        public String getTaxgold() {
            return taxgold;
        }

        public void setTaxgold(String taxgold) {
            this.taxgold = taxgold;
        }

        public String getTaxgold2() {
            return taxgold2;
        }

        public void setTaxgold2(String taxgold2) {
            this.taxgold2 = taxgold2;
        }
    }
}
