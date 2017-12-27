package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.LuckBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/10.
 */

public interface MainLuckLisenter extends BaseOnlistener {
    void onSuccess(List<LuckBean> e);
}
