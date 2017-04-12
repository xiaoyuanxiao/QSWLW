package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.ILoginView;
import com.qs.qswlw.okhttp.Moudle.ILoginBiz;
import com.qs.qswlw.okhttp.Moudle.LoginBean;
import com.qs.qswlw.okhttp.oncallback.LoginLisenter;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class LoginPresenter {
    ILoginView iLoginView;
    ILoginBiz iLoginBiz;
    public LoginPresenter(ILoginView iLoginView) {
        iLoginBiz = IBizFactory.getLoginBiz();
        this.iLoginView = iLoginView;
    }

  public void getLogin(String username,String password){
      iLoginBiz.getLogin(new LoginLisenter() {
          @Override
          public void onSuccess(final LoginBean e) {
              iLoginView.runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      iLoginView.setLogin(e);
                  }
              });
          }

          @Override
          public void onFailure(String code) {

          }
      },username,password);
  }
}
