package com.abdelrahman.reomte.api

import com.abdelrahman.reomte.model.ResponseWrapperRemote
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
interface ApiServices {
    @GET("assets/bankassist/{identifier}.json")
    fun getUserInformation(@Path("identifier") userId :  String): Single<Response<ResponseWrapperRemote>>

}