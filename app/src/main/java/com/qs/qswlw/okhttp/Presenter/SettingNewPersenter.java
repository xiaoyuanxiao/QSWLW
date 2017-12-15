package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.SettingNewsBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.ISettingNewView;
import com.qs.qswlw.okhttp.Moudle.ISettingNewBiz;
import com.qs.qswlw.okhttp.oncallback.SettingNewListener;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public class SettingNewPersenter {
    private ISettingNewBiz iSettingNewBiz;
    private ISettingNewView iSettingNewView;

    public SettingNewPersenter(ISettingNewView iSettingNewView) {
        iSettingNewBiz = IBizFactory.getSettingNewList();
        this.iSettingNewView = iSettingNewView;
    }

    public void getData(String token,int user_id){
        iSettingNewBiz.getdata(new SettingNewListener() {

            @Override
            public void onFailure(String code) {

            }

            @Override
            public void onSuccess(SettingNewsBean settingNewsBean) {
                iSettingNewView.setdata(settingNewsBean);
            }

            @Override
            public void setTokenFail() {
                iSettingNewView.setTokenFail();

            }
        },token,user_id);

    }
}
