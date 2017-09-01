package com.qs.qswlw.okhttp.Presenter;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IPersonalSettingView;
import com.qs.qswlw.okhttp.Moudle.IPersonalSettingBiz;
import com.qs.qswlw.okhttp.oncallback.PersonalSettingBaseListener;

/**
 * Created by xiaoyu on 2017/8/30.
 */

/**
 * 负责逻辑处理
 */
public class PersonalSettingPresenter {
    IPersonalSettingView iPersonalSettingView;
    IPersonalSettingBiz iPersonalSettingBiz;

    public PersonalSettingPresenter(IPersonalSettingView iPersonalSettingView) {
        iPersonalSettingBiz = IBizFactory.getPersonalSettingBiz();
        this.iPersonalSettingView = iPersonalSettingView;
    }

    public void getData(String token){
        iPersonalSettingBiz.getAllData(new PersonalSettingBaseListener() {
            @Override
            public void OnSucess(MainBean<PersonalSettingBean> list) {
                Log.e("====", "PersonalSettingBaseListener=========================="+list);
                PersonalSettingBean result = list.getResult();

                /**
                 * View负责显示
                 */
                iPersonalSettingView.setUserInfo(result);
            }

            @Override
            public void onFailure(String code) {

                Log.e("PersonalSettingBaseListener",code);
            }
        },token);
    }
}
