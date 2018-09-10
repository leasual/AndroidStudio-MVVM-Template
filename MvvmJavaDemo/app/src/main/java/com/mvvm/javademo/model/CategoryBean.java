package com.mvvm.javademo.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author rainy.liao
 * @date 2018/8/30
 */

public class CategoryBean {
    @SerializedName("_id")
    private String id;
    @SerializedName("en_name")
    private String enName;
    @SerializedName("name")
    private String name;
    @SerializedName("rank")
    private String rank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
