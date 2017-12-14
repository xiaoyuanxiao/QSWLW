package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.SetModifyBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.ISetModifyView;
import com.qs.qswlw.okhttp.Moudle.ISetModifyBiz;
import com.qs.qswlw.okhttp.oncallback.SetModifyListener;

/**
 * Created by xiaoyu on 2017/12/14.
 */

public class SetModifyPersenter {
    private ISetModifyBiz iSetModifyBiz;
    private ISetModifyView iSetModifyView;

    public SetModifyPersenter(ISetModifyView iSetModifyView) {
        iSetModifyBiz = IBizFactory.getSetModifyList();
        this.iSetModifyView = iSetModifyView;
    }
    public void getdata(String token,int user_id){
        iSetModifyBiz.getData(new SetModifyListener() {
            @Override
            public void onSuccess(SetModifyBean setModifyBean) {
                iSetModifyView.setData(setModifyBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,user_id);
    }
}
