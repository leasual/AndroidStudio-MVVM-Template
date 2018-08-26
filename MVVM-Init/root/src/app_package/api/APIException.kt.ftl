package ${packageName}.api

/**
 * Created by james on 2018/8/24.
 */
class APIException(val info: String, val code: Boolean) : Exception() {

}