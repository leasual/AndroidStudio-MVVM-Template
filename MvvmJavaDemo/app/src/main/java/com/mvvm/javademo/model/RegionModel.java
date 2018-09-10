package com.mvvm.javademo.model;

import java.io.Serializable;
import java.util.Map;

/**
 * GetSupportedRegion 返回的数据模型
 * @author rainy.liao
 * @date 2018/8/14
 */

public class RegionModel implements Serializable {

    private Map<String,String> region;

    public Map<String, String> getRegion() {
        return region;
    }

    public void setRegion(Map<String, String> region) {
        this.region = region;
    }
}
