package com.abdelrahman.data.model


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
data class ResponseWrapperData(
    val userInfo: UserInfoData,
    val transactions: List<TransactionData>
)