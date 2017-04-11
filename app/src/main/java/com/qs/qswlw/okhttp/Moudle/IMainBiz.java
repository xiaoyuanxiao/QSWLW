package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MainAlertLisenter;
import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBenefitLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntrepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainLuckLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainBiz {


    void getAlert(MainAlertLisenter mainAlertLisenter);

    void getunion(MainUnionLisenter mainUnionLisenter);

    void getentrep(MainEntrepLisenter mainEntepLisenter);

    void getangel(MainAngelLisenter mainAngelLisenter);

    void getchina(MainChinaLisenter mainChinaLisenter);

    void getluck(MainLuckLisenter mainLuckListener);

    void getbenefit(MainBenefitLisenter mainBenefitListener);

}
