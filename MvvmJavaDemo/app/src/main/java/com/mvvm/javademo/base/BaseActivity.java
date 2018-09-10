package com.mvvm.javademo.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mvvm.javademo.extension.PreferencesUtil;
import com.mvvm.javademo.vo.ViewModelTypeResolver;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by james.li on 2018/8/21.
 */

public abstract class BaseActivity<VM extends BaseViewModel, B extends ViewDataBinding> extends AppCompatActivity implements HasSupportFragmentInjector {

    protected VM viewModel;

    protected B mBinding;

    @Inject
    PreferencesUtil mPreferences;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        Class  viewModelType = ViewModelTypeResolver.findViewModelType(getClass());
        if (viewModelType != null) {
            viewModel = (VM) ViewModelProviders.of(this, viewModelFactory).get(viewModelType);
        }
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        observeData();
        setupViews();
        viewModel.isLoading.observe(this, isLoading -> {

        });
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void setupViews();

    public abstract void observeData();
}