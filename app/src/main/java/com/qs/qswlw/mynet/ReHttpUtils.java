package com.qs.qswlw.mynet;

import com.trello.rxlifecycle.LifecycleProvider;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Burning on 2017/5/27.
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 */


public class ReHttpUtils {
    private static String baseUrl = "http://www.qiansheng.com/";
    private static ReHttpUtils reHttpUtils;

    private ReHttpUtils() {
    }

    public synchronized static ReHttpUtils instans() {
        if (reHttpUtils == null)
            reHttpUtils = new ReHttpUtils();
        return reHttpUtils;
    }

    public static void initRetro(String baseUrl) {
        ReHttpUtils.baseUrl = baseUrl;
    }

    public Retrofit creatRetrofit(String baseUrl, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public OkHttpClient getMyclient(Interceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return client;
    }

    public Subscription httpRequestMain(HttpSubCribe frext) {
        Retrofit retrofit = creatRetrofit(ReHttpUtils.baseUrl, getMyclient(FactoryInterceptor.getCYTDinterc()));
        return frext.getObservable(retrofit.create(MyRetroService.class)).subscribe(frext);
    }

    public Subscription httpRequestLife(LifecycleProvider lifecycleProvider, HttpSubCribe frext) {
        Retrofit retrofit = creatRetrofit(ReHttpUtils.baseUrl, getMyclient(FactoryInterceptor.getCYTDinterc()));
        return frext.getObservable(retrofit.create(MyRetroService.class))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifecycleProvider.bindToLifecycle())
                .subscribe(frext);
    }

    public Subscription httpRequest(HttpSubCribe frext) {
        Retrofit retrofit = creatRetrofit(ReHttpUtils.baseUrl, getMyclient(FactoryInterceptor.getCYTDinterc()));
        return frext.getObservable(retrofit.create(MyRetroService.class))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(frext);
    }

   /* Class<MyRetroService> service = MyRetroService.class;
    private <T> T create(Retrofit retrofit, Class<T> service) {
        T t = service.newInstance();
        return retrofit.create(service);
    }*/
}
