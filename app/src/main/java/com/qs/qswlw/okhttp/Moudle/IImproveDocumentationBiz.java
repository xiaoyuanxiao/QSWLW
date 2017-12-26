package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ImproveDocumentationListener;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface IImproveDocumentationBiz {
    void getdata(ImproveDocumentationListener improveDocumentationListener, String token,int id);
}
