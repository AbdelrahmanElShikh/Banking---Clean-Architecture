package com.abdelrahman.data.repository

import com.abdelrahman.data.model.TransactionData
import com.abdelrahman.data.model.UserInfoData
import io.reactivex.Completable
import io.reactivex.Observable


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
interface LocalDataSource {
    fun getUserInfo(userId: String): Observable<UserInfoData>

    fun saveUserInfo(userInfoData: UserInfoData)

    fun getUserTransactions(userId: String, limit: Int): Observable<List<TransactionData>>

    fun saveUserTransactions(userId: String, transactions: List<TransactionData>)

    fun getTransactions(transActionId: String): Observable<TransactionData>

    fun getFilteredTransactions(
        userId: String,
        credit: Boolean?,
        debit: Boolean?,
        flagged: Boolean?
    ): Observable<List<TransactionData>>

    fun updateTransaction(transactionData: TransactionData): Completable

}