package com.mvvm.javademo.ui.main;

import com.mvvm.javademo.R;
import com.mvvm.javademo.base.BaseActivity;
import com.mvvm.javademo.databinding.ActivityMainBinding;

/**
 * @author rainy.liao
 */
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    public int getLayoutId(){
        return R.layout.activity_main;
    }

    @Override
    public void setupViews() {
        viewModel.getRegion();
    }

    @Override
    public void observeData() {

    }


}
