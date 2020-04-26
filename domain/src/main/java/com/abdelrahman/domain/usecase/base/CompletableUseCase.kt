package com.abdelrahman.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.Scheduler


/**
 * @author  Abdel-Rahman El-Shikh on 15-Apr-20.
 */
abstract class CompletableUseCase<in Input> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {
    protected abstract fun generateCompletable(input: Input? = null): Completable

    fun buildUseCase(input: Input? = null): Completable {
        return generateCompletable(input = input)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }
}