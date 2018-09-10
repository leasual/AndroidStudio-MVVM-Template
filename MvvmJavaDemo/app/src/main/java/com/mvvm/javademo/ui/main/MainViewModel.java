package com.mvvm.javademo.ui.main;

import android.util.Log;

import com.mvvm.javademo.base.BaseViewModel;
import com.mvvm.javademo.model.RequestHelper;
import com.mvvm.javademo.repository.main.MainRepository;

import javax.inject.Inject;

/**
 *
 * @author james.li
 * @date 2018/8/21
 */

public class MainViewModel extends BaseViewModel<MainRepository> {
    private static final String TAG = "MainViewModel";
    @Inject
    public MainViewModel() {
    }

    public void getRegion() {
        repository.getSupportRegion(RequestHelper.getSupportedRegion())
                .subscribe(
                        data -> {
                            Log.d(TAG, "data= " + data.getRegion().size());
                        },
                        error -> {
                            Log.e(TAG, "getRegion: error= " + error.getMessage());
                        }
                );
    }
}