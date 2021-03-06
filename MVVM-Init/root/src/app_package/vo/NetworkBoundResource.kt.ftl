package ${packageName}.vo

import android.util.Log
import ${packageName}.App
import ${packageName}.api.APIException
import ${packageName}.extension.RetryWithDelay
import ${packageName}.extension.ioMain
import ${packageName}.extension.isNetworkAvailable
import ${packageName}.extension.toast
import ${packageName}.model.BaseResponse
import ${packageName}.model.filterData
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.internal.operators.flowable.FlowableCreate
import retrofit2.HttpException

/**
 * Created by james on 2018/8/22.
 */

abstract class NetworkBoundResource<ResultType, RequestType>(val app: App) {

    private val flowableOnSubscribe: FlowableOnSubscribe<ResultType>
    init {

        //whether should fetch from network
        val networkState = app.applicationContext.isNetworkAvailable()
        @Suppress("LeakingThis")
        when (networkState) {
            true -> {
                flowableOnSubscribe = if (shouldLoadFromCache()) {
                    FlowableOnSubscribe { emitter ->
                        Log.d("test", "get data from cache")
                        val cacheData = loadFromDB()
                        emitter.onNext(cacheData!!)
                        if (shouldFetch(cacheData)) {
                            fetchFromNetwork(emitter)
                        }
                    }
                }else {
                    FlowableOnSubscribe { emitter ->
                        fetchFromNetwork(emitter)
                    }
                }
            }
            else -> {
                flowableOnSubscribe = if (shouldLoadFromCache()) {
                    FlowableOnSubscribe { emitter ->
                        emitter.onNext(loadFromDB()!!)
                    }
                }else {
                    FlowableOnSubscribe { emitter ->
                        emitter.onComplete()
                    }
                }
                app.applicationContext.toast("网络未连接，请检查网络再重试")
            }
        }
    }

    private fun fetchFromNetwork(emitter: FlowableEmitter<ResultType>) {
        callApi()
                .flatMap { (it as BaseResponse<*>).filterData() }
                .retryWhen(RetryWithDelay(3))
                .ioMain()
                .subscribe(
                        {
                            data ->
                            emitter.onNext(data.data as ResultType)
                            Log.d("test", "get data from network")
                        },
                        {
                            throwable ->
                            when (throwable) {
                                is HttpException -> {
                                    if (throwable.response().code() == 404) {
                                        app.applicationContext.toast("服务器地址不存在")
                                    } else {
                                        app.applicationContext.toast("网络不给力，请重试")
                                    }
                                }
                                is APIException -> {
                                    app.applicationContext.toast(throwable.info)
                                }
                                else -> {
                                    app.applicationContext.toast("数据异常，请重试")
                                }
                            }
                            emitter.onError(throwable)
                        },
                        {
                            emitter.onComplete()
                        }
                )
    }

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun shouldLoadFromCache(): Boolean

    protected abstract fun loadFromDB(): ResultType?

    protected abstract fun cache(data: ResultType)

    protected abstract fun callApi(): Flowable<RequestType>

    fun asFlowable(): Flowable<ResultType> {
        return FlowableCreate(flowableOnSubscribe, BackpressureStrategy.LATEST)
                .ioMain()
    }
}