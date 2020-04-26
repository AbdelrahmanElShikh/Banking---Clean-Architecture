package com.abdelrahman.data.repository

import com.abdelrahman.data.mapper.DataResourceMapper
import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.repositories.BankingRepo
import com.abdelrahman.domain.resource.DomainResource
import io.reactivex.Observable
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
class BankingRepositoryImp @Inject constructor(
    private val mapper:DataResourceMapper<ResponseWrapperData,ResponseWrapperDomain>,
    private val remoteDataSource: RemoteDataSource
) : BankingRepo {
    override fun getUserInfo(userId: String): Observable<DomainResource<ResponseWrapperDomain>> {
//        val userInfoObservable = localDataSource.getUserInfo(id)
//            .map { userInfoMapper.from(it) }

        return remoteDataSource.getUserInfo(userId)
            .map {response->
                mapper.map(response)
            }

    }

    override fun getUserTransactions(
        userId: String,
        limit: Int
    ): Observable<DomainResource<ResponseWrapperDomain>> {
        return remoteDataSource.getUserTransactions(userId,limit)
            .map { transactions -> mapper.map(transactions) }
    }

//    override fun getUserTransactions(
//        userId: String,
//        limit: Int
//    ): Observable<List<TransactionDomain>> {
//
//        return remoteDataSource.getUserTransactions(userId, limit)
//            .map { transactions -> transactions.map { transactionMapper.map(it) } }
//            .onErrorResumeNext(Observable.empty())
//    }

//    override fun getFilteredTransactions(
//        userId: String,
//        credit: Boolean,
//        debit: Boolean,
//        flagged: Boolean
//    ): Observable<List<TransactionDomain>> {
//        return localDataSource.getFilteredTransactions(
//            userId, credit, debit, flagged
//        ).map { transactions -> transactions.map { transactionMapper.from(it) } }
//    }
//
//    override fun updateTransaction(transaction: TransactionDomain): Completable {
//        return localDataSource.updateTransaction(
//            transactionMapper.to(transaction)
//        )
//    }

}