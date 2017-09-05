package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ValidateOldMemberBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IValidateOldMemberView;
import com.qs.qswlw.okhttp.Moudle.IValidateOldMemberBiz;
import com.qs.qswlw.okhttp.oncallback.ValidateOldMemberListener;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class ValidateOldMemberPresenter {
    IValidateOldMemberBiz iValidateOldMemberBiz;
    IValidateOldMemberView iValidateOldMemberView;

    public ValidateOldMemberPresenter(IValidateOldMemberView iValidateOldMemberView) {
        iValidateOldMemberBiz = IBizFactory.getValidateOldMemberBiz();
        this.iValidateOldMemberView = iValidateOldMemberView;
    }

    public void getData(String token){
        iValidateOldMemberBiz.getdata(new ValidateOldMemberListener() {
            @Override
            public void success(ValidateOldMemberBean validateOldMemberBean) {
                iValidateOldMemberView.setValidateOldMemberViewData(validateOldMemberBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token);
    }
}
