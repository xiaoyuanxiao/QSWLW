package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ComplimentaryMerchandiseRecordListener;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public interface IComplimentaryMerchandiseRecordBiz {
    void getdata(ComplimentaryMerchandiseRecordListener complimentaryMerchandiseRecordListener, String token, int p, int is_review);
}
