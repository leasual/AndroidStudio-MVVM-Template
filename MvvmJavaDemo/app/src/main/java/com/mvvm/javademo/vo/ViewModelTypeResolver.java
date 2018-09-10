package com.mvvm.javademo.vo;

import android.util.Log;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by james.li on 2018/8/31.
 */

public class ViewModelTypeResolver {

    public static <T> Class<T> findViewModelType(Class<?> cls) {
        ParameterizedType parameterizedType = null;
        if (cls.getGenericSuperclass() instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
        }
        if (parameterizedType == null) {
            return null;
        }
        Type[] types = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < types.length; i++) {
            if ( types[i] instanceof Class<?> && types[i] != Object.class
                    && Object.class.isAssignableFrom((Class)types[i])) {
                Log.d("test", "class= " + ((Class<T>) types[i]).getSimpleName());
                return (Class<T>) types[i];
            }
        }
        return null;
    }
}
