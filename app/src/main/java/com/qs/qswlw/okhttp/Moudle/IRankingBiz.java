package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.RankingBaseListener;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public interface IRankingBiz {
    void getdata(RankingBaseListener rankingBaseListener, int code);
}
