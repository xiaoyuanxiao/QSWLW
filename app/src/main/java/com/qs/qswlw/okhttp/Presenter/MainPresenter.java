package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MainPresenter implements MainEntepLisenter {

    IMainView iMainView;
    IMainBiz iMainBiz;

    public MainPresenter(IMainView iMainView) {
        iMainBiz = IBizFactory.getMainBiz();
        this.iMainView = iMainView;
    }

    public void getdata() {
        getEntrep();
        getAlert();
    }

    public void getAlert() {

    }

    public void getEntrep() {
        iMainBiz.getentrep(this);
    }


    @Override
    public void onSuccess(EntrepBaen e) {

//        iMainView.setListdata2();
    }

    @Override
    public void onFailure(String code) {

    }
}
