package com.mvvm.javademo.base;

import com.mvvm.javademo.api.APIService;

import javax.inject.Inject;

/**
 *
 * @author james
 * @date 2018/8/21
 */

public abstract class BaseRepository {

    @Inject
    public APIService apiService;

}