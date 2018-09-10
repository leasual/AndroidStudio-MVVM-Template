package com.mvvm.javademo.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.mvvm.javademo.api.APIException;

import io.reactivex.Flowable;

/**
 *
 * @author rainy.liao
 * @date 2018/8/30
 */

public class BaseResponse<T> {
    @SerializedName("result_code")
    private int code;
    @SerializedName("result_data")
    private T data;
    @SerializedName("result_des")
    private String message;

    public Flowable<BaseResponse<T>> filterData() {
        Log.d("test", "code= $code");
         if (code == 1) {
             return  Flowable.just(this);
        } else {
             return Flowable.error(new APIException(message, code));
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
