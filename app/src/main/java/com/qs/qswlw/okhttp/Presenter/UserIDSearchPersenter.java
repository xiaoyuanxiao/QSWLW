package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.UserIDSearchBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IUserIDSearchView;
import com.qs.qswlw.okhttp.Moudle.IUserIDSearchBiz;
import com.qs.qswlw.okhttp.oncallback.UserIDSearchListener;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class UserIDSearchPersenter {
    private IUserIDSearchBiz iUserIDSearchBiz;
    private IUserIDSearchView iUserIDSearchView;

    public UserIDSearchPersenter(IUserIDSearchView iUserIDSearchView) {
        iUserIDSearchBiz = IBizFactory.getUserIDSearchList();
        this.iUserIDSearchView = iUserIDSearchView;
    }
    public void getdata(String token,int uid,int user_id){
        iUserIDSearchBiz.getdata(new UserIDSearchListener() {
            @Override
            public void onSuccess(UserIDSearchBean userIDSearchBean) {
                iUserIDSearchView.setdata(userIDSearchBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,uid,user_id);

    }
}
