package com.abdelrahman.data.repository

import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.data.resource.DataResource
import io.reactivex.Observable


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
interface RemoteDataSource {
    fun getUserInfo(userId : String) : Observable<DataResource<ResponseWrapperData>>

    fun getUserTransactions(userId: String,limit : Int) : Observable<DataResource<ResponseWrapperData>>
}