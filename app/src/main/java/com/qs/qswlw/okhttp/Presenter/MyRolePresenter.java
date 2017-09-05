package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MyRoleBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMyRoleView;
import com.qs.qswlw.okhttp.Moudle.IMyRoleBiz;
import com.qs.qswlw.okhttp.oncallback.MyRoleListener;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MyRolePresenter {
    IMyRoleBiz iMyRoleBiz;
    IMyRoleView iMyRoleView;

    public MyRolePresenter(IMyRoleView iMyRoleView) {
        iMyRoleBiz = IBizFactory.getMyRoleBiz();
        this.iMyRoleView = iMyRoleView;
    }
    public void getData(String token){
        iMyRoleBiz.getdata(new MyRoleListener() {
            @Override
            public void onSuccess(MyRoleBean myRoleBean) {
                iMyRoleView.setMyRoleViewList(myRoleBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token);
    }
}
