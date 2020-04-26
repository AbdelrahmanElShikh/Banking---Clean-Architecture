package com.abdelrahman.data.mapper

import com.abdelrahman.data.model.UserInfoData
import com.abdelrahman.domain.entities.UserInfoDomain
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
class UserInfoDataMapper @Inject constructor():Mapper<UserInfoData,UserInfoDomain> (){
    override fun map(input: UserInfoData?): UserInfoDomain {
        return UserInfoDomain(
            input!!.accountNumber,
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