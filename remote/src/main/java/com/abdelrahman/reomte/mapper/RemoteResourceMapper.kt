package com.abdelrahman.reomte.mapper

import com.abdelrahman.data.resource.DataResource
import com.abdelrahman.reomte.resource.ErrorResponse
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class RemoteResourceMapper<IN, OUT> @Inject constructor(
    private val mapper: Mapper<IN, OUT>
) {
    @Throws(IOException::class)
    fun map(response: Response<IN>): DataResource<OUT> {
        return when (response.code()) {
            200 -> DataResource.success(mapper.map(response.body()!!))
            401, 429, 500 -> DataResource.error(
                response.message(),
                response.code(),
                null
            )
            else -> {
                val errorResponse: ErrorResponse =
                    Gson().fromJson(response.errorBody()!!.string(), ErrorResponse::class.java)
                return DataResource.error(
                    errorResponse.errorMsg,
                    response.code(),
                    errorResponse.extras
                )
            }
        }
    }


    @Throws(IOException::class)
    fun mapList(response: Response<List<IN>>): DataResource<List<OUT>> {
        return when (response.code()) {
            200 -> DataResource.success(mapper.map(response.body()!!))
            401, 429, 500 -> DataResource.error(
                response.message(),
                response.code(),
                null
            )
            else -> {
                val errorResponse: ErrorResponse =
                    Gson().fromJson(response.errorBody()!!.string(), ErrorResponse::class.java)
                return DataResource.error(
                    errorResponse.errorMsg,
                    response.code(),
                    errorResponse.extras
                )
            }
        }
    }

}