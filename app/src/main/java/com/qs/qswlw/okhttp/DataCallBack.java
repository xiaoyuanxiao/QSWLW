package com.qs.qswlw.okhttp;

import java.lang.reflect.Type;

import android.os.Handler;

import com.google.gson.reflect.TypeToken;

public abstract class DataCallBack<T> {
	TypeToken<T> typeToken;
	Handler hander;
	public DataCallBack(TypeToken<T> typeToken) {
		hander=new Handler();
		this.typeToken = typeToken;
	}
	public void sendMess(final int code,final T data){
		if(code != 200)
			hander.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					onFailure(code);
				}
			});
			
		else
			hander.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					onSuccess(data);
				}
			});
			
	}
	public abstract void onSuccess(T data);

	public abstract void onFailure(int code);

	public Type getType() {
		return typeToken.getType();
	}
}
