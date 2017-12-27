package com.qs.qswlw.bean;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class ResultBenefitBean<T> {
    private T benefit;

    public T getBenefit() {
        return benefit;
    }

    public void setBenefit(T benefit) {
        this.benefit = benefit;
    }
}
