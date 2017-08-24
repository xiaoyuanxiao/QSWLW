package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MainAlertLisenter;
import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBaseListener;
import com.qs.qswlw.okhttp.oncallback.MainBenefitLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntrepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainLuckLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainBiz {

    void getALLdata(MainBaseListener mainBaseListener);

    void getAlert(MainAlertLisenter mainAlertLisenter);
}
