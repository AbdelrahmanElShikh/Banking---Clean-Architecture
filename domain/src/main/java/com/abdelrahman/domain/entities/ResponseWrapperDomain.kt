package com.abdelrahman.domain.entities


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class ResponseWrapperDomain(
    val userInfo: UserInfoDomain,
    val transactions: List<TransactionDomain>
)