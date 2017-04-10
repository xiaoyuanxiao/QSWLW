package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MainBebeLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainBiz {


    void getAlert();

    void getunion(MainUnionLisenter mainEntepLisenter);

    void getentrep(MainEntepLisenter mainEntepLisenter);

    void getangel(MainBebeLisenter mainEntepLisenter);

    void getchina(MainChinaLisenter mainEntepLisenter);

    void getluck();

    void getbenefit();

}
