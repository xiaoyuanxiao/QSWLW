package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;

import org.junit.Test;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * To work on unit tests, switch the BaseBean Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        ReHttpUtils.initRetro("http://192.168.1.196/qianshengapp/");
        ReHttpUtils.instans().httpRequestMain/**这是单线程  因为测试多线程 不好看结果*/(new HttpSubCribe<MainBean>() {


            private String name1;
            private String name;
            private RequestBody requestBody1;
            private RequestBody requestBody;

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
//                File file = new File("C:\\Users\\qs\\Pictures\\snapshot20170713113055.jpg");
//                File file1 = new File("C:\\Users\\qs\\Pictures\\20171226171646.png");
//                File file = null;
//                File file1 = null;
//                if(file!=null){
//                    requestBody = RequestBody.create(MediaType.parse("image/*"), file);
//                    name = file.getName();
//                }else{
//                    requestBody =  RequestBody.create(MediaType.parse("image/*"), file);
//                    name = null;
//                }
//                if(file1!=null){
//                    requestBody1 = RequestBody.create(MediaType.parse("image/*"), file1);
//                    name1 = file1.getName();
//                }else{
//                    requestBody1 = null;
//                    name1 = null;
//                }

              // RequestBody requestBody1 = RequestBody.create(MediaType.parse("image/*"), file1);
                RequestBody re = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("token", "39edbdf5f6363b870ea9c6b555dc4132")
                        .addFormDataPart("id","7")
//                        .addFormDataPart("license",null)
//                        .addFormDataPart("photo",null)
                        .addFormDataPart("shop_name","aaa")
                        .addFormDataPart("company_name","eeeeee")
                        .addFormDataPart("shop_tel","15200002145")
                        .addFormDataPart("province","10543")
                        .addFormDataPart("city","10544")
                        .addFormDataPart("district","10544")
                        .addFormDataPart("address","beijing")
                        .addFormDataPart("cat_id","8")
                        .addFormDataPart("category","lingshi")
                        .addFormDataPart("start","08:09")
                        .addFormDataPart("end","18:09")
                        .addFormDataPart("add_time","18:09")
                        .addFormDataPart("name","确定")
                        .addFormDataPart("mobile","15200000004")
                        .addFormDataPart("business_id","187")
                        .build();
                return retrofit.postImproveCommit(re);


                //("b5f317bca8d81eeda88e987b058f3ec6", 83891, new File("C:\\Users\\qs\\Pictures\\snapshot20170713113055.jpg"));
            }
        });

    }


}