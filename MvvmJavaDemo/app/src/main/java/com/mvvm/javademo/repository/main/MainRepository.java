package com.mvvm.javademo.repository.main;

import com.mvvm.javademo.App;
import com.mvvm.javademo.base.BaseRepository;
import com.mvvm.javademo.model.BaseResponse;
import com.mvvm.javademo.model.RegionModel;
import com.mvvm.javademo.vo.NetworkBoundResource;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by james on 2018/8/21.
 */

@Singleton
public class MainRepository extends BaseRepository {
    private App app;
    @Inject
    public MainRepository(App app) {
        this.app = app;
    }


    public Flowable<RegionModel> getSupportRegion(Map<String, Object> map){
        return new NetworkBoundResource<RegionModel, RegionModel>(app) {

            @Override
            protected boolean shouldFetch(RegionModel data) {
                return true;
            }

            @Override
            protected boolean shouldLoadFromCache() {
                return false;
            }

            @Override
            protected RegionModel loadFromDB() {
                return null;
            }

            @Override
            protected void cache(RegionModel data) {

            }

            @Override
            protected Flowable<BaseResponse<RegionModel>> callApi() {
                return apiService.getSupportedRegion(map);
            }
        }.asFlowable();
    }
}