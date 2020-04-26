package com.abdelrahman.banking.errorhandler.domain.chains

import androidx.fragment.app.Fragment
import com.abdelrahman.banking.errorhandler.RetryHandler


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class DomainErrorChain(val chainHead: DomainErrorChainLink) {
    fun execute(throwable: Throwable?,fragment: Fragment,retryHandler: RetryHandler?){
        chainHead.proceed(throwable,fragment,retryHandler)
    }

    companion object{
        fun BUILDER():Builder{
            return Builder()
        }
    }
}