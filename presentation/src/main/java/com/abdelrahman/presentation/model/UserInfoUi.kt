package com.abdelrahman.presentation.model


/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
class UserInfoUi(
    val accountNumber: String,
    val displayName: String,
    val address: String,
    val displayableJoinDate: String,
    val premiumCustomer: Boolean,
    val accountBalance: Double,
    val accountType: String,
    val unbilledTransactionCount: Int,
    val isEligibleForUpgrade: Boolean
)