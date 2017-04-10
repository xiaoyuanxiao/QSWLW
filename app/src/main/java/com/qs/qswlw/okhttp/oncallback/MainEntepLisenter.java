package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.okhttp.Moudle.BenefitBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;
import com.qs.qswlw.okhttp.Moudle.UnionBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface MainEntepLisenter extends BaseOnlistener {
    void onSuccess(List<EntrepBaen> e);
    void onSuccess1(List<ChinaBean> e);
    void onSuccess2(List<BenefitBean> e);
    void onSuccess3(List<UnionBean> e);

}
