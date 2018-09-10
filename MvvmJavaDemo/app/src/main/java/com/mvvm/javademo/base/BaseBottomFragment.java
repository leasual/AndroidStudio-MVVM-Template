package com.mvvm.javademo.base;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.mvvm.javademo.R;

/**
 * Created by james.li on 2018/8/21.
 */
public abstract class BaseBottomFragment<T extends ViewDataBinding> extends DialogFragment {
    T mBinding;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.CustomBottomDialogFragment);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(getLayoutId());
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        setupViews();
        return mBinding.getRoot();
    }

    @LayoutRes
    abstract int getLayoutId();

    abstract void setupViews();
}