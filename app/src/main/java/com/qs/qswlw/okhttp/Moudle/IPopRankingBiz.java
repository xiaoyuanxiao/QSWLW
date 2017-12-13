package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.PopRankingListener;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public interface IPopRankingBiz {
    void getdata(PopRankingListener popRankingListener, String role, String time_slot);
}
