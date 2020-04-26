package com.abdelrahman.reomte.model

import com.google.gson.annotations.SerializedName


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
class ResponseWrapperRemote (
    @SerializedName("account-info") val userInfo: UserInfoRemote,
    @SerializedName("transactions") val transactions: List<TransactionRemote>
)