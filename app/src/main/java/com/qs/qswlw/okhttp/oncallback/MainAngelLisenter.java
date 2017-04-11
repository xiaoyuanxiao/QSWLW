package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.okhttp.Moudle.AngelBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public interface MainAngelLisenter extends BaseOnlistener {
    void onSuccess(List<AngelBean> e);
}
