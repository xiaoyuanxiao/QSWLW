package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.NoticesBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/12.
 */

public interface NoticesListener extends BaseOnlistener {
    void onSuccess(List<NoticesBean> noticesBeanList);
}
