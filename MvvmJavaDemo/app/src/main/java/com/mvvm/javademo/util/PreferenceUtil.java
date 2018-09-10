package com.mvvm.javademo.util;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 * @date 2018/7/1
 */

public class PreferenceUtil {

    private PreferenceUtil() {
    }

    private static class SingletonHolder {
        private static final PreferenceUtil INSTANCE = new PreferenceUtil();
        private static final Gson gson = new Gson();
    }

    public static PreferenceUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 保存List数据
     * @param key
     * @param dataList
     * @param preferences
     * @param <T>
     */
    public <T> void saveDataList(String key, List<T> dataList, SharedPreferences preferences) {
        if (null == dataList) {
            return;
        }
        preferences.edit().putString(key,
                SingletonHolder.gson.toJson(dataList, new TypeToken<List<T>>(){}.getType())).apply();
    }

    /**
     * 获取List数据
     * @param key
     * @param preferences
     * @param <T>
     * @return
     */
    public <T> List<T> getDataList(String key, SharedPreferences preferences, Class<T> cls) {
        if (preferences.getString(key, "").isEmpty()) {
            return null;
        }
        List<T> list = new ArrayList<>();
        try {
            JsonArray array = new JsonParser().parse(preferences.getString(key, "")).getAsJsonArray();
            for (JsonElement jsonElement : array) {
                list.add(SingletonHolder.gson.fromJson(jsonElement, cls));
            }
        }catch (Exception e) {}
        return list;
    }

    /**
     * 储存对象
     * @param key
     * @param object
     * @param preferences
     * @param cls
     * @param <T>
     */
    public <T> void saveDataObject(String key, T object, SharedPreferences preferences, Class<T> cls) {
        if (null == object) {
            return;
        }
        preferences.edit().putString(key, SingletonHolder.gson.toJson(object, cls)).apply();
    }

    /**
     * 获取储存对象
     * @param key
     * @param preferences
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T getDataObject(String key, SharedPreferences preferences, Class<T> cls) {
        if (preferences.getString(key, "").isEmpty()) {
            return null;
        }
        return SingletonHolder.gson.fromJson(preferences.getString(key, ""), cls);
    }
}
