package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.SetModifyListener;

/**
 * Created by xiaoyu on 2017/12/14.
 */

public interface ISetModifyBiz {
    void getData(SetModifyListener setModifyListener, String token, int user_id);
}
