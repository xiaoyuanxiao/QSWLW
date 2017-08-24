package com.qs.qswlw.mynet;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Burning on 2017/5/27.
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 */


public abstract class HttpSubCribe<T> extends Subscriber<T> {
    public abstract Observable<T> getObservable(MyRetroService retrofit);

    @Override
    public void onCompleted() {
    }
}
