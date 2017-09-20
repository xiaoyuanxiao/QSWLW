package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ImproveCityListener;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface IImproveCityBiz {
    void getdata(ImproveCityListener improveCityListener, String token , int pid);
}
