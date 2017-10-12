package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ImproveDocumentationBean;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface ImproveDocumentationListener extends BaseOnlistener {
    void onSuccess(ImproveDocumentationBean improveDocumentationBean);
    void onTokenFail();
}
