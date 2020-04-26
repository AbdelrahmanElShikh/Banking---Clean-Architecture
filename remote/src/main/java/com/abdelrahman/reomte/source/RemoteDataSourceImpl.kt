package com.abdelrahman.reomte.source

import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.data.repository.RemoteDataSource
import com.abdelrahman.data.resource.DataResource
import com.abdelrahman.reomte.api.ApiServices
import com.abdelrahman.reomte.mapper.RemoteResourceMapper
import com.abdelrahman.reomte.model.ResponseWrapperRemote
import io.reactivex.Observable
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */
class RemoteDataSourceImpl @Inject constructor(
    private val mapper: RemoteResourceMapper<ResponseWrapperRemote, ResponseWrapperData>,
    private val apiServices: ApiServices
) : RemoteDataSource {
    override fun getUserInfo(userId: String): Observable<DataResource<ResponseWrapperData>> {
        return apiServices.getUserInformation(userId)
            .map { response ->
                println("Remote Invoked")
                mapper.map(response)
            }
            .toObservable()
    }

    override fun getUserTransactions(
        userId: String,
        limit: Int
    ): Observable<DataResource<ResponseWrapperData>> {
        return apiServices.getUserInformation(userId)
            .map { response ->
                mapper.map(response)
            }.toObservable()
    }
}