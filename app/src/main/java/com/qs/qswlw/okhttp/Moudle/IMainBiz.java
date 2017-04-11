package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainBiz {


    void getAlert();

    void getunion(MainUnionLisenter mainUnionLisenter);

    void getentrep(MainEntepLisenter mainEntepLisenter);

    void getangel(MainAngelLisenter mainAngelLisenter);

    void getchina(MainChinaLisenter mainChinaLisenter);

    void getluck();

    void getbenefit();

}
