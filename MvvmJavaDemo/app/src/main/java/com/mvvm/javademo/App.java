package com.mvvm.javademo;

import android.app.Activity;
import android.app.Application;

import com.mvvm.javademo.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by james.li on 2018/8/21.
 */
public class App extends Application implements HasActivityInjector {

    public static App instance;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DaggerAppComponent.builder().create(this).inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}