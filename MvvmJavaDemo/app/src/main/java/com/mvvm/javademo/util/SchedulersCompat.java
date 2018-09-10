package com.mvvm.javademo.util;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.widget.Toast;

import com.mvvm.javademo.R;

import java.io.IOException;
import java.net.ConnectException;

import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by james.li on 2018/5/28.
 */

public class SchedulersCompat {

    private static final ObservableTransformer computationTransformer =
            upstream -> upstream.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread());

    private static final ObservableTransformer ioTransformer =
            upstream -> upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

    private static final ObservableTransformer newTransformer =
            upstream -> upstream.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());

    private static final ObservableTransformer trampolineTransformer =
            upstream -> upstream.subscribeOn(Schedulers.trampoline())
            .observeOn(AndroidSchedulers.mainThread());

    private static final FlowableTransformer fioTransformer =
            upstream -> upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());


    /**
     * Don't break the chain: use RxJava's compose() operator
     */
    public static <T> ObservableTransformer<T, T> applyComputationSchedulers() {
        return (ObservableTransformer<T, T>) computationTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyIoSchedulers() {

        return (ObservableTransformer<T, T>) ioTransformer;
    }
    public static <T> FlowableTransformer<T, T> applyFIoSchedulers() {

        return (FlowableTransformer<T, T>) fioTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyNewSchedulers() {

        return (ObservableTransformer<T, T>) newTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyTrampolineSchedulers() {

        return (ObservableTransformer<T, T>) trampolineTransformer;
    }

   /* public static <T> ObservableTransformer<T, T> showDialog(Context context) {
        return upstream -> upstream
                .doOnSubscribe(disposable -> MyProgress.show("", context))
                .doFinally(MyProgress::dismiss);
    }*/

    public static <T> ObservableTransformer<T, T> withErrorHandle(Context context, OnNetworkErrorListener listener) {
        return upstream -> upstream
               .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext((Function<Throwable, ObservableSource<? extends T>>) throwable -> {
                    if (throwable instanceof ConnectException || throwable instanceof HttpException|| throwable instanceof IOException ||
                            throwable instanceof NetworkErrorException) {
                        ToastUtil.show(context, context.getResources().getString(R.string.network_error_toast_tips), Toast.LENGTH_SHORT);
                        if (listener != null) {
                            listener.networkError();
                        }
                        return Observable.empty();
                    } else {
                        return Observable.error(throwable);
                    }
                });
    }

    public static <T> ObservableTransformer<T, T> withErrorHandleNoTips(Context context, OnNetworkErrorListener listener) {
        return upstream -> upstream
                .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext((Function<Throwable, ObservableSource<? extends T>>) throwable -> {
                    if (throwable instanceof ConnectException || throwable instanceof HttpException|| throwable instanceof IOException ||
                            throwable instanceof NetworkErrorException) {
                        if (listener != null) {
                            listener.networkError();
                        }
                        return Observable.empty();
                    } else {
                        return Observable.error(throwable);
                    }
                });
    }

    public static <T> ObservableTransformer<T, T> showDialogWithErrorHandle(Context context, OnNetworkErrorListener listener) {
        return upstream -> upstream
                .doOnSubscribe(disposable ->{}
//                        MyProgress.show("", context, false)
                )
//                .doFinally(MyProgress::dismiss)
                .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext((Function<Throwable, ObservableSource<? extends T>>) throwable -> {
                    if (throwable instanceof ConnectException || throwable instanceof HttpException|| throwable instanceof IOException ||
                            throwable instanceof NetworkErrorException) {
                        ToastUtil.show(context, context.getResources().getString(R.string.network_error_toast_tips), Toast.LENGTH_SHORT);
                        if (listener != null) {
                            listener.networkError();
                        }
                        return Observable.empty();
                    } else {
                        return Observable.error(throwable);
                    }
                });
    }

    public static <T> ObservableTransformer<T, T> showDialogWithErrorHandleNoTips(Context context, OnNetworkErrorListener listener) {
        return upstream -> upstream
                .doOnSubscribe(
                        disposable -> {}
//                                MyProgress.show("", context, false)
                )
//                .doFinally(MyProgress::dismiss)
                .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext((Function<Throwable, ObservableSource<? extends T>>) throwable -> {
                    if (throwable instanceof ConnectException || throwable instanceof HttpException|| throwable instanceof IOException ||
                            throwable instanceof NetworkErrorException) {
                        if (listener != null) {
                            listener.networkError();
                        }
                        return Observable.empty();
                    } else {
                        return Observable.error(throwable);
                    }
                });
    }

    public interface OnNetworkErrorListener {
        void networkError();
    }
}
