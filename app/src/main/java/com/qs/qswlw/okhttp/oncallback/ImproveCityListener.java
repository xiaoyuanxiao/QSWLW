package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ImproveCityBean;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface ImproveCityListener extends BaseOnlistener {
    void onSuccess(ImproveCityBean improveCityBean);
}
