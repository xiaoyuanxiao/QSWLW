package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.MyBankListBean;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface IMyBankListView {
    void setdata(MyBankListBean myBankListBean);
    void isgetDataFaile(String meg);
}
