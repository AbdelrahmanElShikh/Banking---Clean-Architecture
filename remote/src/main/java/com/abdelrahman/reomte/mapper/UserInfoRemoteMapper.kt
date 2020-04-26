package com.abdelrahman.reomte.mapper

import com.abdelrahman.data.model.UserInfoData
import com.abdelrahman.reomte.model.UserInfoRemote
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
class UserInfoRemoteMapper @Inject constructor() : Mapper<UserInfoRemote, UserInfoData> (){
    override fun map(input: UserInfoRemote): UserInfoData {
        return UserInfoData(
            input.accountNumber,
            input.displayName,
            input.address,
            input.displayableJoinDate,
            input.premiumCustomer,
            input.accountBalance,
            input.accountType,
            input.unbilledTransactionCount
        )
    }

}