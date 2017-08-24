package com.qs.qswlw.okhttp.oncallback;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public interface MainBaseListener<T> extends BaseOnlistener {
    void onSuccess(List<T> list);

    void onSuccess(T list);
}
