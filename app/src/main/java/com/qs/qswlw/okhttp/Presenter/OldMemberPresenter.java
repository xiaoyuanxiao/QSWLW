package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.OldMemberBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IOldMemberView;
import com.qs.qswlw.okhttp.Moudle.IOldMemberBiz;
import com.qs.qswlw.okhttp.oncallback.OldMemberListener;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class OldMemberPresenter {
    IOldMemberBiz iOldMemberBiz;
    IOldMemberView iOldMemberView;

    public OldMemberPresenter(IOldMemberView iOldMemberView) {
        iOldMemberBiz = IBizFactory.getOldMemberBiz();
        this.iOldMemberView = iOldMemberView;
    }

    public void getData(String token,String member_number,String member_type){
        iOldMemberBiz.getdata(new OldMemberListener() {
            @Override
            public void success(OldMemberBean oldMemberBean) {
                iOldMemberView.setOldMemberViewData(oldMemberBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,member_number,member_type);
    }
}
