package com.mvvm.javademo.di.module;

import com.mvvm.javademo.App;
import com.mvvm.javademo.extension.PreferencesUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author james.li
 * @date 2018/8/21
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public PreferencesUtil provideSharedPreferences(App app) {
        return new PreferencesUtil(app);
    }
}