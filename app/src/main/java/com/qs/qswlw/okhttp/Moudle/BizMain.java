package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.NetUrl;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.okhttp.oncallback.MainAlertLisenter;
import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBaseListener;
import com.qs.qswlw.okhttp.oncallback.MainBenefitLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntrepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainLuckLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class BizMain implements IMainBiz {
    private static BizMain testMoudle;

    private BizMain() {
    }

    public synchronized static BizMain getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMain();
        return testMoudle;
    }


    private final String index_data = "index_data";
    private final String alert = "alert";
    private final String union = "union";
    private final String entrep = "entrep";
    private final String angel = "angel";
    private final String china = "china";
    private final String luck = "luck";
    private final String benefit = "benefit";
    private Maindatabean result;

    private void getALLdata(final MainBaseListener baseOnlistener) {
        Type type = new TypeToken<MainBean<Maindatabean>>() {
        }.getType();
        OKhttptUtils.httpget(NetUrl.MAINURL,
                new DataCallBack<MainBean<Maindatabean>>(type) {
                    @Override
                    public void onSuccess(MainBean<Maindatabean> data) {
                        result = data.getResult();
                        if (baseOnlistener instanceof MainUnionLisenter) {
                            //联盟商家
                            baseOnlistener.onSuccess(result.getShop_ranking());
                        } else if (baseOnlistener instanceof MainAngelLisenter) {
                            //创业天使
                            baseOnlistener.onSuccess(result.getSalema_ranking());
                        } else if (baseOnlistener instanceof MainChinaLisenter) {
                            //中国好产品
                            baseOnlistener.onSuccess(result.getGoods_sale_ranking());
                        } else if (baseOnlistener instanceof MainBenefitLisenter) {
                            //全联盟让利金额
                            baseOnlistener.onSuccess(result.getArea_ranking());
                        } else if (baseOnlistener instanceof MainEntrepLisenter) {
                            //全联盟创业日值
                            baseOnlistener.onSuccess(result.getCurrent_sales());
                        }
                    }

                    @Override
                    public void onFailure(int code) {
                        baseOnlistener.onFailure(code + "");
                        /*mainAlertLisenter.onFailure("错误信息" + code);*/
                    }
                });
    }

    //这是弹框,doushuole，这是dialog
    @Override
    public void getAlert(final MainAlertLisenter mainAlertLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, alert);//
        Type type = new TypeToken<BaseBean<ResultAlertBean<AlertBean>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultAlertBean<AlertBean>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultAlertBean<AlertBean>> data) {
                        AlertBean result = null;
                        try {
                            result = data.getResult().getAlert();

                        } catch (Exception e) {

                        }
                        if (result == null)
                            mainAlertLisenter.onFailure("错误信息");
                        else
                            mainAlertLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainAlertLisenter.onFailure("错误信息" + code);
                    }
                });

    }

    @Override
    public void getunion(MainUnionLisenter mainUnionLisenter) {
        if (result != null && result.getShop_ranking() != null) {
            mainUnionLisenter.onSuccess(result.getShop_ranking());
            return;
        }
        getALLdata(mainUnionLisenter);
    }

    @Override
    public void getentrep(final MainEntrepLisenter mainEntepLisenter) {
        if (result != null && result.getCurrent_sales() != null) {
            mainEntepLisenter.onSuccess(result.getCurrent_sales());
            return;
        }
        getALLdata(mainEntepLisenter);
    }

    @Override
    public void getangel(final MainAngelLisenter mainAngelLisenter) {
        if (result != null && result.getSalema_ranking() != null) {
            mainAngelLisenter.onSuccess(result.getSalema_ranking());
            return;
        }
        getALLdata(mainAngelLisenter);
    }


    @Override
    public void getchina(final MainChinaLisenter mainChinaLisenter) {
        if (result != null && result.getGoods_sale_ranking() != null) {
            mainChinaLisenter.onSuccess(result.getGoods_sale_ranking());
            return;
        }
        getALLdata(mainChinaLisenter);
    }

    @Override
    public void getluck(final MainLuckLisenter mainLuckLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, luck);
        Type type = new TypeToken<BaseBean<ResultChinaBean<ArrayList<LuckBean>>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultChinaBean<ArrayList<LuckBean>>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultChinaBean<ArrayList<LuckBean>>> data) {
                        List<LuckBean> result = null;
                        try {
                            result = data.getResult().getChina();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainLuckLisenter.onFailure("错误信息");
                        else
                            mainLuckLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainLuckLisenter.onFailure("错误信息" + code);
                    }
                });
    }

    @Override
    public void getbenefit(final MainBenefitLisenter mainBenefitLisenter) {
        if (result != null && result.getArea_ranking() != null) {
            mainBenefitLisenter.onSuccess(result.getArea_ranking());
            return;
        }
        getALLdata(mainBenefitLisenter);
    }
}
