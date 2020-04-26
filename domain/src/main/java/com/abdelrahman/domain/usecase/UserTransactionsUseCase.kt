package com.abdelrahman.domain.usecase

import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.qualifiers.Background
import com.abdelrahman.domain.qualifiers.Foreground
import com.abdelrahman.domain.repositories.BankingRepo
import com.abdelrahman.domain.resource.DomainResource
import com.abdelrahman.domain.usecase.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler


/**
@author  Abdel-Rahman El-Shikh on 15-Apr-20.
 */
class UserTransactionsUseCase constructor(
    private val bankingRepo: BankingRepo,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) : ObservableUseCase<UserTransactionsUseCase.Params, ResponseWrapperDomain>(
    backgroundScheduler = backgroundScheduler,
    foregroundScheduler = foregroundScheduler
) {
    override fun generateObservable(input: Params?): Observable<DomainResource<ResponseWrapperDomain>> {
        if (input == null) {
            throw IllegalArgumentException("UserTransactionsUseCase parameters can't be null")
        }
        return bankingRepo.getUserTransactions(input.userId, input.limit)
    }

    data class Params(val userId: String, val limit: Int)

}