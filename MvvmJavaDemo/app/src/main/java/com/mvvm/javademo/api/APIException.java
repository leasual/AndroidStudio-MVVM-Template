package com.mvvm.javademo.api;

/**
 *
 * @author james
 * @date 2018/8/24
 */
public class APIException extends Exception {
    private String info;
    private int code;

    public APIException(String info, int code) {
        this.info = info;
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}