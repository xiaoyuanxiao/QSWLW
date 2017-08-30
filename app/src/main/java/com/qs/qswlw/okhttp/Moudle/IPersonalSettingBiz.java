package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.PersonalSettingBaseListener;

/**
 * Created by xiaoyu on 2017/8/30.
 */

public interface IPersonalSettingBiz {
    void getAllData(PersonalSettingBaseListener personalSettingBaseListener,String token);

}
