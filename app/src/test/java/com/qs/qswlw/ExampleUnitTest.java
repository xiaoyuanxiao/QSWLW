package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;

import org.junit.Test;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * To work on unit tests, switch the BaseBean Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        ReHttpUtils.initRetro("http://192.168.1.196/");//这个无所谓 我们有一个默认的了
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
                System.out.println("onNext============" + s.getMsg());
            }

            @Override
            public Observable getObservable(MyRetroService retrofit) {
                File file = new File("C:\\Users\\qs\\Pictures\\snapshot20170713113055.jpg");
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
                RequestBody re = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("token", "b5f317bca8d81eeda88e987b058f3ec6")
                        .addFormDataPart("user_id","83891")
                        .addFormDataPart("images",file.getName(),requestBody)
                        .build();
                return retrofit.getUserAvaterData(re);


                //("b5f317bca8d81eeda88e987b058f3ec6", 83891, new File("C:\\Users\\qs\\Pictures\\snapshot20170713113055.jpg"));
            }
        });

    }


}