package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.SettingNewsBean;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public interface SettingNewListener extends BaseOnlistener {
    void onSuccess(SettingNewsBean settingNewsBean);
    void setTokenFail();
}
