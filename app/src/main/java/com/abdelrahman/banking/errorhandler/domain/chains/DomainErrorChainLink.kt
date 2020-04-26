package com.abdelrahman.banking.errorhandler.domain.chains

import androidx.fragment.app.Fragment
import com.abdelrahman.banking.errorhandler.ChainLink
import com.abdelrahman.banking.errorhandler.RetryHandler


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
abstract class DomainErrorChainLink : ChainLink<DomainErrorChainLink>() {
    fun proceed(throwable: Throwable?,fragment: Fragment,retryHandler: RetryHandler?){
        if(!handleError(throwable = throwable,fragment = fragment,retryHandler = retryHandler))
            nextLink.proceed(throwable,fragment,retryHandler)
    }
    protected abstract fun handleError(throwable: Throwable?,fragment: Fragment,retryHandler: RetryHandler?):Boolean
}