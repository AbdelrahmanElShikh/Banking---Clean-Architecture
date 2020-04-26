package com.abdelrahman.banking.di

import android.app.Application
import android.content.Context
import com.abdelrahman.banking.MainActivity
import com.abdelrahman.banking.TransactionsActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */

@Module
abstract class AppModule {
    @Binds
    abstract fun bindContext(application: Application):Context

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeTransactionListActivity() : TransactionsActivity
}