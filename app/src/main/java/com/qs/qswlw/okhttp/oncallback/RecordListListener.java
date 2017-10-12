package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.RecordListBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public interface RecordListListener extends BaseOnlistener {
    void onSuccess(List<RecordListBean> list);
    void onTokenFail();
}
