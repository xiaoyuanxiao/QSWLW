package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public interface ComplimentaryMerchandiseRecordListener extends BaseOnlistener {
    void onSuccess(ComplimentaryMerchandiseRecordBean complimentaryMerchandiseRecordBean);
}
