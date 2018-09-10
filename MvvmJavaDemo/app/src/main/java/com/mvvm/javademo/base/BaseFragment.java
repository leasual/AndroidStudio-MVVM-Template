package com.mvvm.javademo.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mvvm.javademo.extension.PreferencesUtil;
import com.mvvm.javademo.vo.ViewModelTypeResolver;
import dagger.android.support.AndroidSupportInjection;
import kotlin.Suppress;

import javax.inject.Inject;

/**
 * Created by james.li on 2018/8/21.
 */

abstract class BaseFragment<VM extends BaseViewModel, B extends ViewDataBinding> extends Fragment {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    VM viewModel;

    B mBinding;

    @Inject
    PreferencesUtil mPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        Class viewModelType = ViewModelTypeResolver.findViewModelType(getClass());
        if (viewModelType != null) {
            viewModel = (VM)ViewModelProviders.of(this, viewModelFactory).get(viewModelType);
        }

        observeData();
        setupViews();
        return mBinding.getRoot();
    }

    @Override
    public void  onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void setupViews();

    public abstract void observeData();
}