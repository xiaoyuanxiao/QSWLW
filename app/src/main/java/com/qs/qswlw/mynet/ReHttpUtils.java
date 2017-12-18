package com.qs.qswlw.mynet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.qs.qswlw.bean.WithdrawalsBean;
import com.trello.rxlifecycle.LifecycleProvider;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

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
   // private static String baseUrl = "http://www.qiansheng.com/";
    private static String baseUrl = "http://192.168.1.196/";
    private static ReHttpUtils reHttpUtils;

    private ReHttpUtils() {
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public synchronized static ReHttpUtils instans() {
        if (reHttpUtils == null)
            reHttpUtils = new ReHttpUtils();
        return reHttpUtils;
    }

    /**
     * 也可以这里全局重新指定
     *
     * @param baseUrl
     */
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

    private Gson test() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // newgsonBuilder.s
        gsonBuilder.registerTypeAdapter(WithdrawalsBean.CheckBean.class, new CheckBeanAdapter());
        return gsonBuilder.create();
    }

    public OkHttpClient getMyclient(Interceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
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

    class CheckBeanAdapter implements JsonDeserializer<WithdrawalsBean.CheckBean> {

        @Override
        public WithdrawalsBean.CheckBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            WithdrawalsBean.CheckBean check = null;
            if (json.isJsonObject()) {
                check = new WithdrawalsBean.CheckBean();
                JsonObject asJsonObject = json.getAsJsonObject();
                JsonElement fail_num1 = asJsonObject.get("fail_num");
                String fail_num = fail_num1.getAsString();
                check.setFail_num(fail_num);
            }
            return check;
        }
    }

   /* Class<MyRetroService> service = MyRetroService.class;
    private <T> T create(Retrofit retrofit, Class<T> service) {
        T t = service.newInstance();
        return retrofit.create(service);
    }*/
}
