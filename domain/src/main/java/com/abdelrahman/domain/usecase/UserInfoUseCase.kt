package com.abdelrahman.domain.usecase

import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.qualifiers.Background
import com.abdelrahman.domain.qualifiers.Foreground
import com.abdelrahman.domain.repositories.BankingRepo
import com.abdelrahman.domain.resource.DomainResource
import com.abdelrahman.domain.usecase.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 15-Apr-20.
 */
class UserInfoUseCase @Inject constructor(
    private val bankingRepo: BankingRepo,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) : ObservableUseCase<String, ResponseWrapperDomain>(
    backgroundScheduler = backgroundScheduler,
    foregroundScheduler = foregroundScheduler
) {
    override fun generateObservable(input: String?): Observable<DomainResource<ResponseWrapperDomain>> {
        if(input == null){
            throw IllegalArgumentException("USER ID CAN'T BE NULL")
        }
        return bankingRepo.getUserInfo(input)
    }
}