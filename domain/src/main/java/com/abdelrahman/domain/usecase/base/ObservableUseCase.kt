package com.abdelrahman.domain.usecase.base

import com.abdelrahman.domain.resource.DomainResource
import io.reactivex.Observable
import io.reactivex.Scheduler


/**
 *@author  Abdel-Rahman El-Shikh on 15-Apr-20.
 */
abstract class ObservableUseCase<in INPUT, T> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {
    protected abstract fun generateObservable(input: INPUT? = null): Observable<DomainResource<T>>

    fun buildUseCase(input: INPUT? = null): Observable<DomainResource<T>> {
        return generateObservable(input = input)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }
}