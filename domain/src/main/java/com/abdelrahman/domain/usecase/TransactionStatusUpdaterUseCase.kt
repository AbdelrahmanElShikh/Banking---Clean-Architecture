package com.abdelrahman.domain.usecase


/**
 *@author: Abdel-Rahman El-Shikh on 15-Apr-20.
 */
//class TransactionStatusUpdaterUseCase constructor(
//    private val bankingRepo: BankingRepo,
//    @Background backgroundScheduler: Scheduler,
//    @Foreground foregroundScheduler: Scheduler
//) : CompletableUseCase<TransactionDomain>(
//    backgroundScheduler,
//    foregroundScheduler
//) {
//
//    override fun generateCompletable(input: TransactionDomain?): Completable {
//        if (input == null) {
//            throw IllegalArgumentException("TransactionStatusUpdaterUseCase Parameter can't be null")
//        }
//        return bankingRepo.updateTransaction(input)
//    }
//
//
//}