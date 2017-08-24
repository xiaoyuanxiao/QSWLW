package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public interface MainBaseListener extends BaseOnlistener {
    void onSuccess(MainBean<Maindatabean> list);
}
