package ${packageName}.vo

import android.util.Log
import ${packageName}.App
import ${packageName}.api.APIException
import ${packageName}.extension.isNetworkAvailable
import ${packageName}.extension.toast
import ${packageName}.model.BaseResponse
import ${packageName}.model.filterData
import ${packageName}.extension.ioMain
import io.reactivex.Flowable
import retrofit2.HttpException

/**
 * Created by james on 2018/8/22.
 */

abstract class NetworkBoundResource<ResultType, RequestType>(val app: App) {

    private val result: Flowable<ResultType>

    init {
        //cache
        val diskFlowable = Flowable.defer {
            loadFromDB()
                    ?.ioMain()
        }
        //network
        @Suppress("UNCHECKED_CAST")
        val networkFlowable = Flowable.defer {
            callApi()
                    .flatMap { (it as BaseResponse<*>).filterData() }
                    .ioMain()
                    .doOnNext {
                        cache(it.data as ResultType)
                    }
                    .onErrorResumeNext { throwable: Throwable ->
                        when (throwable) {
                            is HttpException -> {
                                if (throwable.response().code() == 404) {
                                    //app.applicationContext.toast("")
                                } else {
                                    //app.applicationContext.toast("")
                                }
                            }
                            is APIException -> {
                                //app.applicationContext.toast(throwable.info)
                            }
                            else -> {
                                //app.applicationContext.toast("")
                            }
                        }                       
                        Flowable.empty()
                    }
        }.flatMap { Flowable.just(it.data as ResultType) }

        //whether should fetch from network
        val networkState = app.applicationContext.isNetworkAvailable()
        @Suppress("LeakingThis")
        when (networkState) {
            true -> result = shouldFetch(null).let { networkFlowable } ?: diskFlowable
            else -> {
                //app.applicationContext.toast("")
                result = Flowable.empty()
            }
        }
    }

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDB(): Flowable<ResultType>?

    protected abstract fun cache(data: ResultType)

    protected abstract fun callApi(): Flowable<RequestType>

    fun asFlowable() = result
}