package com.abdelrahman.banking.di

import android.app.Application
import com.abdelrahman.banking.BankingApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton



/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DomainModule::class,
        DataModule::class,
        RemoteModule::class,
        UserIdModule::class,
        PresentationModule::class,
        AppModule::class,
        FragmentsModule::class
    ]
)
interface BankingAppComponent : AndroidInjector<BankingApp>{
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: Application): Builder

        fun build(): BankingAppComponent
    }
    override fun inject(app: BankingApp)

}