package com.abdelrahman.presentation.mapper

import com.abdelrahman.domain.entities.UserInfoDomain
import com.abdelrahman.presentation.model.UserInfoUi
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
class UserInfoUiMapper @Inject constructor() : Mapper<UserInfoDomain, UserInfoUi>() {
    override fun map(input: UserInfoDomain?): UserInfoUi {
        return UserInfoUi(
            input!!.accountNumber,
            input.displayName,
            input.address,
            input.displayableJoinDate,
            input.premiumCustomer,
            input.accountBalance,
            input.accountType,
            input.unbilledTransactionCount,
            input.isEligibleForUpgrade
        )
    }

}