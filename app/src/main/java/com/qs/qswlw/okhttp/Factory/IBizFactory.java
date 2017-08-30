package com.qs.qswlw.okhttp.Factory;

import com.qs.qswlw.okhttp.Moudle.BizAngelRanking;
import com.qs.qswlw.okhttp.Moudle.BizGoodProduct;
import com.qs.qswlw.okhttp.Moudle.BizLogin;
import com.qs.qswlw.okhttp.Moudle.BizMain;
import com.qs.qswlw.okhttp.Moudle.BizPersonalSetting;
import com.qs.qswlw.okhttp.Moudle.BizRanking;
import com.qs.qswlw.okhttp.Moudle.IAngelRankingBiz;
import com.qs.qswlw.okhttp.Moudle.ILoginBiz;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.IPersonalSettingBiz;
import com.qs.qswlw.okhttp.Moudle.IProductBiz;
import com.qs.qswlw.okhttp.Moudle.IRankingBiz;
import com.qs.qswlw.okhttp.Moudle.ITestaBiz;
import com.qs.qswlw.okhttp.Moudle.TestaMoudle;

/**
 * Created by 小猴子 on 2017/4/7.
 * <p>
 * <p>
 * 注
 * <p>
 * 所有I开头的JAVA文件皆是接口
 */

public class IBizFactory {
    public static ITestaBiz getItestBiz() {
        return TestaMoudle.getInstans();
    }

    public static IMainBiz getMainBiz() {
        return BizMain.getInstans();
    }
    public static ILoginBiz getLoginBiz() {
        return BizLogin.getInstans();
    }
    public static IProductBiz getProductBiz() {
        return BizGoodProduct.getInstans();
    }
    public static IRankingBiz getRankingBiz() {
        return BizRanking.getInstans();
    }
    public static IAngelRankingBiz getAngelRankingBiz() {
        return BizAngelRanking.getInstans();
    }
    public static IPersonalSettingBiz getPersonalSettingBiz() {
        return BizPersonalSetting.getInstans();
    }

}
