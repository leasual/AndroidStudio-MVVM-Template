package com.mvvm.javademo.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by james.li on 2018/8/21.
 */

@Documented
@Retention(RUNTIME)
@Scope
public @interface PerActivity {}