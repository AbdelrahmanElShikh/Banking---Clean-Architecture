package com.abdelrahman.domain.repositories

import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.resource.DomainResource
import io.reactivex.Observable


/**
@author  Abdel-Rahman El-Shikh on 15-Apr-20.
 */
interface BankingRepo {
    fun getUserInfo(userId : String) : Observable<DomainResource<ResponseWrapperDomain>>

    fun getUserTransactions(userId: String,limit : Int) : Observable<DomainResource<ResponseWrapperDomain>>

//    fun getFilteredTransactions(
//        userId: String,
//        credit: Boolean,
//        debit: Boolean,
//        flagged: Boolean
//    ) :Observable<List<TransactionDomain>>
//
//    fun updateTransaction(transaction : TransactionDomain) :Completable
}