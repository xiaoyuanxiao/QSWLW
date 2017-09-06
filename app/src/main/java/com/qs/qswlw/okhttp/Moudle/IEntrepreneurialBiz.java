package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.EntrepreneurialListener;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public interface IEntrepreneurialBiz {
    void getEntrepreneurialData(EntrepreneurialListener entrepreneuriaListener, String token, int p, String model);
}
