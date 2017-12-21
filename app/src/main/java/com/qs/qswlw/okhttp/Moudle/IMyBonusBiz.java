package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MyBonusListener;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public interface IMyBonusBiz {
    void getdata(MyBonusListener myBonusListener, String token, int user_id, String bonus_type);
}
