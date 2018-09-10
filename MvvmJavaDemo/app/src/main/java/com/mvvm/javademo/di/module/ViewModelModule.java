package com.mvvm.javademo.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mvvm.javademo.di.DaggerViewModelFactory;
import com.mvvm.javademo.di.ViewModelKey;
import com.mvvm.javademo.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 *
 * @author james.li
 * @date 2018/8/21
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindsMainViewModel(MainViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);
}