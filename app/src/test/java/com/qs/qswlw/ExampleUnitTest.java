package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;

import org.junit.Test;

import rx.Observable;

/**
 * To work on unit tests, switch the BaseBean Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        ReHttpUtils.initRetro("http://192.168.1.193/");//这个无所谓 我们有一个默认的了
        ReHttpUtils.instans().httpRequestMain/**这是单线程  因为测试多线程 不好看结果*/(new HttpSubCribe<MainBean>() {


            @Override
            public void onCompleted() {
                System.out.println("onCompleted============");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError============" + e);
            }

            @Override
            public void onNext(MainBean s) {
                System.out.println("onNext============" + s);
            }

            @Override
            public Observable getObservable(MyRetroService retrofit) {
                return retrofit.getUserNameData("aa",187,"model2");
            }
        });

    }


}