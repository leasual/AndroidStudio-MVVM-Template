package com.mvvm.javademo.base;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 *
 * @author james
 * @date 2018/8/21
 */

public abstract class BaseViewModel<R extends BaseRepository> extends ViewModel {

    CompositeDisposable dispose = new CompositeDisposable();

    MediatorLiveData<Boolean> isLoading = new MediatorLiveData<Boolean>();

    @Inject
    protected R repository;


    @Override
    public void onCleared() {
        super.onCleared();
        if (!dispose.isDisposed()) {
            dispose.dispose();
            dispose.clear();
        }
    }
}