package com.abdelrahman.banking.di

import com.abdelrahman.data.mapper.Mapper
import com.abdelrahman.data.mapper.ResponseWrapperDataMapper
import com.abdelrahman.data.mapper.TransactionDataMapper
import com.abdelrahman.data.mapper.UserInfoDataMapper
import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.data.model.TransactionData
import com.abdelrahman.data.model.UserInfoData
import com.abdelrahman.data.repository.BankingRepositoryImp
import com.abdelrahman.domain.entities.ResponseWrapperDomain
import com.abdelrahman.domain.entities.TransactionDomain
import com.abdelrahman.domain.entities.UserInfoDomain
import com.abdelrahman.domain.repositories.BankingRepo
import dagger.Binds
import dagger.Module


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */

@Module
abstract class DataModule {
    @Binds
    abstract fun bindsRepository(repoImp : BankingRepositoryImp) : BankingRepo


    @Binds
    abstract fun bindsUserMapper(userMapper : UserInfoDataMapper) : Mapper<UserInfoData,UserInfoDomain>

    @Binds
    abstract fun bindsTransactionsMapper(transactionsMapper : TransactionDataMapper) : Mapper<TransactionData,TransactionDomain>

    @Binds
    abstract fun bindsResponseWrapperDataMapper(responseWrapperDataMapper: ResponseWrapperDataMapper) : Mapper<ResponseWrapperData,ResponseWrapperDomain>
}