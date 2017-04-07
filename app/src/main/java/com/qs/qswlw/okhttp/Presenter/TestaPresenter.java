package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.ITestaView;
import com.qs.qswlw.okhttp.Moudle.ITestaBiz;
import com.qs.qswlw.okhttp.Moudle.TestaMoudle;

/**
 * Created by 小猴子 on 2017/4/7.
 */

public class TestaPresenter {
    //此类只在相应的View 即 Activity 中存在  此对应在 Testa 为名称的TestaActivity


    private ITestaView testaViewIntfasce;

    private ITestaBiz iTestaBiz;


    public TestaPresenter(ITestaView testaViewIntfasce) {
        this.testaViewIntfasce = testaViewIntfasce;
        this.iTestaBiz = IBizFactory.getItestBiz();
    }


    public void login() {
        iTestaBiz.login(testaViewIntfasce.getMobile(), testaViewIntfasce.getPassword(), new TestaMoudle.
                OnLoginListener() {
            @Override
            public void onSucces(final String msg) {

                testaViewIntfasce.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        testaViewIntfasce.setText1(msg);
                    }
                });
            }

            @Override
            public void onFail() {
                testaViewIntfasce.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        testaViewIntfasce.setText1("出现错误");
                    }
                });
            }
        });

    }


}


