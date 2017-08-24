package com.qs.qswlw;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.mynet.TestBean;
import com.qs.qswlw.okhttp.Moudle.BaseBean;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.utils.StringUtils;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.Key;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

import static junit.framework.Assert.assertEquals;

/**
 * To work on unit tests, switch the BaseBean Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        ReHttpUtils.initRetro("http://www.qiansheng.com/");
        ReHttpUtils.instans().httpRequestMain(new HttpSubCribe<TestBean>() {

            @Override
            public void onCompleted() {
                System.out.println("onCompleted============");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError============" + e);
            }

            @Override
            public void onNext(TestBean s) {
                System.out.println("onNext============" + s);
            }

            @Override
            public Observable<TestBean> getObservable(MyRetroService retrofit) {
                return retrofit.getCommissionSummaryDaily("http://www.qiansheng.com/index.php?m=Appapi&c=Index&a=index");
            }
        });


    }


}