package com.abdelrahman.domain.usecase


/**
 *@author: Abdel-Rahman El-Shikh on 15-Apr-20.
 */
//class FilterTransactionsUseCase constructor(
//    private val bankingRepo: BankingRepo,
//    @Background backgroundScheduler: Scheduler,
//    @Foreground foregroundScheduler: Scheduler
//) : ObservableUseCase<FilterTransactionsUseCase.Params, List<TransactionDomain>>(
//    backgroundScheduler,
//    foregroundScheduler
//) {
//    override fun generateObservable(input: Params?): Observable<List<TransactionDomain>> {
//        if (input == null) {
//            throw IllegalArgumentException("FilterTransactionUseCase params can't be null")
//        }
//        return bankingRepo.getFilteredTransactions(
//            userId = input.userId,
//            credit = input.credit,
//            debit = input.debit,
//            flagged = input.flagged
//        )
//    }
//
//    data class Params(
//        val userId: String,
//        val credit: Boolean,
//        val debit: Boolean,
//        val flagged: Boolean
//    )
//}