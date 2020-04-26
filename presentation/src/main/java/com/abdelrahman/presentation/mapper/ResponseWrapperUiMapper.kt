package com.abdelrahman.presentation.mapper

import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.presentation.model.ResponseWrapperUi
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 26-Apr-20.
 */
class ResponseWrapperUiMapper @Inject constructor(
    private val userInfoUiMapper: UserInfoUiMapper,
    private val transactionUiMapper:TransactionUiMapper
) : Mapper<ResponseWrapperDomain, ResponseWrapperUi>() {
    override fun map(input: ResponseWrapperDomain?): ResponseWrapperUi {
        return ResponseWrapperUi(
            userInfo = userInfoUiMapper.map(input!!.userInfo),
            transactions = transactionUiMapper.map(input.transactions)
        )
    }

}