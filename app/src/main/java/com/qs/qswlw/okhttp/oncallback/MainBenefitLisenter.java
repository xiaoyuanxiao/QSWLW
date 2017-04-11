package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.okhttp.Moudle.BenefitBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public interface MainBenefitLisenter extends BaseOnlistener {
    void onSuccess(List<BenefitBean> e);
}
