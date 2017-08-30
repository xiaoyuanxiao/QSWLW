package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.PersonalSettingBean;

/**
 * Created by xiaoyu on 2017/8/30.
 */

public interface IPersonalSettingView {
    /**
     * 创业中心
     * @param list
     */
    void setUserInfo(PersonalSettingBean list);

    void runOnUiThread(Runnable runnable);

}
