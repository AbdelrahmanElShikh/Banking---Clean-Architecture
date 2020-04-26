package com.abdelrahman.presentation.viewmodels

import androidx.core.util.Preconditions
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer


/**
 *@author: Abdel-Rahman El-Shikh on 26-Apr-20.
 */
open class BaseViewModel : ViewModel() {
    private var disposables: CompositeDisposable = CompositeDisposable()

    protected fun <T> execute(loadingConsumer : Consumer<Disposable>, successConsumer : Consumer<T>, throwableConsumer : Consumer<Throwable>, useCase : Observable<T>){
        Preconditions.checkNotNull(successConsumer)
        Preconditions.checkNotNull(throwableConsumer)
        val observable = useCase
            .doOnSubscribe(loadingConsumer)
        addDisposable(observable.subscribe(successConsumer,throwableConsumer))
    }

    protected fun addDisposable(disposable: Disposable?) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable!!)
    }

    fun dispose(){
        if(!disposables.isDisposed)
            disposables.dispose()
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }
}