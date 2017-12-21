package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMyBonusView;
import com.qs.qswlw.okhttp.Moudle.IMyBonusBiz;
import com.qs.qswlw.okhttp.oncallback.MyBonusListener;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyBonusPersenter {
    private IMyBonusBiz iMyBonusBiz;
    private IMyBonusView iMyBonusView;

    public MyBonusPersenter(IMyBonusView iMyBonusView) {
        iMyBonusBiz = IBizFactory.getMyBonusList();
        this.iMyBonusView = iMyBonusView;
    }

    public void getdata(String token,int user_id,String bonus_type) {
        iMyBonusBiz.getdata(new MyBonusListener() {
            @Override
            public void OnSuccess(MyBonusBean myBonusBean) {
                iMyBonusView.setdata(myBonusBean);
            }

            @Override
            public void onTokenFail() {
                iMyBonusView.setOnTokenFile();
            }

            @Override
            public void onFailure(String code) {

            }
        },token,user_id,bonus_type);
    }
}
