package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.BenefitBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.UnionBean;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MainPresenter implements MainEntepLisenter {

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
        iMainBiz.getentrep(this);
    }
    public void getChina() {
        iMainBiz.getchina(this);
    }



    @Override
    public void onFailure(String code) {

    }

    @Override
    public void onSuccess(List<EntrepBaen> e) {

    }
    @Override
    public void onSuccess1(List<ChinaBean> e) {
        // iMainView.setListdata2();
    }

    @Override
    public void onSuccess2(List<BenefitBean> e) {

    }

    @Override
    public void onSuccess3(List<UnionBean> e) {

    }

}
