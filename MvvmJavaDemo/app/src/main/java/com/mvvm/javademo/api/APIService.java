package com.mvvm.javademo.api;

import com.mvvm.javademo.model.BaseResponse;
import com.mvvm.javademo.model.RegionModel;
import com.mvvm.javademo.util.Constants;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 *
 * @author james.li
 * @date 2018/8/21
 */

public interface APIService {

    @FormUrlEncoded
    @POST(Constants.SUF_URL)
    Flowable<BaseResponse<RegionModel>> getSupportedRegion(@FieldMap Map<String, Object> map);
}