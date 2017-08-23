package com.qs.qswlw;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.okhttp.Moudle.BaseBean;
import com.qs.qswlw.okhttp.OKhttptUtils;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.Key;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static junit.framework.Assert.assertEquals;

/**
 * To work on unit tests, switch the BaseBean Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        addtest(new HashMap<Key, BaseBean>());
    }

    public <T> void addtest(HashMap<Key, T> a) throws IOException {
        OkHttpClient client = OKhttptUtils.getClient();
        FormBody.Builder build = new FormBody.Builder();
        build.add("index_data", "alert");
        Request request = new Request.Builder()
                .url("http://www.qiansheng.com/index.php?m=Mobile&c=AppIndex&a=index")
                .post(build.build())
                .build();
        Response execute = client.newCall(request).execute();
        String string = execute.body().string();
        Type type = new TypeToken<T>() {
        }.getType();
        T test = new Gson().fromJson(string, type);
    }
}