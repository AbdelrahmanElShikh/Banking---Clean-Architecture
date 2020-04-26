package com.abdelrahman.banking.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.entities.TransactionDomain
import com.abdelrahman.domain.entities.UserInfoDomain
import com.abdelrahman.presentation.mapper.Mapper
import com.abdelrahman.presentation.mapper.ResponseWrapperUiMapper
import com.abdelrahman.presentation.mapper.TransactionUiMapper
import com.abdelrahman.presentation.mapper.UserInfoUiMapper
import com.abdelrahman.presentation.model.ResponseWrapperUi
import com.abdelrahman.presentation.model.TransactionUi
import com.abdelrahman.presentation.model.UserInfoUi
import com.abdelrahman.presentation.viewmodelfactory.ViewModelFactory
import com.abdelrahman.presentation.viewmodels.HomeVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */

@Module
abstract class PresentationModule {

    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeVM::class)
    abstract fun bindsHomeViewModel(homeVM: HomeVM): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(TransactionVM::class)
//    abstract fun bindsTransactionViewModel(transactionVM: TransactionVM): ViewModel

    @Binds
    abstract fun bindsUserInfoMapper(userInfoUiMapper: UserInfoUiMapper): Mapper<UserInfoDomain, UserInfoUi>

    @Binds
    abstract fun bindsTransactionsMapper(transactionUiMapper: TransactionUiMapper): Mapper<TransactionDomain, TransactionUi>

    @Binds
    abstract fun bindsResponseWrapperUiMapper(responseWrapperUiMapper: ResponseWrapperUiMapper) : Mapper<ResponseWrapperDomain, ResponseWrapperUi>
}

