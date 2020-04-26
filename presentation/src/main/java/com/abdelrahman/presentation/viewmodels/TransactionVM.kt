package com.abdelrahman.presentation.viewmodels




/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
//class TransactionVM @Inject internal constructor(
//    @UserId private val userId: String,
//    private val transactionUiMapper: Mapper<TransactionDomain, TransactionUi>,
//    private val filtertransactionsUseCase: FilterTransactionsUseCase,
//    private val transactionStatusUpdaterUseCase: TransactionStatusUpdaterUseCase,
//    private val userTransactionsUseCase: UserTransactionsUseCase
//) : ViewModel() {
//
//    private val filterRequestLiveData = MutableLiveData<FilterTransactionsUseCase.Params>()
//    private var filterRequest = FilterTransactionsUseCase.Params(
//        userId = userId,
//        credit = true,
//        debit = true,
//        flagged = true
//    )
//
//    private val disposable = CompositeDisposable()
//    private val transactionMediator = MediatorLiveData<Resource<List<TransactionUi>>>()
//    val transactionListSource: LiveData<Resource<List<TransactionUi>>>
//        get() = transactionMediator
//
//    private val transactionsResource =
//        userTransactionsUseCase.buildUseCase(UserTransactionsUseCase.Params(userId, 2))
//            .map { transactionsDomain ->
//                transactionsDomain.map {
//                    transactionUiMapper.from(it)
//                }
//            }.map { Resource.success(it) }
//            .startWith(Resource.loading())
//            .onErrorResumeNext(Function {
//                Observable.just(Resource.error(it.localizedMessage))
//            }).toFlowable(BackpressureStrategy.LATEST)
//            .toLiveData()
//    /**
//     * Why we used switchMap here
//     * every time the value of filterRequestLiveData change,
//     * filtertransactionsUseCase.buildUseCase() method will be called,
//     * and this method returns LiveData, so every time this livedata change the value of
//     * filterTransactions will be change to be as the LiveData returned from filtertransactionsUseCase.buildUseCase.
//     */
//
//    private val filteredTransactions = Transformations.switchMap(filterRequestLiveData) { input ->
//        filtertransactionsUseCase.buildUseCase(input) // returns LiveData
//            .map { transactionsDomain ->
//                transactionsDomain.map {
//                    transactionUiMapper.from(it)
//                }
//            }.map { Resource.success(it) }
//            .startWith(Resource.loading())
//            .onErrorResumeNext(Function {
//                Observable.just(Resource.error(it.localizedMessage))
//            }).toFlowable(BackpressureStrategy.LATEST)
//            .toLiveData()
//    }
//
//    init {
//        transactionMediator.addSource(filteredTransactions) {
//            transactionMediator.value = it
//        }
//        transactionMediator.addSource(transactionsResource) {
//            transactionMediator.value = it
//            if (it.status != Status.LOADING) {
//                transactionMediator.removeSource(transactionsResource)
//                resetFilterOptions()
//            }
//        }
//    }
//
//    private fun resetFilterOptions() {
//        filterRequest = filterRequest.copy(credit = false, debit = false, flagged = false)
//        filterRequestLiveData.postValue(filterRequest)
//    }
//
//    /**
//     * ?: takes the right-hand value if the left-hand value is null (the elvis operator)
//     */
//    private fun filterTransactions(
//        credit: Boolean? = true,
//        debit: Boolean? = true,
//        flagged: Boolean? = true
//    ) {
//        filterRequest = filterRequest.copy(
//            credit = credit ?: filterRequest.credit,
//            debit = debit ?: filterRequest.debit,
//            flagged = flagged ?: filterRequest.flagged
//        )
//        filterRequestLiveData.postValue(filterRequest)
//    }
//
//    private fun toggleFlaggedStatus(transactionUi: TransactionUi) {
//        val newTransaction = transactionUiMapper.to(
//            transactionUi.copy(
//                flagged = !transactionUi.flagged
//            )
//        )
//        disposable.add(
//            transactionStatusUpdaterUseCase.buildUseCase(newTransaction)
//                .onErrorComplete()
//                .subscribe()
//        )
//    }
//
//    private fun resetFilters(){
//        transactionMediator.removeSource(transactionsResource)
//        transactionMediator.addSource(transactionsResource) {
//            transactionMediator.value = it
//            if (it.status != Status.LOADING) {
//                transactionMediator.removeSource(transactionsResource)
//                resetFilterOptions()
//            }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        disposable.dispose()
//    }
//
//
//}