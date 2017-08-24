package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.AlertBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBean;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.oncallback.MainAlertLisenter;
import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBenefitLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntrepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainLuckLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MainPresenter {

    IMainView iMainView;
    IMainBiz iMainBiz;
    private List<EntrepBean> e;

    public MainPresenter(IMainView iMainView) {
        iMainBiz = IBizFactory.getMainBiz();
        this.iMainView = iMainView;
    }

    public void getdata() {
      //  getAlert();
        getUnion();
        getEntrep();
        getChina();
        getAngel();
        getLuck();
        getBenefit();
    }

    public void getAlert() {
        iMainBiz.getAlert(new MainAlertLisenter() {
            @Override
            public void onSuccess(final AlertBean e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setAlertList(e);
                    }
                });
            }

            @Override
            public void onFailure(String code) {

            }
        });
    }
//联盟商家排行榜
    public void getUnion() {
        iMainBiz.getunion(new MainUnionLisenter() {
            @Override
            public void onSuccess(final List<Maindatabean.Shop> list) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setUnionList(list);
                    }
                });

            }
        });
    }
    //全联盟创业日值
    public void getEntrep() {
        iMainBiz.getentrep(new MainEntrepLisenter() {


            @Override
            public void onSuccess(final Maindatabean.Current_sales list) {

                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setEntrepList(list);
                    }
                });
            }
        });
    }
    //中国好产品排行榜
    public void getChina() {
        iMainBiz.getchina(new MainChinaLisenter() {

            @Override
            public void onSuccess(final List<Maindatabean.Goods> list) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setChinaList(list);
                    }
                });
            }
        });

    }

    //创业天使创业排名榜
    public void getAngel() {
        iMainBiz.getangel(new MainAngelLisenter() {


            @Override
            public void onSuccess(final List<Maindatabean.Salema> list) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setAngelList(list);
                    }
                });
            }
        });
    }

    public void getLuck() {
        iMainBiz.getluck(new MainLuckLisenter() {
            @Override
            public void onSuccess(final List<LuckBean> e) {

                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setLuckList(e);
                    }
                });
            }

            @Override
            public void onFailure(String code) {

            }
        });
    }

    //全联盟让利金额排名榜
    public void getBenefit() {
        iMainBiz.getbenefit(new MainBenefitLisenter() {


            @Override
            public void onSuccess(final List<Maindatabean.Area> list) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setBenefitList(list);
                    }
                });
            }
        });
    }
}
