package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.SettingNewListener;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public interface ISettingNewBiz {
    void getdata(SettingNewListener settingNewListener, String token, int user_id);
}
