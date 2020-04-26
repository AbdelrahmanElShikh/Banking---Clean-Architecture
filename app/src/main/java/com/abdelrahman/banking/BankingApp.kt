package com.abdelrahman.banking

import com.abdelrahman.banking.di.DaggerBankingAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */
class BankingApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerBankingAppComponent.builder().application(this).build()
    }
}
