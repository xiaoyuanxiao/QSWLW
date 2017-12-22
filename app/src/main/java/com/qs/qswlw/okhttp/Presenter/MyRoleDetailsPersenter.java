package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MyRoleDatailBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IRoleDetailsView;
import com.qs.qswlw.okhttp.Moudle.IMyRoleDetailBiz;
import com.qs.qswlw.okhttp.oncallback.MyRoleDetailListener;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class MyRoleDetailsPersenter {
    private IMyRoleDetailBiz iMyRoleDetailBiz;
    private IRoleDetailsView iRoleDetailsView;

    public MyRoleDetailsPersenter(IRoleDetailsView iRoleDetailsView) {
        iMyRoleDetailBiz  = IBizFactory.getMyRoleDetailList();
        this.iRoleDetailsView = iRoleDetailsView;
    }

    public void getdata(String a,String token,int user_id){
        iMyRoleDetailBiz.getdata(new MyRoleDetailListener() {
            @Override
            public void onSuccess(MyRoleDatailBean myRoleDatailBean) {
                iRoleDetailsView.setdata(myRoleDatailBean);
            }

            @Override
            public void onTokenFail() {
                iRoleDetailsView.setTokenFail();
            }

            @Override
            public void onFailure(String code) {


            }
        },a,token,user_id);

    }

}
