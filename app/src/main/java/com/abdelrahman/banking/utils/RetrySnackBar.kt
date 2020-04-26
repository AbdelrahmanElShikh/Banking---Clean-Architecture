package com.abdelrahman.banking.utils

import androidx.fragment.app.Fragment
import com.abdelrahman.banking.R
import com.abdelrahman.banking.errorhandler.RetryHandler
import com.google.android.material.snackbar.Snackbar


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class RetrySnackBar {
    companion object {
        fun show(retryHandler: RetryHandler, fragment: Fragment, msg: String) {
            DynamicSnackBar.make(fragment.view, msg, Snackbar.LENGTH_INDEFINITE)
                .setAction(fragment.context!!.getString(R.string.retry_button_title)) {
                    if (fragment.view != null)
                        retryHandler.onRetry()
                }
                .show()
        }

        fun show(retryHandler: RetryHandler?, fragment: Fragment, msgRes: Int) {
            DynamicSnackBar.make(
                fragment.view,
                fragment.context!!.getString(msgRes),
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction(fragment.context!!.getString(R.string.retry_button_title)) {
                    if (fragment.view != null)
                        retryHandler?.onRetry()
                }
                .show()
        }

    }
}