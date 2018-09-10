package com.mvvm.javademo.vo;

import android.util.Log;

import com.mvvm.javademo.App;
import com.mvvm.javademo.api.APIException;
import com.mvvm.javademo.model.BaseResponse;
import com.mvvm.javademo.util.SchedulersCompat;
import com.mvvm.javademo.util.ToastUtil;
import com.mvvm.javademo.util.Utils;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import retrofit2.HttpException;

/**
 * Created by james on 2018/8/22.
 */

public abstract class NetworkBoundResource<ResultType, RequestType> {
    private App app;

    public NetworkBoundResource(App app) {
        this.app = app;
        init();
    }

    private FlowableOnSubscribe<ResultType> flowableOnSubscribe;

    public void init() {
        //whether should fetch from network
        boolean networkState = Utils.isNetworkAvailable(app.getApplicationContext());
//        @Suppress("LeakingThis")
        if (networkState) {
            if (shouldLoadFromCache()) {
                flowableOnSubscribe = emitter -> {
                    ResultType cacheData = loadFromDB();
                    emitter.onNext(cacheData);
                    if (shouldFetch(cacheData)) {
                        fetchFromNetwork(emitter);
                    }
                };
            } else {
                flowableOnSubscribe = emitter -> {
                    fetchFromNetwork(emitter);
                };
            }
        } else {
            if (shouldLoadFromCache()) {
                flowableOnSubscribe = emitter -> {
                    emitter.onNext(loadFromDB());
                };
            } else {
                flowableOnSubscribe = emitter -> {
                    emitter.onComplete();
                };
            }
            ToastUtil.show(app.getApplicationContext(), "网络未连接，请检查网络再重试");
        }
    }

    private void fetchFromNetwork(FlowableEmitter<ResultType> emitter) {
        callApi().flatMap(BaseResponse::filterData)
//                .retryWhen(new RetryWithDelay(3))
                .compose(SchedulersCompat.applyFIoSchedulers())
                .subscribe(
                        responseData -> {
                            emitter.onNext((((BaseResponse<ResultType>)responseData).getData()));
                            Log.d("test", "get data from network");
                        },
                        throwable -> {
                            if (throwable instanceof HttpException) {
                                if (((HttpException) throwable).response().code() == 404) {
                                    ToastUtil.show(app.getApplicationContext(), "服务器地址不存在");
                                } else {
                                    ToastUtil.show(app.getApplicationContext(), "网络不给力，请重试");
                                }
                            } else if (throwable instanceof APIException) {
                                ToastUtil.show(app.getApplicationContext(), ((APIException) throwable).getInfo());
                            } else {
                                ToastUtil.show(app.getApplicationContext(), "数据异常，请重试");
                            }
                            emitter.onError(throwable);
                        },
                        () -> {
                            emitter.onComplete();
                        }
                );
    }

    protected abstract boolean shouldFetch(ResultType data);

    protected abstract boolean shouldLoadFromCache();

    protected abstract ResultType loadFromDB();

    protected abstract void cache(ResultType data);

    protected abstract Flowable<BaseResponse<ResultType>> callApi();
//    protected abstract Flowable<RequestType> callApi();

    public Flowable<ResultType> asFlowable() {
        return Flowable.create(flowableOnSubscribe,BackpressureStrategy.LATEST)
                .compose(SchedulersCompat.applyFIoSchedulers());
    }
}