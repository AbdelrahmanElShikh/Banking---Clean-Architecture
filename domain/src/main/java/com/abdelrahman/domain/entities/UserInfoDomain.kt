package com.abdelrahman.domain.entities


/**
@author  Abdel-Rahman El-Shikh on 15-Apr-20.
 */
class UserInfoDomain(
    val accountNumber: String,
    val displayName: String,
    val address: String,
    val displayableJoinDate: String,
    val premiumCustomer: Boolean,
    val accountBalance: Double,
    val accountType: String,
    val unbilledTransactionCount: Int
) {
    companion object {
        private const val ACCOUNT_UPGRADE_BALANCE = 30000 // $30,000
    }

    val isEligibleForUpgrade: Boolean
        get() = accountBalance >= ACCOUNT_UPGRADE_BALANCE
}