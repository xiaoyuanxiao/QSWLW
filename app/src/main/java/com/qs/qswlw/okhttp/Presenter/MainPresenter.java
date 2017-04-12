package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.AlertBean;
import com.qs.qswlw.okhttp.Moudle.AngelBean;
import com.qs.qswlw.okhttp.Moudle.BenefitBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBean;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.Moudle.UnionBean;
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
        getAlert();
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

    public void getUnion() {
        iMainBiz.getunion(new MainUnionLisenter() {
            @Override
            public void onSuccess(final List<UnionBean> e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       iMainView.setUnionList(e);
                    }
                });
            }

            @Override
            public void onFailure(String code) {

            }
        });
    }

    public void getEntrep() {
        iMainBiz.getentrep(new MainEntrepLisenter() {
            @Override
            public void onSuccess(final EntrepBean e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setEntrepList(e);
                    }
                });

            }

            @Override
            public void onFailure(String code) {


            }
        });
    }

    public void getChina() {
        iMainBiz.getchina(new MainChinaLisenter() {
            @Override
            public void onSuccess(final List<ChinaBean> e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setChinaList(e);
                    }
                });


            }

            @Override
            public void onFailure(String code) {

            }
        });
    }


    public void getAngel() {
        iMainBiz.getangel(new MainAngelLisenter() {
            @Override
            public void onSuccess(final List<AngelBean> e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setAngelList(e);
                    }
                });
            }

            @Override
            public void onFailure(String code) {

            }
        });
    }

    public void getLuck() {
      iMainBiz.getluck(new MainLuckLisenter(){
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

    public void getBenefit() {
        iMainBiz.getbenefit(new MainBenefitLisenter(){
            @Override
            public void onSuccess(final List<BenefitBean> e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setBenefitList(e);
                    }
                });
            }

            @Override
            public void onFailure(String code) {

            }

        });
    }
}
