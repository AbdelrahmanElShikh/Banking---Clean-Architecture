package com.abdelrahman.banking.di

import com.abdelrahman.data.model.ResponseWrapperData
import com.abdelrahman.data.model.TransactionData
import com.abdelrahman.data.model.UserInfoData
import com.abdelrahman.data.repository.RemoteDataSource
import com.abdelrahman.reomte.api.ApiServices
import com.abdelrahman.reomte.mapper.Mapper
import com.abdelrahman.reomte.mapper.ResponseWrapperRemoteMapper
import com.abdelrahman.reomte.mapper.TransactionRemoteMapper
import com.abdelrahman.reomte.mapper.UserInfoRemoteMapper
import com.abdelrahman.reomte.model.ResponseWrapperRemote
import com.abdelrahman.reomte.model.TransactionRemote
import com.abdelrahman.reomte.model.UserInfoRemote
import com.abdelrahman.reomte.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */

@Module(includes = [RemoteModule.Binders::class])
class RemoteModule {

    @Module
    interface Binders{
        @Binds
        fun bindsRemoteSource(remoteDataSourceImpl: RemoteDataSourceImpl) : RemoteDataSource

        @Binds
        fun bindsUserInfoMapper(userInfoMapper : UserInfoRemoteMapper) : Mapper<UserInfoRemote,UserInfoData>

        @Binds
        fun bindsTransactionMapper(transactionRemoteMapper: TransactionRemoteMapper) : Mapper<TransactionRemote,TransactionData>

        @Binds
        fun bindsResponseWrapper(responseWrapperRemoteMapper: ResponseWrapperRemoteMapper) : Mapper<ResponseWrapperRemote,ResponseWrapperData>
    }

    @Provides
    fun provideApiService(retrofit: Retrofit):ApiServices = retrofit.create(ApiServices::class.java)

    @Provides
    fun providesRetrofit():Retrofit=
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://drulabs.github.io/static/")
            .build()
}