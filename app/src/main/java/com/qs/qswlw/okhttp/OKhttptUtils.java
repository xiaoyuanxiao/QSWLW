package com.qs.qswlw.okhttp;

import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKhttptUtils {
	public static OkHttpClient okclient;

	public static OkHttpClient getClient() {
		if (okclient == null) {
			okclient = new OkHttpClient().newBuilder()
					.connectTimeout(10, TimeUnit.SECONDS)// 设置超时时间
					.readTimeout(10, TimeUnit.SECONDS)// 设置读取超时时间
					.writeTimeout(10, TimeUnit.SECONDS)// 设置写入超时时间
					.build();
		}
		return okclient;
	}

	public static <T> void httpget(String url, DataCallBack<T> responseHandler) {
		Request request = new Request.Builder().url(url).build();
		clientCall(responseHandler, request);
	}

	private static final <T> void clientCall(
			final DataCallBack<T> responseHandler, Request request) {
		getClient().newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				if (arg1.code() != 200) {
					responseHandler.sendMess(arg1.code(),null);
					return;
				}
				try {
					T fromJson = (T) new Gson().fromJson(arg1.body().string(),
							responseHandler.getType());
					long id = Thread.currentThread().getId();
					Log.d("=====", "Thread 回调线程-----------"+id);
					Log.d("=====", "onResponse-----------");
					responseHandler.sendMess(200,fromJson);

				} catch (Exception e) {
					responseHandler.sendMess(3000,null);
				}
			}

			@Override
			public void onFailure(Call arg0, IOException arg1) {
				responseHandler.sendMess(2000,null);
			}
		});
	}

	private final static String HTTP_MEDIATYPE = "application/json";
	private final static String HTTPUP_MEDIATYPE = "multipart/form-data";

	public static <T> void httpPost(String url, String content,
			DataCallBack<T> responseHandler) {
		RequestBody body = getRequestBody(content);
		Request request = getRequest(url, body, POST);
		clientCall(responseHandler, request);
	}

	public static <T> void httpUp(String url, String content,
			DataCallBack<T> responseHandler) {
		File file = new File(content);
		MultipartBody.Builder builder = new MultipartBody.Builder();
		// 设置类型
		builder.setType(MultipartBody.FORM);
		builder.addFormDataPart("png", file.getName(),
				RequestBody.create(null, file));
		RequestBody body = builder.build();
		Request request = getRequest(url, body, POST);
		clientCall(responseHandler, request);
	}

	public static <T> void httpPut(String url, String content,
			DataCallBack<T> responseHandler) {
		RequestBody body = getRequestBody(content);
		Request request = getRequest(url, body, PUT);
		clientCall(responseHandler, request);
	}

	public static <T> void httpdelete(String url, String content,
			DataCallBack<T> responseHandler) {
		RequestBody body = getRequestBody(content);
		Request request = getRequest(url, body, DELETE);
		clientCall(responseHandler, request);
	}

	private static final String GET = "get", DELETE = "delete", PUT = "put",
			POST = "post";

	private static Request getRequest(String url, RequestBody body,
			String method) {
		Builder mBuilder = newbuilder()
		/*
		 * .addHeader("User-Agent", userAgent) .addHeader("token", "")
		 */.url(url);
		Request request = null;
		if (method.equals(GET)) {
			request = mBuilder.build();
		} else if (method.equals(DELETE)) {
			request = mBuilder.delete(body).build();
		} else if (method.equals(POST)) {
			request = mBuilder.post(body).build();
		} else if (method.equals(PUT)) {
			request = mBuilder.put(body).build();
		}
		return request;
	}

	private static Builder newbuilder() {
		Builder builder = new Request.Builder();
		return builder;
	}

	private static RequestBody getRequestBody(String content) {
		return RequestBody.create(MediaType.parse(HTTP_MEDIATYPE), content);
	}
}
