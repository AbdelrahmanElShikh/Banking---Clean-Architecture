package com.abdelrahman.banking.errorhandler.domain.handlers

import androidx.fragment.app.Fragment
import com.abdelrahman.banking.errorhandler.RetryHandler
import com.abdelrahman.banking.errorhandler.domain.chains.DomainErrorChainLink
import com.abdelrahman.banking.utils.RetryConnectionErrorSnackBar
import java.net.SocketException
import java.net.UnknownHostException


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class InternetConnectionHandler : DomainErrorChainLink() {

    companion object{
        fun isConnectionThrowable(throwable: Throwable):Boolean{
            return throwable is UnknownHostException || throwable is SocketException
        }
    }

    override fun handleError(
        throwable: Throwable?,
        fragment: Fragment,
        retryHandler: RetryHandler?
    ): Boolean {
        if(isConnectionThrowable(throwable!!)){

            RetryConnectionErrorSnackBar.show(retryHandler,fragment)
            return true
        }
        return false
    }
}