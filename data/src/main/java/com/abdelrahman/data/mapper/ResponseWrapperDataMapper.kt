package com.abdelrahman.data.mapper

import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.domain.entities.ResponseWrapperDomain
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class ResponseWrapperDataMapper @Inject constructor(
    private val userInfoDataMapper: UserInfoDataMapper,
    private val transactionDataMapper:TransactionDataMapper
):Mapper<ResponseWrapperData,ResponseWrapperDomain>() {
    override fun map(input: ResponseWrapperData?): ResponseWrapperDomain {
        return ResponseWrapperDomain(
            userInfoDataMapper.map(input!!.userInfo),
            transactionDataMapper.map(input.transactions)
        )
    }
}