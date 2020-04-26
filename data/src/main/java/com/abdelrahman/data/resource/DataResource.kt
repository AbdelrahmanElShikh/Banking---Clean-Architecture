package com.abdelrahman.data.resource


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class DataResource<T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val errorCode: Int,
    val errorExtras : Map<String,Any>?
) {

    companion object {
        fun <T> success(data: T): DataResource<T> {
            return DataResource(Status.SUCCESS, data, null, 0,null)
        }

        fun <T> error(
            msg: String,
            errorCode: Int,
            errorExtras: Map<String, Any>?
        ): DataResource<T> {
            return DataResource(Status.ERROR, null, msg, errorCode,errorExtras)
        }
    }

    enum class Status {
        SUCCESS, ERROR
    }
}