package com.abdelrahman.data.model


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
data class UserInfoData(
    val accountNumber: String,
    val displayName: String,
    val address: String,
    val displayableJoinDate: String,
    val premiumCustomer: Boolean,
    val accountBalance: Double,
    val accountType: String,
    val unbilledTransactionCount: Int
)