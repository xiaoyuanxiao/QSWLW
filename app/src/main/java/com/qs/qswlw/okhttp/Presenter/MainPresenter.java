package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MainPresenter {

    IMainView iMainView;
    IMainBiz iMainBiz;
    private List<EntrepBaen> e;

    public MainPresenter(IMainView iMainView) {
        iMainBiz = IBizFactory.getMainBiz();
        this.iMainView = iMainView;
    }

    public void getdata() {
        getEntrep();
        getAlert();
        getChina();
    }

    public void getAlert() {

    }

    public void getEntrep() {
        iMainBiz.getentrep(new MainEntepLisenter() {
            @Override
            public void onSuccess(final EntrepBaen e) {
                iMainView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iMainView.setListdata2(e);
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
                        iMainView.setListdata5(e);
                    }
                });


            }

            @Override
            public void onFailure(String code) {

            }
        });
    }

}
