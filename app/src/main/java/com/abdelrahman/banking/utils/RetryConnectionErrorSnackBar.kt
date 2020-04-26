package com.abdelrahman.banking.utils

import androidx.fragment.app.Fragment
import com.abdelrahman.banking.R
import com.abdelrahman.banking.errorhandler.RetryHandler


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class RetryConnectionErrorSnackBar {
    companion object{
        fun show(retryHandler: RetryHandler?,fragment: Fragment){
            RetrySnackBar.show(retryHandler,fragment, R.string.no_iternet_connection_msg)
        }
    }
}