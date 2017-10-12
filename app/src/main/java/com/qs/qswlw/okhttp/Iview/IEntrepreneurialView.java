package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public interface IEntrepreneurialView {
    void setEntrepreneurialData(EntrepreneurialIncentiveBean entrepreneurialData);
    void runOnUiThread(Runnable runnable);
    void isgetDataFaile(String meg);
    void setTokenFail();
}
