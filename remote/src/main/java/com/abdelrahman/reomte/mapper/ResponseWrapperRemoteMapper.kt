package com.abdelrahman.reomte.mapper

import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.reomte.model.ResponseWrapperRemote
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class ResponseWrapperRemoteMapper @Inject constructor(
    private val userInfoRemoteMapper: UserInfoRemoteMapper,
    private val transactionRemoteMapper:TransactionRemoteMapper
    ) :
    Mapper<ResponseWrapperRemote, ResponseWrapperData>() {
    override fun map(input: ResponseWrapperRemote): ResponseWrapperData {
        return ResponseWrapperData(userInfoRemoteMapper.map(input.userInfo),
            transactionRemoteMapper.map(input.transactions))
    }

}