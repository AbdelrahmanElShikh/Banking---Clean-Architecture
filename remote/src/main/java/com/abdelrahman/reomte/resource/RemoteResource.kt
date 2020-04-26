package com.abdelrahman.reomte.resource


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class RemoteResource<T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val errorCode: Int,
    val errorExtras : Map<String,Any>?
) {

    companion object {
        fun <T> success(data: T): RemoteResource<T> {
            return RemoteResource(Status.SUCCESS, data, null, 0,null)
        }

        fun <T> error(
            msg: String,
            errorCode: Int,
            errorExtras: Map<String, Any>?
        ): RemoteResource<T> {
            return RemoteResource(Status.ERROR, null, msg, errorCode,errorExtras)
        }
    }

    enum class Status {
        SUCCESS, ERROR
    }
}