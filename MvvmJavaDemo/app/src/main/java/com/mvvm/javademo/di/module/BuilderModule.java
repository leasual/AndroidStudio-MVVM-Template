package com.mvvm.javademo.di.module;

import com.mvvm.javademo.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by james.li on 2018/8/21.
 */
@Module
public abstract class BuilderModule {

    // support fragment injection
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}