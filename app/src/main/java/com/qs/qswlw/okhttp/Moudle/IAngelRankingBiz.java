package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.AngelRankingBaseListener;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public interface IAngelRankingBiz {
    void getdata(AngelRankingBaseListener angelRankingBaseListener, int code);
}
