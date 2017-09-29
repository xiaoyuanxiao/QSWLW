package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.PersonalSettingBean;

/**
 * Created by xiaoyu on 2017/8/30.
 */

public interface PersonalSettingBaseListener extends BaseOnlistener {
    void OnSucess(MainBean<PersonalSettingBean> list);

    void onTokenFail();
}
