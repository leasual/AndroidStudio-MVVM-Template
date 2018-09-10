package com.mvvm.javademo.di.component;

import com.mvvm.javademo.App;
import com.mvvm.javademo.di.module.AppModule;
import com.mvvm.javademo.di.module.BuilderModule;
import com.mvvm.javademo.di.module.NetworkModule;
import com.mvvm.javademo.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 *
 * @author james.li
 * @date 2018/8/21
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuilderModule.class,
        NetworkModule.class,
        ViewModelModule.class
        })
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App>{}
}