package com.qs.qswlw.okhttp.Moudle;


import com.qs.qswlw.okhttp.oncallback.RecommendRecordListener;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface IRecommendRecordBiz {
    void getdata(RecommendRecordListener recommendRecordBaseListener, String token, int p, String search_name, String tab_name);
}
